package ai.aecode.aecode.controllers.StaticTableScript;
import ai.aecode.aecode.dtos.tsscript.TagDTO;
import ai.aecode.aecode.entities.Tag;
import ai.aecode.aecode.services.ServTableScript.ITagService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private ITagService tS;

    @PostMapping
    public void insert(@RequestBody TagDTO dto){
        ModelMapper m=new ModelMapper();
        Tag t= m.map(dto,Tag.class);
        tS.insert(t);
    }

    @GetMapping
    public List<TagDTO> list() {
        return tS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TagDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){tS.delete(id);}

    @GetMapping("/{id}")
    public TagDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        TagDTO dto=m.map(tS.listId(id),TagDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody TagDTO dto) {
        ModelMapper m = new ModelMapper();
        Tag t= m.map(dto, Tag.class);
        tS.insert(t);
    }
}
