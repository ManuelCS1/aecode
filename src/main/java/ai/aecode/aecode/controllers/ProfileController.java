package ai.aecode.aecode.controllers;

import ai.aecode.aecode.dtos.LoginDTO;
import ai.aecode.aecode.dtos.ProfileDTO;
import ai.aecode.aecode.entities.Profile;
import ai.aecode.aecode.services.IProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> insert(@RequestBody ProfileDTO dto){
        ModelMapper m=new ModelMapper();
        Profile p= m.map(dto, Profile.class);
        try {
            pS.insert(p);
            return ResponseEntity.status(HttpStatus.CREATED).body("Perfil creado exitosamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
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
        pS.update(p);
    }

    //Definir logica para Query para verificar credenciales de inicio de sesion
    @PostMapping("/login")
    public ResponseEntity<Profile> login(@RequestBody LoginDTO dto) {
        Profile profile = pS.findByUsernameOrEmail( dto);
        if (profile != null && profile.getProfile_password().equals(dto.getProfile_password())) {
            dto.setId_profile(profile.getId_profile());
            return ResponseEntity.ok(profile); // Devuelve el objeto LoginDTO con el ID de perfil actualizado
        } else {
            return ResponseEntity.badRequest().body(null); // En caso de credenciales inválidas, puedes devolver null o un objeto vacío
        }
    }



}
