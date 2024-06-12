package ai.aecode.aecode.controllers.InteractionScript;
import ai.aecode.aecode.dtos.InteractionScript.CommentScriptDTO;
import ai.aecode.aecode.entities.InteractionScript.CommentScript;
import ai.aecode.aecode.services.InteractionScript.ICommentScriptService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/commentscript")
public class CommentScriptController {
    @Autowired
    private ICommentScriptService csS;

    @PostMapping
    public void insert(@RequestBody CommentScriptDTO dto){
        ModelMapper m=new ModelMapper();
        CommentScript cs= m.map(dto, CommentScript.class);
        csS.insert(cs);
    }

    @GetMapping
    public List<CommentScriptDTO> list() {
        return csS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CommentScriptDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){csS.delete(id);}

    @GetMapping("/{id}")
    public CommentScriptDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        CommentScriptDTO dto=m.map(csS.listId(id),CommentScriptDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody CommentScriptDTO dto) {
        ModelMapper m = new ModelMapper();
        CommentScript cs = m.map(dto, CommentScript.class);
        csS.insert(cs);
    }

}
