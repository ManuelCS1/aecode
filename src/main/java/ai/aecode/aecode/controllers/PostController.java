package ai.aecode.aecode.controllers;

import ai.aecode.aecode.dtos.PostDTO;
import ai.aecode.aecode.dtos.ScriptDTO;
import ai.aecode.aecode.entities.Post;
import ai.aecode.aecode.services.IPostService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/post")
public class PostController {

    @Value("${file.upload-dir}")
    private String uploadDir;


    @Autowired
    private IPostService pS;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> insert(@RequestPart(value="Pmultimedia", required = false) MultipartFile multimedia,
                                         @RequestPart(value = "¨Pdata", required = false) String dtoJson) {
        String multimediaFilename = null;
        try {
            // Manejo del archivo multimedia
            if (multimedia != null && !multimedia.isEmpty()) {
                Path uploadPath = Paths.get(uploadDir);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                multimediaFilename = multimedia.getOriginalFilename();
                byte[] bytes = multimedia.getBytes();
                Path path = uploadPath.resolve(multimedia.getOriginalFilename());

                Files.write(path, bytes);
            }

            // Convertir JSON a DTO
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            PostDTO dto = objectMapper.readValue(dtoJson, PostDTO.class);

            // Convertir DTO a entidad
            ModelMapper modelMapper = new ModelMapper();
            Post post = modelMapper.map(dto, Post.class);

            // Establecer la ruta del archivo en la entidad
            post.setPost_content(multimediaFilename);
            pS.insert(post);
            return ResponseEntity.ok("multimedia guardado correctamente");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el archivo: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al insertar el objeto en la base de datos: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> list(){
        List<PostDTO> datos = pS.list().stream()
                .map(prueba -> {
                    PostDTO dto = new PostDTO();
                    dto.setId_post(prueba.getId_post());
                    dto.setProfile(prueba.getProfile());
                    dto.setPost_date(prueba.getPost_date());
                    dto.setPost_description(prueba.getPost_description());
                    dto.setPost_content("/uploads/" + prueba.getPost_content());
                    return dto;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(datos);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){pS.delete(id);}

    @GetMapping("/{id}")
    public ResponseEntity<List<PostDTO>> listid(@PathVariable("id")Integer id){
        List<PostDTO> datos = pS.list().stream()
                .map(prueba -> {
                    PostDTO dto = new PostDTO();
                    dto.setId_post(prueba.getId_post());
                    dto.setProfile(prueba.getProfile());
                    dto.setPost_date(prueba.getPost_date());
                    dto.setPost_description(prueba.getPost_description());
                    dto.setPost_content("/uploads/" + prueba.getPost_content());
                    return dto;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(datos);
    }
    @PutMapping
    public void update(@RequestBody PostDTO dto) {
        ModelMapper m = new ModelMapper();
        Post p = m.map(dto, Post.class);
        p.setPost_date(LocalDate.now());
        pS.insert(p);
    }

}
