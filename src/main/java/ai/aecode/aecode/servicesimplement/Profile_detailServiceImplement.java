package ai.aecode.aecode.servicesimplement;
import ai.aecode.aecode.entities.Profile_detail;
import ai.aecode.aecode.repositories.IProfile_detailRepository;
import ai.aecode.aecode.services.IProfile_detailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Profile_detailServiceImplement implements IProfile_detailService {
    @Autowired
    private IProfile_detailRepository pdR;

    @Override
    public void insert(Profile_detail profile_detail) { pdR.save(profile_detail);}

    @Override
    public List<Profile_detail> list() {return pdR.findAll();}

    @Override
    public void delete(int id_ProfileDetail) {pdR.deleteById(id_ProfileDetail);}

    @Override
    public Profile_detail listId(int id_ProfileDetail) {
        return pdR.findById(id_ProfileDetail).orElse(new Profile_detail());
    }
}
