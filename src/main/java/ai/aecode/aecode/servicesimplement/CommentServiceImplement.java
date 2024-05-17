package ai.aecode.aecode.servicesimplement;


import ai.aecode.aecode.entities.Comment;
import ai.aecode.aecode.repositories.ICommentRepository;
import ai.aecode.aecode.services.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
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

    @Override
    public void update(Comment comment) {
        if (comment.getComment_date() == null) {
            // Actualiza la fecha y hora al momento actual
            comment.setComment_date(new Date());
        }
        cR.save(comment);
    }
}
