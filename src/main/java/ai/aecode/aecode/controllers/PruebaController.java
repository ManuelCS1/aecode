package ai.aecode.aecode.controllers;
import ai.aecode.aecode.dtos.PruebaDTO;
import ai.aecode.aecode.entities.Prueba;
import ai.aecode.aecode.services.IPruebaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    public void insert(@RequestPart("file") MultipartFile imagen) {
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
                throw new RuntimeException(e);
            }
        }
    }

    @GetMapping("/imagenes")
    public ResponseEntity<List<String>> obtenerImagenes() {
        List<String> imagenes = ps.list().stream()
                .map(x -> "/prueba/uploads/" + x.getPrueba_multimedia())
                .collect(Collectors.toList());
        return ResponseEntity.ok(imagenes);
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
