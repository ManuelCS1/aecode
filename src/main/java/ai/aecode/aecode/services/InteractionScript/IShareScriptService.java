package ai.aecode.aecode.services.InteractionScript;

import ai.aecode.aecode.entities.InteractionScript.ShareScript;

import java.util.List;

public interface IShareScriptService {
    public void insert(ShareScript sharescript);
    List<ShareScript> list();
    public void delete(int id_sharescript);
    public ShareScript listId(int id_sharescript);
}
