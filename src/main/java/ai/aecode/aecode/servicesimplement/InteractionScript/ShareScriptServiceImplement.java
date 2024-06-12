package ai.aecode.aecode.servicesimplement.InteractionScript;

import ai.aecode.aecode.entities.InteractionScript.ShareScript;
import ai.aecode.aecode.repositories.InteractionScript.IShareScriptRepository;
import ai.aecode.aecode.services.InteractionScript.IShareScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareScriptServiceImplement implements IShareScriptService {
    @Autowired
    private IShareScriptRepository ssR;
    @Override
    public void insert(ShareScript sharescript) {
        ssR.save(sharescript);
    }

    @Override
    public List<ShareScript> list() {
        return ssR.findAll();
    }

    @Override
    public void delete(int id_sharescript) {
        ssR.deleteById(id_sharescript);
    }

    @Override
    public ShareScript listId(int id_sharescript) {
        return ssR.findById(id_sharescript).orElse(new ShareScript());
    }
}
