package ai.aecode.aecode.servicesimplement;

import ai.aecode.aecode.entities.Profile;
import ai.aecode.aecode.repositories.IProfileRepository;
import ai.aecode.aecode.services.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImplement implements IProfileService {
    @Autowired
    private IProfileRepository pR;

    @Override
    public void insert(Profile profile) { pR.save(profile);}

    @Override
    public List<Profile> list() {
        return pR.findAll();
    }

    @Override
    public void delete(int id_profile) {pR.deleteById(id_profile);

    }

    @Override
    public Profile listId(int id_profile) {
        return pR.findById(id_profile).orElse(new Profile());
    }
}
