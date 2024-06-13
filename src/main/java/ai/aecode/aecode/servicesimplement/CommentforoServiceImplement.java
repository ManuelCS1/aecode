package ai.aecode.aecode.servicesimplement;

import ai.aecode.aecode.entities.Commentforo;
import ai.aecode.aecode.repositories.ICommentforoRepository;
import ai.aecode.aecode.services.ICommentforoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentforoServiceImplement implements ICommentforoService {

    @Autowired
    private ICommentforoRepository csR;

    @Override
    public void insert(Commentforo commentforo) {
        csR.save(commentforo);
    }

    @Override
    public List<Commentforo> list() {
        return csR.findAll();
    }

    @Override
    public void delete(int id_commentforo) {
csR.deleteById(id_commentforo);
    }

    @Override
    public Commentforo listId(int id_commentforo) {
        return csR.findById(id_commentforo).orElse(new Commentforo());
    }
}
