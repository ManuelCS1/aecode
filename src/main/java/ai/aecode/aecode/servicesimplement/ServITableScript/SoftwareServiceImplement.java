package ai.aecode.aecode.servicesimplement.ServITableScript;

import ai.aecode.aecode.entities.Software;
import ai.aecode.aecode.repositories.RepoTableScript.ISoftwareRepository;
import ai.aecode.aecode.services.ServTableScript.ISoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareServiceImplement implements ISoftwareService {
    @Autowired
    private ISoftwareRepository sR;
    @Override
    public void insert(Software software) {
        sR.save(software);
    }

    @Override
    public List<Software> list() {
        return sR.findAll();
    }

    @Override
    public void delete(int id_software) {
        sR.deleteById(id_software);
    }

    @Override
    public Software listId(int id_software) {
        return sR.findById(id_software).orElse(new Software());
    }
}
