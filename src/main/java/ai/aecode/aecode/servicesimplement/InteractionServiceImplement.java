package ai.aecode.aecode.servicesimplement;

import ai.aecode.aecode.entities.Interaction;
import ai.aecode.aecode.entities.Role;
import ai.aecode.aecode.repositories.IInteractionRepository;
import ai.aecode.aecode.services.IInteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteractionServiceImplement implements IInteractionService {

    @Autowired
    private IInteractionRepository iR;

    @Override
    public void insert(Interaction interaction) {iR.save(interaction);}

    @Override
    public List<Interaction> list() {
        return iR.findAll();
    }

    @Override
    public void delete(int id_interaction) {iR.deleteById(id_interaction);}

    @Override
    public Interaction listId(int id_interaction) { return iR.findById(id_interaction).orElse(new Interaction());}
}
