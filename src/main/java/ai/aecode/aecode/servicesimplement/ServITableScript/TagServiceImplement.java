package ai.aecode.aecode.servicesimplement.ServITableScript;

import ai.aecode.aecode.entities.Tag;
import ai.aecode.aecode.repositories.RepoTableScript.ITagRepository;
import ai.aecode.aecode.services.ServTableScript.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImplement implements ITagService {
    @Autowired
    private ITagRepository tR;

    @Override
    public void insert(Tag tag) {
        tR.save(tag);
    }

    @Override
    public List<Tag> list() {
        return tR.findAll();
    }

    @Override
    public void delete(int id_tag) {
        tR.deleteById(id_tag);
    }

    @Override
    public Tag listId(int id_tag) {
        return tR.findById(id_tag).orElse(new Tag());
    }
}
