package ai.aecode.aecode.servicesimplement.ServITableScript;

import ai.aecode.aecode.entities.ProgLang;
import ai.aecode.aecode.repositories.RepoTableScript.IProgLangRepository;
import ai.aecode.aecode.services.ServTableScript.IProgLangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgLangServiceImplement implements IProgLangService {
    @Autowired
    private IProgLangRepository pR;
    @Override
    public void insert(ProgLang progLang) {
        pR.save(progLang);
    }

    @Override
    public List<ProgLang> list() {
        return pR.findAll();
    }

    @Override
    public void delete(int id_progLang) {
        pR.deleteById(id_progLang);
    }

    @Override
    public ProgLang listId(int id_progLang) {
        return pR.findById(id_progLang).orElse(new ProgLang());
    }
}
