package ai.aecode.aecode.services;


import ai.aecode.aecode.entities.Comment;

import java.util.List;

public interface ICommentService {

    public void insert(Comment comment);
    List<Comment> list();
    public void delete(int id_comment);
    public Comment listId(int id_comment);
    public void update(Comment comment);
}
