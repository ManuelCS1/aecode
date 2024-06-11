package ai.aecode.aecode.controllers;
import ai.aecode.aecode.dtos.PruebaDTO;
import ai.aecode.aecode.entities.Prueba;
import ai.aecode.aecode.services.IPruebaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/prueba")
public class PruebaController {


    @Value("${file.upload-dir}")
    private String uploadDir;
    @Autowired
    private IPruebaService ps;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> insert(@RequestPart(value="file", required = false) MultipartFile imagen,
                                         @RequestPart(value = "data", required = false) String dtoJson) {
        if (!imagen.isEmpty()) {
            try {
                Path uploadPath = Paths.get(uploadDir);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                // Verificar si el nombre del archivo es nulo y proporcionar un nombre por defecto
                String originalFilename = imagen.getOriginalFilename();
                if (originalFilename == null || originalFilename.isEmpty()) {
                    originalFilename = "default_" + System.currentTimeMillis() + ".png"; // Cambia la extensión según tu caso
                }
                byte[] bytes = imagen.getBytes();
                Path path = uploadPath.resolve(imagen.getOriginalFilename());
                Files.write(path, bytes);

                // Convertir JSON a DTO
                ObjectMapper objectMapper = new ObjectMapper();
                PruebaDTO dto = objectMapper.readValue(dtoJson, PruebaDTO.class);
                // Convertir DTO a entidad
                ModelMapper modelMapper = new ModelMapper();
                Prueba prueba = modelMapper.map(dto, Prueba.class);
                // Establecer la ruta del archivo en la entidad
                prueba.setPrueba_multimedia(originalFilename);
                ps.insert(prueba);
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el archivo de imagen: " + e.getMessage());
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al insertar el objeto en la base de datos: " + e.getMessage());
            }
        } else {
            return ResponseEntity.badRequest().body("No se proporcionó un archivo válido");
        }
        return null;
    }


    @GetMapping
    public ResponseEntity<List<PruebaDTO>> obtenerDatos(){
        List<PruebaDTO> datos = ps.list().stream()
                .map(prueba -> {
                    PruebaDTO dto = new PruebaDTO();
                    dto.setId_prueba(prueba.getId_prueba());
                    dto.setNombre(prueba.getNombre());
                    dto.setDescripcion(prueba.getDescripcion());
                    dto.setPrueba_multimedia("/prueba/uploads/" + prueba.getPrueba_multimedia());
                    return dto;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(datos);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){ps.delete(id);}

    @GetMapping("/{id}")
    public PruebaDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        PruebaDTO dto=m.map(ps.listId(id),PruebaDTO.class);
        return dto;
    }
    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> update(@RequestPart(value="file", required = false) MultipartFile imagen,
                                         @RequestPart(value = "data", required = false) String dtoJson) throws JsonProcessingException {
        if (!imagen.isEmpty()) {
            try {
                Path uploadPath = Paths.get(uploadDir);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                // Verificar si el nombre del archivo es nulo y proporcionar un nombre por defecto
                String originalFilename = imagen.getOriginalFilename();
                if (originalFilename == null || originalFilename.isEmpty()) {
                    originalFilename = "default_" + System.currentTimeMillis() + ".png"; // Cambia la extensión según tu caso
                }
                byte[] bytes = imagen.getBytes();
                Path path = uploadPath.resolve(imagen.getOriginalFilename());
                Files.write(path, bytes);
                // Convertir JSON a DTO
                ObjectMapper objectMapper = new ObjectMapper();
                PruebaDTO dto = objectMapper.readValue(dtoJson, PruebaDTO.class);
                // Convertir DTO a entidad
                ModelMapper modelMapper = new ModelMapper();
                Prueba prueba = modelMapper.map(dto, Prueba.class);
                // Establecer la ruta del archivo en la entidad
                prueba.setPrueba_multimedia(originalFilename);
                ps.insert(prueba);
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el archivo de imagen: " + e.getMessage());
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al insertar el objeto en la base de datos: " + e.getMessage());
            }
        } else {
            /// Convertir JSON a DTO
            ObjectMapper objectMapper = new ObjectMapper();
            PruebaDTO dto = objectMapper.readValue(dtoJson, PruebaDTO.class);
            // Convertir DTO a entidad
            ModelMapper modelMapper = new ModelMapper();
            Prueba prueba = modelMapper.map(dto, Prueba.class);
            ps.insert(prueba);
            return ResponseEntity.ok("Actualización exitosa");
        }
        return ResponseEntity.ok("Actualización exitosa");
    }
}
