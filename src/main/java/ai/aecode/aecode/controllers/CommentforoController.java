package ai.aecode.aecode.controllers;
import ai.aecode.aecode.dtos.CommentforoDTO;
import ai.aecode.aecode.entities.Commentforo;
import ai.aecode.aecode.services.ICommentforoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/commentforo")
public class CommentforoController {
    @Autowired
    private ICommentforoService cfS;

    @PostMapping
    public void insert(@RequestBody CommentforoDTO dto){
        ModelMapper m=new ModelMapper();
        Commentforo cf= m.map(dto, Commentforo.class);
        cfS.insert(cf);
    }

    @GetMapping
    public List<CommentforoDTO> list() {
        return cfS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CommentforoDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){cfS.delete(id);}

    @GetMapping("/{id}")
    public CommentforoDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        CommentforoDTO dto=m.map(cfS.listId(id),CommentforoDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody CommentforoDTO dto) {
        ModelMapper m = new ModelMapper();
        Commentforo cf = m.map(dto, Commentforo.class);
        cfS.insert(cf);
    }
}
