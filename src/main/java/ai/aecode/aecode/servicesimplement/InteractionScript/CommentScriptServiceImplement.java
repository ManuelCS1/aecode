package ai.aecode.aecode.servicesimplement.InteractionScript;

import ai.aecode.aecode.entities.InteractionScript.CommentScript;
import ai.aecode.aecode.repositories.InteractionScript.ICommentScriptRepository;
import ai.aecode.aecode.services.InteractionScript.ICommentScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentScriptServiceImplement implements ICommentScriptService {
    @Autowired
    private ICommentScriptRepository csR;

    @Override
    public void insert(CommentScript commentscript) {
        csR.save(commentscript);
    }

    @Override
    public List<CommentScript> list() {
        return csR.findAll();
    }

    @Override
    public void delete(int id_commentscript) {
        csR.deleteById(id_commentscript);
    }

    @Override
    public CommentScript listId(int id_commentscript) {
        return csR.findById(id_commentscript).orElse(new CommentScript());
    }
}
