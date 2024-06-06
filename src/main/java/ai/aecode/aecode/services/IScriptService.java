package ai.aecode.aecode.services;

import ai.aecode.aecode.entities.ProgLang;
import ai.aecode.aecode.entities.Script;
import ai.aecode.aecode.entities.Software;
import ai.aecode.aecode.entities.Tag;

import java.util.List;

public interface IScriptService {
    public void insert(Script script);
    List<Script> list();
    public void delete(int id_script);
    public Script listId(int id_script);
}
