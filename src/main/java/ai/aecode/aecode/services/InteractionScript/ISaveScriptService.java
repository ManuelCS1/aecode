package ai.aecode.aecode.services.InteractionScript;

import ai.aecode.aecode.entities.InteractionScript.SaveScript;

import java.util.List;

public interface ISaveScriptService {
    public void insert(SaveScript savescript);
    List<SaveScript> list();
    public void delete(int id_savescript);
    public SaveScript listId(int id_savescript);
}
