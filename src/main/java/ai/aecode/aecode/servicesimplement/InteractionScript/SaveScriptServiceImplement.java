package ai.aecode.aecode.servicesimplement.InteractionScript;

import ai.aecode.aecode.entities.InteractionScript.SaveScript;
import ai.aecode.aecode.repositories.InteractionScript.ISaveScriptRepository;
import ai.aecode.aecode.services.InteractionScript.ISaveScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveScriptServiceImplement implements ISaveScriptService {
    @Autowired
    private ISaveScriptRepository ssR;
    @Override
    public void insert(SaveScript savescript) {
        ssR.save(savescript);
    }

    @Override
    public List<SaveScript> list() {
        return ssR.findAll();
    }

    @Override
    public void delete(int id_savescript) {
        ssR.deleteById(id_savescript);
    }

    @Override
    public SaveScript listId(int id_savescript) {
        return ssR.findById(id_savescript).orElse(new SaveScript());
    }
}
