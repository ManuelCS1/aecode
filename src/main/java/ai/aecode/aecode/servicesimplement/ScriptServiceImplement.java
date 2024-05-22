package ai.aecode.aecode.servicesimplement;

import ai.aecode.aecode.entities.ProgLang;
import ai.aecode.aecode.entities.Script;
import ai.aecode.aecode.entities.Software;
import ai.aecode.aecode.entities.Tag;
import ai.aecode.aecode.repositories.IScriptRepository;
import ai.aecode.aecode.services.IScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScriptServiceImplement implements IScriptService {
    @Autowired
    private IScriptRepository sR;
    @Override
    public void insert(Script script) {sR.save(script);}

    @Override
    public List<Script> list() {
        return sR.findAll();
    }

    @Override
    public void delete(int id_script) { sR.deleteById(id_script);}

    @Override
    public Script listId(int id_script) {
        return sR.findById(id_script).orElse(new Script());
    }

    @Override
    public List<Script> list(String softwareName, String tagName, String progLangName) {
        List<Script> result = new ArrayList<>();

        if (softwareName != null) {
            result.addAll(sR.findBySoftwareName(softwareName));
        }

        if (tagName != null) {
            result.addAll(sR.findByTagName(tagName));
        }

        if (progLangName != null) {
            result.addAll(sR.findByProgLangName(progLangName));
        }

        if (softwareName != null && tagName != null && progLangName != null) {
            result.addAll(sR.findBySoftwareNameAndTagNameAndProgLangName(softwareName, tagName, progLangName));
        }

        return result.stream().distinct().collect(Collectors.toList());
    }

}
