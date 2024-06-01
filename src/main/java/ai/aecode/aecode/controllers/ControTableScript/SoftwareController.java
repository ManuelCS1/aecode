package ai.aecode.aecode.controllers.ControTableScript;
import ai.aecode.aecode.dtos.tsscript.SoftwareDTO;
import ai.aecode.aecode.entities.Software;
import ai.aecode.aecode.services.ServTableScript.ISoftwareService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/software")
public class SoftwareController {
    @Autowired
    private ISoftwareService sS;

    @PostMapping
    public void insert(@RequestBody SoftwareDTO dto){
        ModelMapper m=new ModelMapper();
        Software s= m.map(dto,Software.class);
        sS.insert(s);
    }

    @GetMapping
    public List<SoftwareDTO> list() {
        return sS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SoftwareDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){sS.delete(id);}

    @GetMapping("/{id}")
    public SoftwareDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        SoftwareDTO dto=m.map(sS.listId(id),SoftwareDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody SoftwareDTO dto) {
        ModelMapper m = new ModelMapper();
        Software s = m.map(dto, Software.class);
        sS.insert(s);
    }
}
