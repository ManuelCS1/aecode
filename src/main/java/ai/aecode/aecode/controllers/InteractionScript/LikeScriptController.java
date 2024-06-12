package ai.aecode.aecode.controllers.InteractionScript;
import ai.aecode.aecode.dtos.InteractionScript.LikeScriptDTO;
import ai.aecode.aecode.entities.InteractionScript.LikeScript;
import ai.aecode.aecode.services.InteractionScript.ILikeScriptService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/likecript")
public class LikeScriptController {
    @Autowired
    private ILikeScriptService lsS;

    @PostMapping
    public void insert(@RequestBody LikeScriptDTO dto){
        ModelMapper m=new ModelMapper();
        LikeScript ls= m.map(dto, LikeScript.class);
        lsS.insert(ls);
    }

    @GetMapping
    public List<LikeScriptDTO> list() {
        return lsS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, LikeScriptDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){lsS.delete(id);}

    @GetMapping("/{id}")
    public LikeScriptDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        LikeScriptDTO dto=m.map(lsS.listId(id),LikeScriptDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody LikeScriptDTO dto) {
        ModelMapper m = new ModelMapper();
        LikeScript ls = m.map(dto, LikeScript.class);
        lsS.insert(ls);
    }
}
