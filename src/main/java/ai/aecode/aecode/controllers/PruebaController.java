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

    @PostMapping(value="/picture", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> insert(@RequestPart(value="file", required = false) MultipartFile imagen) {
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

                PruebaDTO dto=new PruebaDTO();
                dto.setPrueba_multimedia(imagen.getOriginalFilename());
                ModelMapper m=new ModelMapper();
                Prueba p= m.map(dto,Prueba.class);
                ps.insert(p);
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el archivo de imagen: " + e.getMessage());
            }
        }
        return null;
    }
    @PostMapping("/dto")
    public ResponseEntity<String> insertProfile(@RequestBody PruebaDTO dto) {
        try {
            // Convertir DTO a entidad
            ModelMapper modelMapper = new ModelMapper();
            Prueba prueba = modelMapper.map(dto, Prueba.class);

            // Insertar el objeto en la base de datos
            ps.insert(prueba);

            return ResponseEntity.ok("¨Prueba guardado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al insertar el objeto en la base de datos: " + e.getMessage());
        }
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
    @PutMapping
    public void update(@RequestBody PruebaDTO dto) {
        ModelMapper m = new ModelMapper();
        Prueba p = m.map(dto, Prueba.class);
        ps.insert(p);
    }




}
