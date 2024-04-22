package ai.aecode.aecode.controllers;

import ai.aecode.aecode.dtos.RoleDTO;
import ai.aecode.aecode.entities.Role;
import ai.aecode.aecode.services.IRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private IRoleService rS;

    @PostMapping
    public void insert(@RequestBody RoleDTO dto){
        ModelMapper m=new ModelMapper();
        Role r= m.map(dto,Role.class);
        rS.insert(r);
    }

    @GetMapping
    public List<RoleDTO> list() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RoleDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){rS.delete(id);}

    @GetMapping("/{id}")
    public RoleDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        RoleDTO dto=m.map(rS.listId(id),RoleDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody RoleDTO dto) {
        ModelMapper m = new ModelMapper();
        Role r = m.map(dto, Role.class);
        rS.insert(r);
    }

}
