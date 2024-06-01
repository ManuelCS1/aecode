package ai.aecode.aecode.controllers.ControTableScript;
import ai.aecode.aecode.dtos.tsscript.ProgLangDTO;
import ai.aecode.aecode.entities.ProgLang;
import ai.aecode.aecode.services.ServTableScript.IProgLangService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/proglang")
public class ProgLangController {
    @Autowired
    private IProgLangService pS;

    @PostMapping
    public void insert(@RequestBody ProgLangDTO dto){
        ModelMapper m=new ModelMapper();
        ProgLang p= m.map(dto,ProgLang.class);
        pS.insert(p);
    }

    @GetMapping
    public List<ProgLangDTO> list() {
        return pS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ProgLangDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){pS.delete(id);}

    @GetMapping("/{id}")
    public ProgLangDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        ProgLangDTO dto=m.map(pS.listId(id),ProgLangDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody ProgLangDTO dto) {
        ModelMapper m = new ModelMapper();
        ProgLang p = m.map(dto, ProgLang.class);
        pS.insert(p);
    }

}
