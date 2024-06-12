package ai.aecode.aecode.controllers.StaticTableScript;
import ai.aecode.aecode.dtos.tsscript.CurrencyDTO;
import ai.aecode.aecode.entities.Currency;
import ai.aecode.aecode.services.ServTableScript.ICurrencyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    private ICurrencyService cS;
    @PostMapping
    public void insert(@RequestBody CurrencyDTO dto){
        ModelMapper m=new ModelMapper();
        Currency c= m.map(dto,Currency.class);
        cS.insert(c);
    }

    @GetMapping
    public List<CurrencyDTO> list() {
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CurrencyDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){cS.delete(id);}

    @GetMapping("/{id}")
    public CurrencyDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        CurrencyDTO dto=m.map(cS.listId(id),CurrencyDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody CurrencyDTO dto) {
        ModelMapper m = new ModelMapper();
        Currency c = m.map(dto, Currency.class);
        cS.insert(c);
    }
}
