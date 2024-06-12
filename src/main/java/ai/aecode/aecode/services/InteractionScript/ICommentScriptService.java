package ai.aecode.aecode.services.InteractionScript;

import ai.aecode.aecode.entities.InteractionScript.CommentScript;

import java.util.List;

public interface ICommentScriptService {
    public void insert(CommentScript commentscript);
    List<CommentScript> list();
    public void delete(int id_commentscript);
    public CommentScript listId(int id_commentscript);

}
