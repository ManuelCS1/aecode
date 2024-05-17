package ai.aecode.aecode.servicesimplement;


import ai.aecode.aecode.entities.Comment;
import ai.aecode.aecode.repositories.ICommentRepository;
import ai.aecode.aecode.services.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImplement implements ICommentService {
    @Autowired
    private ICommentRepository cR;

    @Override
    public void insert(Comment comment) {
        cR.save(comment);
    }

    @Override
    public List<Comment> list() {
        return cR.findAll();
    }

    @Override
    public void delete(int id_comment) {
        cR.deleteById(id_comment);
    }

    @Override
    public Comment listId(int id_comment) {
        return cR.findById(id_comment).orElse(new Comment());
    }
}
