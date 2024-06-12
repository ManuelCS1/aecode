package ai.aecode.aecode.controllers.StaticTableScript;
import ai.aecode.aecode.dtos.tsscript.SoftwareDTO;
import ai.aecode.aecode.entities.Software;
import ai.aecode.aecode.services.ServTableScript.ISoftwareService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/software")
public class SoftwareController {
    @Value("${file.upload-dir}")
    private String uploadDir;
    @Autowired
    private ISoftwareService sS;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> insert(@RequestPart(value="filesoft", required = false) MultipartFile imagensoft,
                                         @RequestPart(value = "data", required = false) String dtoJson) {
        String originalFilename = null;
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                SoftwareDTO dto= objectMapper.readValue(dtoJson, SoftwareDTO.class);

                // Crear carpetas para el software
                String userUploadDir = uploadDir + File.separator + "software";
                Path userUploadPath = Paths.get(userUploadDir);
                if (!Files.exists(userUploadPath)) {
                    Files.createDirectories(userUploadPath);
                }

                // Manejo del archivo de script
                if (imagensoft != null && !imagensoft.isEmpty()) {
                    originalFilename = imagensoft.getOriginalFilename();;
                    byte[] bytes = imagensoft.getBytes();
                    Path path = userUploadPath.resolve(originalFilename);
                    Files.write(path, bytes);
                }

                // Convertir DTO a entidad
                ModelMapper modelMapper = new ModelMapper();
                Software software = modelMapper.map(dto, Software.class);
                // Establecer la ruta del archivo en la entidad
                software.setSoftware_imagen("software/"+originalFilename);
                sS.insert(software);

                return ResponseEntity.ok("Software guardado correctamente");
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el archivo de imagen: " + e.getMessage());
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al insertar el objeto en la base de datos: " + e.getMessage());
            }
    }


    @GetMapping
    public ResponseEntity<List<SoftwareDTO>> list(){
        List<SoftwareDTO> datos = sS.list().stream()
                .map(software -> {
                    SoftwareDTO dto = new SoftwareDTO();
                    dto.setId_software(software.getId_software());
                    dto.setSoftware_name(software.getSoftware_name());
                    dto.setSoftware_imagen("/uploads/" + software.getSoftware_imagen());
                    return dto;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(datos);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){sS.delete(id);}

    @GetMapping("/{id}")
    public SoftwareDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        SoftwareDTO dto=m.map(sS.listId(id),SoftwareDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody SoftwareDTO dto) {
        ModelMapper m = new ModelMapper();
        Software s = m.map(dto, Software.class);
        sS.insert(s);
    }
}
