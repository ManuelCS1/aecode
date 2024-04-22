package ai.aecode.aecode.services;

import ai.aecode.aecode.entities.Script;

import java.util.List;

public interface IScriptService {
    public void insert(Script script);
    List<Script> list();
    public void delete(int id_script);
    public Script listId(int id_script);
}
