package ai.aecode.aecode.controllers;

import ai.aecode.aecode.dtos.CommentDTO;
import ai.aecode.aecode.entities.Comment;
import ai.aecode.aecode.services.ICommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private ICommentService cS;

    @PostMapping
    public void insert(@RequestBody CommentDTO dto){
        ModelMapper m=new ModelMapper();
        Comment c= m.map(dto, Comment.class);
        cS.insert(c);
    }

    @GetMapping
    public List<CommentDTO> list() {
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CommentDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){cS.delete(id);}

    @GetMapping("/{id}")
    public CommentDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        CommentDTO dto=m.map(cS.listId(id),CommentDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody CommentDTO dto) {
        ModelMapper m = new ModelMapper();
        Comment c = m.map(dto, Comment.class);
        cS.insert(c);
    }

}
