package ai.aecode.aecode.controllers;
import ai.aecode.aecode.dtos.PruebaDTO;
import ai.aecode.aecode.entities.Prueba;
import ai.aecode.aecode.services.IPruebaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public void insert(@RequestBody PruebaDTO dto, @RequestParam("file") MultipartFile imagen) {
        if (!imagen.isEmpty()) {
            Path directorioimagenes= Paths.get("src\\main\\resources\\static\\images\\");
            String rutaAbsoluta=directorioimagenes.toFile().getAbsolutePath();
            try {
                byte[] bytesImg= imagen.getBytes();
                Path rutaCompleta= Paths.get(rutaAbsoluta +"//"+ imagen.getOriginalFilename());
                Files.write(rutaCompleta,bytesImg);
                dto.setPrueba_multimedia(imagen.getOriginalFilename());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        ModelMapper m=new ModelMapper();
        Prueba p= m.map(dto,Prueba.class);
        ps.insert(p);
    }

    @GetMapping
    public List<PruebaDTO> list() {
        return ps.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PruebaDTO.class);
        }).collect(Collectors.toList());
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
