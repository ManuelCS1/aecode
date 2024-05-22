package ai.aecode.aecode.controllers;


import ai.aecode.aecode.dtos.Profile_detailDTO;
import ai.aecode.aecode.entities.Profile_detail;
import ai.aecode.aecode.services.IProfile_detailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public void insert(@RequestParam("image") MultipartFile image, @RequestParam("profile_detailDTO") String profile_detailDTOJson){
        try {
            Profile_detailDTO dto = objectMapper.readValue(profile_detailDTOJson, Profile_detailDTO.class);
            byte[] imageContent = image.getBytes();
            dto.setDetail_ProfilePicture(imageContent);

            ModelMapper m=new ModelMapper();
            Profile_detail pd= m.map(dto, Profile_detail.class);
            pdS.insert(pd);
        }catch (Exception e){

        }

    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Object> list() {
        List<Profile_detailDTO> dtos = pdS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            Profile_detailDTO dto = m.map(x, Profile_detailDTO.class);
            byte[] imageContent = x.getDetail_ProfilePicture();
            String fileExtension = "";
            if (imageContent != null) {
                fileExtension = new String(imageContent).substring(0, 5);
                if (fileExtension.matches("^[a-zA-Z]+/[a-zA-Z0-9.-]+$")) {
                    dto.setDetail_ProfilePicture(imageContent);
                } else {
                    dto.setDetail_ProfilePicture(null);
                }
            }
            return dto;
        }).collect(Collectors.toList());

        HttpHeaders headers = new HttpHeaders();
        byte[] imageContent = null;
        MediaType mediaType = null;

        for (Profile_detailDTO dto : dtos) {
            imageContent = dto.getDetail_ProfilePicture();
            if (imageContent != null) {
                String fileExtension = new String(dto.getDetail_ProfilePicture()).substring(0, 5);
                System.out.println("fileExtension: " + fileExtension); // Agrega esta línea para imprimir el valor de fileExtension
                if (fileExtension.matches("^[a-zA-Z]+/[a-zA-Z0-9.-]+$")) { // Verifica que fileExtension sea válido
                    mediaType = MediaType.parseMediaType("image/" + fileExtension);
                    break;
                }
            }
        }

        if (mediaType == null) {
            return ResponseEntity.notFound().build();
        }

        headers.setContentType(mediaType);

        return new ResponseEntity<>(new ByteArrayResource(imageContent), headers, HttpStatus.OK);
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
