package ai.aecode.aecode.controllers;

import ai.aecode.aecode.dtos.ProfileDTO;
import ai.aecode.aecode.entities.Profile;
import ai.aecode.aecode.services.IProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private IProfileService pS;

    @PostMapping
    public void insert(@RequestBody ProfileDTO dto){
        ModelMapper m=new ModelMapper();
        Profile p= m.map(dto, Profile.class);
        pS.insert(p);
    }

    @GetMapping
    public List<ProfileDTO> list() {
        return pS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ProfileDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){pS.delete(id);}

    @GetMapping("/{id}")
    public ProfileDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        ProfileDTO dto=m.map(pS.listId(id),ProfileDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody ProfileDTO dto) {
        ModelMapper m = new ModelMapper();
        Profile p = m.map(dto, Profile.class);
        pS.insert(p);
    }

    //Definir logica para Query para verificar credenciales de inicio de sesion
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody ProfileDTO dto) {
        Profile profile = pS.findByUsernameOrEmail( dto.getProfile_email());
        if (profile != null && profile.getProfile_password().equals(dto.getProfile_password())) {
            return ResponseEntity.ok("Credenciales válidas");
        } else {
            return ResponseEntity.badRequest().body("Credenciales inválidas");
        }
    }

}
