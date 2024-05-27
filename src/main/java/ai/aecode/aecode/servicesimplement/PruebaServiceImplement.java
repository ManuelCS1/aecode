package ai.aecode.aecode.servicesimplement;

import ai.aecode.aecode.entities.Prueba;
import ai.aecode.aecode.repositories.IPruebaRepository;
import ai.aecode.aecode.services.IPruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PruebaServiceImplement implements IPruebaService {
    @Autowired
    private IPruebaRepository pR;


    @Override
    public void insert(Prueba prueba) {
        pR.save(prueba);
    }

    @Override
    public List<Prueba> list() {
        return pR.findAll();
    }

    @Override
    public void delete(int id_prueba) {
        pR.deleteById(id_prueba);
    }

    @Override
    public Prueba listId(int id_prueba) {
        return pR.findById(id_prueba).orElse(new Prueba());
    }
}
