package ai.aecode.aecode.services.ServTableScript;

import ai.aecode.aecode.entities.Tag;

import java.util.List;

public interface ITagService {
    public void insert(Tag tag);
    List<Tag> list();
    public void delete(int id_tag);
    public Tag listId(int id_tag);
}
