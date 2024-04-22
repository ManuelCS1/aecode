package ai.aecode.aecode.controllers;

import ai.aecode.aecode.dtos.ScriptDTO;
import ai.aecode.aecode.entities.Script;
import ai.aecode.aecode.services.IScriptService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/script")
public class ScriptController {

    @Autowired
    private IScriptService sS;

    @PostMapping
    public void insert(@RequestBody ScriptDTO dto){
        ModelMapper m=new ModelMapper();
        Script s= m.map(dto,Script.class);
        sS.insert(s);
    }

    @GetMapping
    public List<ScriptDTO> list() {
        return sS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ScriptDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){sS.delete(id);}

    @GetMapping("/{id}")
    public ScriptDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        ScriptDTO dto=m.map(sS.listId(id),ScriptDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody ScriptDTO dto) {
        ModelMapper m = new ModelMapper();
        Script s = m.map(dto, Script.class);
        sS.insert(s);
    }
}
