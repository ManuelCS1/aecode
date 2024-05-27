package ai.aecode.aecode.controllers;
import ai.aecode.aecode.dtos.PruebaDTO;
import ai.aecode.aecode.entities.Prueba;
import ai.aecode.aecode.services.IPruebaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private IPruebaService ps;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void insert(@RequestPart("file") MultipartFile imagen) {
        if (!imagen.isEmpty()) {
            Path directorioimagenes= Paths.get("src\\main\\resources\\static\\images\\");
            String rutaAbsoluta=directorioimagenes.toFile().getAbsolutePath();
            try {
                byte[] bytesImg= imagen.getBytes();
                Path rutaCompleta= Paths.get(rutaAbsoluta +"//"+ imagen.getOriginalFilename());
                Files.write(rutaCompleta,bytesImg);

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
                .map(x -> "src/main/resources/static/images/" + x.getPrueba_multimedia())
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
