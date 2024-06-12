package ai.aecode.aecode.controllers;
import ai.aecode.aecode.dtos.ScriptDTO;
import ai.aecode.aecode.entities.Script;
import ai.aecode.aecode.services.IScriptService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/script")
public class ScriptController {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Autowired
    private IScriptService sS;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> insert(@RequestPart(value="Smultimedia", required = false) MultipartFile[] multimedia,
                                         @RequestPart(value="Sscript", required = false) MultipartFile scriptfile,
                                         @RequestPart(value = "Sdata", required = false) String dtoJson) {
        List<String> multimediaFilename = new ArrayList<>();
        String scriptFilename = null;
            try {
                // Convertir JSON a DTO
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.registerModule(new JavaTimeModule());
                ScriptDTO dto = objectMapper.readValue(dtoJson, ScriptDTO.class);

                // Crear carpetas para el usuario
                String userUploadDir = uploadDir + File.separator + dto.getProfile().getId_profile();
                Path userUploadPath = Paths.get(userUploadDir);
                if (!Files.exists(userUploadPath)) {
                    Files.createDirectories(userUploadPath);
                }

                // Manejo del archivo multimedia
                if (multimedia != null) {
                    for (MultipartFile file : multimedia) {
                        if (!file.isEmpty()) {
                            String filename = dto.getProfile().getId_profile() + "_" + file.getOriginalFilename();
                            byte[] bytes = file.getBytes();
                            Path path = userUploadPath.resolve(filename);
                            Files.write(path, bytes);
                            multimediaFilename.add(dto.getProfile().getId_profile() + "/" + filename);
                        }
                    }
                }
                // Manejo del archivo de script
                if (scriptfile != null && !scriptfile.isEmpty()) {
                    scriptFilename = dto.getProfile().getId_profile()+"_"+scriptfile.getOriginalFilename();;
                    byte[] bytes = scriptfile.getBytes();
                    Path path = userUploadPath.resolve(scriptFilename);
                    Files.write(path, bytes);
                }


                // Convertir DTO a entidad
                ModelMapper modelMapper = new ModelMapper();
                Script script = modelMapper.map(dto, Script.class);

                // Establecer la ruta del archivo en la entidad
                script.setScript_multimedia(multimediaFilename);
                script.setScript_file( dto.getProfile().getId_profile() + "/" +scriptFilename);

                sS.insert(script);


                return ResponseEntity.ok("Script guardado correctamente");
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar los archivos: " + e.getMessage());
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al insertar el objeto en la base de datos: " + e.getMessage());
            }
    }

    @GetMapping
    public ResponseEntity<List<ScriptDTO>> list(){
        List<ScriptDTO> datos = sS.list().stream()
                .map(prueba -> {
                    ScriptDTO dto = new ScriptDTO();
                    dto.setId_script(prueba.getId_script());
                    dto.setProglang(prueba.getProglang());
                    dto.setPlan(prueba.getPlan());
                    dto.setCurrency(prueba.getCurrency());
                    dto.setSoftware(prueba.getSoftware());
                    dto.setTag(prueba.getTag());
                    dto.setProfile(prueba.getProfile());
                    dto.setScript_name(prueba.getScript_name());
                    dto.setScript_description(prueba.getScript_description());
                    dto.setScript_price(prueba.getScript_price());

                    List<String> multimediaPaths = prueba.getScript_multimedia().stream()
                            .map(path -> "/uploads/" + path)
                            .collect(Collectors.toList());
                    dto.setScript_multimedia(multimediaPaths);

                    dto.setScript_file("/uploads/" + prueba.getScript_file());
                    dto.setScript_date(prueba.getScript_date());
                    return dto;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(datos);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){sS.delete(id);}

    @GetMapping("/{id}")
    public ResponseEntity<List<ScriptDTO>> listid(@PathVariable("id")Integer id){
        List<ScriptDTO> datos = sS.list().stream()
                .map(prueba -> {
                    ScriptDTO dto = new ScriptDTO();
                    dto.setId_script(prueba.getId_script());
                    dto.setProglang(prueba.getProglang());
                    dto.setPlan(prueba.getPlan());
                    dto.setCurrency(prueba.getCurrency());
                    dto.setSoftware(prueba.getSoftware());
                    dto.setTag(prueba.getTag());
                    dto.setProfile(prueba.getProfile());
                    dto.setScript_name(prueba.getScript_name());
                    dto.setScript_description(prueba.getScript_description());
                    dto.setScript_price(prueba.getScript_price());

                    List<String> multimediaPaths = prueba.getScript_multimedia().stream()
                            .map(path -> "/uploads/" + path)
                            .collect(Collectors.toList());
                    dto.setScript_multimedia(multimediaPaths);

                    dto.setScript_file("/uploads/" + prueba.getScript_file());
                    dto.setScript_date(prueba.getScript_date());
                    return dto;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(datos);
    }
    @PutMapping
    public void update(@RequestBody ScriptDTO dto) {
        ModelMapper m = new ModelMapper();
        Script s = m.map(dto, Script.class);
        sS.insert(s);
    }

}
