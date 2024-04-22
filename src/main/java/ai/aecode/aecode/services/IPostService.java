package ai.aecode.aecode.services;

import ai.aecode.aecode.entities.Post;

import java.util.List;

public interface IPostService {
    public void insert(Post post);
    List<Post> list();
    public void delete(int id_post);
    public Post listId(int id_post);
}
