package ai.aecode.aecode.controllers;


import ai.aecode.aecode.dtos.Profile_detailDTO;
import ai.aecode.aecode.dtos.RoleDTO;
import ai.aecode.aecode.entities.Profile_detail;
import ai.aecode.aecode.entities.Role;
import ai.aecode.aecode.services.IProfile_detailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/profile_detail")
public class Profile_detailController {

    @Autowired
    private IProfile_detailService pdS;
    @Qualifier("objectMapper")
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping
    public void insert(@RequestBody Profile_detailDTO dto, @RequestParam("file") MultipartFile imagen) {
        if (!imagen.isEmpty()) {
            Path directorioimagenes= Paths.get("src\\main\\resources\\static\\images\\");
            String rutaAbsoluta=directorioimagenes.toFile().getAbsolutePath();
            try {
                byte[] bytesImg= imagen.getBytes();
                Path rutaCompleta= Paths.get(rutaAbsoluta +"//"+ imagen.getOriginalFilename());
                Files.write(rutaCompleta,bytesImg);
                dto.setDetail_ProfilePicture(imagen.getOriginalFilename());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        ModelMapper m=new ModelMapper();
        Profile_detail pd= m.map(dto,Profile_detail.class);
        pdS.insert(pd);
    }

    @GetMapping
    public List<Profile_detailDTO> list() {
        return pdS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Profile_detailDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){pdS.delete(id);}

    @GetMapping("/{id}")
    public Profile_detailDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        Profile_detailDTO dto=m.map(pdS.listId(id),Profile_detailDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody Profile_detailDTO dto) {
        ModelMapper m = new ModelMapper();
        Profile_detail pd = m.map(dto, Profile_detail.class);
        pdS.insert(pd);
    }

}
