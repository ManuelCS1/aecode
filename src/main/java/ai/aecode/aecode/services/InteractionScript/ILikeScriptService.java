package ai.aecode.aecode.services.InteractionScript;

import ai.aecode.aecode.entities.InteractionScript.LikeScript;

import java.util.List;

public interface ILikeScriptService {
    public void insert(LikeScript likescript);
    List<LikeScript> list();
    public void delete(int id_likescript);
    public LikeScript listId(int id_likescript);
}
