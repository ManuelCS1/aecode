package ai.aecode.aecode.controllers.InteractionScript;

import ai.aecode.aecode.dtos.InteractionScript.ShareScriptDTO;
import ai.aecode.aecode.entities.InteractionScript.ShareScript;
import ai.aecode.aecode.services.InteractionScript.IShareScriptService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sharescript")
public class ShareScriptController {
    @Autowired
    private IShareScriptService ssS;

    @PostMapping
    public void insert(@RequestBody ShareScriptDTO dto){
        ModelMapper m=new ModelMapper();
        ShareScript ss= m.map(dto, ShareScript.class);
        ssS.insert(ss);
    }

    @GetMapping
    public List<ShareScriptDTO> list() {
        return ssS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ShareScriptDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){ssS.delete(id);}

    @GetMapping("/{id}")
    public ShareScriptDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        ShareScriptDTO dto=m.map(ssS.listId(id),ShareScriptDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody ShareScriptDTO dto) {
        ModelMapper m = new ModelMapper();
        ShareScript ss = m.map(dto, ShareScript.class);
        ssS.insert(ss);
    }
}
