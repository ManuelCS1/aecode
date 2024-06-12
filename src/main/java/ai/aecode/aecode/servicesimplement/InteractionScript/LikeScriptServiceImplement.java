package ai.aecode.aecode.servicesimplement.InteractionScript;

import ai.aecode.aecode.entities.InteractionScript.LikeScript;
import ai.aecode.aecode.repositories.InteractionScript.ILikeScriptRepository;
import ai.aecode.aecode.services.InteractionScript.ILikeScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeScriptServiceImplement implements ILikeScriptService {
    @Autowired
    private ILikeScriptRepository lsR;
    @Override
    public void insert(LikeScript likescript) {
        lsR.save(likescript);
    }

    @Override
    public List<LikeScript> list() {
        return lsR.findAll();
    }

    @Override
    public void delete(int id_likescript) {
        lsR.deleteById(id_likescript);
    }

    @Override
    public LikeScript listId(int id_likescript) {
        return lsR.findById(id_likescript).orElse(new LikeScript());
    }
}
