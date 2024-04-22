package ai.aecode.aecode.controllers;


import ai.aecode.aecode.dtos.InteractionDTO;
import ai.aecode.aecode.entities.Interaction;
import ai.aecode.aecode.services.IInteractionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/interaction")
public class InteractionController {

    @Autowired
    private IInteractionService iS;

    @PostMapping
    public void insert(@RequestBody InteractionDTO dto){
        ModelMapper m=new ModelMapper();
        Interaction i= m.map(dto, Interaction.class);
        iS.insert(i);
    }

    @GetMapping
    public List<InteractionDTO> list() {
        return iS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, InteractionDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){iS.delete(id);}

    @GetMapping("/{id}")
    public InteractionDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        InteractionDTO dto=m.map(iS.listId(id),InteractionDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody InteractionDTO dto) {
        ModelMapper m = new ModelMapper();
        Interaction p = m.map(dto, Interaction.class);
        iS.insert(p);
    }

}
