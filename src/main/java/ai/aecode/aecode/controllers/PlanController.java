package ai.aecode.aecode.controllers;
import ai.aecode.aecode.dtos.PlanDTO;
import ai.aecode.aecode.entities.Plan;
import ai.aecode.aecode.services.IPlanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    private IPlanService pS;

    @PostMapping
    public void insert(@RequestBody PlanDTO dto){
        ModelMapper m=new ModelMapper();
        Plan p= m.map(dto, Plan.class);
        pS.insert(p);
    }

    @GetMapping
    public List<PlanDTO> list() {
        return pS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PlanDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){pS.delete(id);}

    @GetMapping("/{id}")
    public PlanDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        PlanDTO dto=m.map(pS.listId(id),PlanDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody PlanDTO dto) {
        ModelMapper m = new ModelMapper();
        Plan p = m.map(dto, Plan.class);
        pS.insert(p);
    }
}
