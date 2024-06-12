package ai.aecode.aecode.controllers.StaticTableScript;
import ai.aecode.aecode.dtos.tsscript.ProgLangDTO;
import ai.aecode.aecode.entities.ProgLang;
import ai.aecode.aecode.services.ServTableScript.IProgLangService;
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
@RequestMapping("/proglang")
public class ProgLangController {
    @Value("${file.upload-dir}")
    private String uploadDir;

    @Autowired
    private IProgLangService pS;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> insert(@RequestPart(value="file", required = false) MultipartFile imagen,
                                         @RequestPart(value = "data", required = false) String dtoJson) {
        String originalFilename = null;
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            ProgLangDTO dto= objectMapper.readValue(dtoJson, ProgLangDTO.class);

            String userUploadDir = uploadDir + File.separator + "proglang";
            Path userUploadPath = Paths.get(userUploadDir);
            if (!Files.exists(userUploadPath)) {
                Files.createDirectories(userUploadPath);
            }

            // Manejo del archivo de script
            if (imagen != null && !imagen.isEmpty()) {
                originalFilename = imagen.getOriginalFilename();;
                byte[] bytes = imagen.getBytes();
                Path path = userUploadPath.resolve(originalFilename);
                Files.write(path, bytes);
            }

            // Convertir DTO a entidad
            ModelMapper modelMapper = new ModelMapper();
            ProgLang proglang = modelMapper.map(dto, ProgLang.class);
            // Establecer la ruta del archivo en la entidad
            proglang.setProgLang_imagen("proglang/"+originalFilename);
            pS.insert(proglang);

            return ResponseEntity.ok("Lenguaje de programación guardado correctamente");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el archivo de imagen: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al insertar el objeto en la base de datos: " + e.getMessage());
        }
    }


    @GetMapping
    public ResponseEntity<List<ProgLangDTO>> list(){
        List<ProgLangDTO> datos = pS.list().stream()
                .map(proglang -> {
                    ProgLangDTO dto = new ProgLangDTO();
                    dto.setId_proglang(proglang.getId_proglang());
                    dto.setProglang_name(proglang.getProglang_name());
                    dto.setProgLang_imagen("/uploads/" + proglang.getProgLang_imagen());
                    return dto;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(datos);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){pS.delete(id);}

    @GetMapping("/{id}")
    public ProgLangDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        ProgLangDTO dto=m.map(pS.listId(id),ProgLangDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody ProgLangDTO dto) {
        ModelMapper m = new ModelMapper();
        ProgLang p = m.map(dto, ProgLang.class);
        pS.insert(p);
    }

}
