package ai.aecode.aecode.controllers;
import ai.aecode.aecode.dtos.SpecialityDTO;
import ai.aecode.aecode.entities.Speciality;
import ai.aecode.aecode.services.ISpecialityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/speciality")
public class SpecialityController {
    @Autowired
    private ISpecialityService sS;

    @PostMapping
    public void insert(@RequestBody SpecialityDTO dto){
        ModelMapper m=new ModelMapper();
        Speciality s= m.map(dto,Speciality.class);
        sS.insert(s);
    }

    @GetMapping
    public List<SpecialityDTO> list() {
        return sS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SpecialityDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){sS.delete(id);}

    @GetMapping("/{id}")
    public SpecialityDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        SpecialityDTO dto=m.map(sS.listId(id),SpecialityDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody SpecialityDTO dto) {
        ModelMapper m = new ModelMapper();
        Speciality s = m.map(dto, Speciality.class);
        sS.insert(s);
    }
}
