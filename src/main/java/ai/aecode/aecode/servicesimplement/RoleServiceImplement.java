package ai.aecode.aecode.servicesimplement;
import ai.aecode.aecode.entities.Role;
import ai.aecode.aecode.repositories.IRoleRepository;
import ai.aecode.aecode.services.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImplement implements IRoleService {
    @Autowired
    private IRoleRepository rR;

    @Override
    public void insert(Role role) { rR.save(role);}

    @Override
    public List<Role> list() {return rR.findAll();}

    @Override
    public void delete(int id_role) {rR.deleteById(id_role);}

    @Override
    public Role listId(int id_role) {return rR.findById(id_role).orElse(new Role());}
}
