package ai.aecode.aecode.controllers;

import ai.aecode.aecode.dtos.PostDTO;
import ai.aecode.aecode.entities.Post;
import ai.aecode.aecode.services.IPostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private IPostService pS;

    @PostMapping
    public void insert(@RequestBody PostDTO dto){
        ModelMapper m=new ModelMapper();
        Post p= m.map(dto, Post.class);
        pS.insert(p);
    }

    @GetMapping
    public List<PostDTO> list() {
        return pS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PostDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){pS.delete(id);}

    @GetMapping("/{id}")
    public PostDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        PostDTO dto=m.map(pS.listId(id),PostDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody PostDTO dto) {
        ModelMapper m = new ModelMapper();
        Post p = m.map(dto, Post.class);
        pS.insert(p);
    }

}
