package ai.aecode.aecode.controllers.InteractionScript;

import ai.aecode.aecode.dtos.InteractionScript.SaveScriptDTO;
import ai.aecode.aecode.entities.InteractionScript.SaveScript;
import ai.aecode.aecode.services.InteractionScript.ISaveScriptService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/savescript")
public class SaveScriptController {
    @Autowired
    private ISaveScriptService ssS;

    @PostMapping
    public void insert(@RequestBody SaveScriptDTO dto){
        ModelMapper m=new ModelMapper();
        SaveScript ss= m.map(dto, SaveScript.class);
        ssS.insert(ss);
    }

    @GetMapping
    public List<SaveScriptDTO> list() {
        return ssS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SaveScriptDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){ssS.delete(id);}

    @GetMapping("/{id}")
    public SaveScriptDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        SaveScriptDTO dto=m.map(ssS.listId(id),SaveScriptDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody SaveScriptDTO dto) {
        ModelMapper m = new ModelMapper();
        SaveScript ss = m.map(dto, SaveScript.class);
        ssS.insert(ss);
    }
}
