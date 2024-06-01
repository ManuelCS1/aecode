package ai.aecode.aecode.servicesimplement;

import ai.aecode.aecode.entities.Speciality;
import ai.aecode.aecode.repositories.ISpecialityRepository;
import ai.aecode.aecode.services.ISpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityServiceImplement implements ISpecialityService {

    @Autowired
    private ISpecialityRepository sR;
    @Override
    public void insert(Speciality speciality) {
        sR.save(speciality);
    }

    @Override
    public List<Speciality> list() {
        return sR.findAll();
    }

    @Override
    public void delete(int id_speciality) {
        sR.deleteById(id_speciality);
    }

    @Override
    public Speciality listId(int id_speciality) {
        return sR.findById(id_speciality).orElse(new Speciality());
    }
}
