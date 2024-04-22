package ai.aecode.aecode.controllers;


import ai.aecode.aecode.dtos.Profile_detailDTO;
import ai.aecode.aecode.entities.Profile_detail;
import ai.aecode.aecode.services.IProfile_detailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/profile_detail")
public class Profile_detailController {

    @Autowired
    private IProfile_detailService pdS;

    @PostMapping
    public void insert(@RequestBody Profile_detailDTO dto){
        ModelMapper m=new ModelMapper();
        Profile_detail pd= m.map(dto, Profile_detail.class);
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
