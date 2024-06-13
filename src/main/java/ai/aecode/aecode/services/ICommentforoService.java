package ai.aecode.aecode.services;
import ai.aecode.aecode.entities.Commentforo;
import java.util.List;

public interface ICommentforoService {
    public void insert(Commentforo commentforo);
    List<Commentforo> list();
    public void delete(int id_commentforo);
    public Commentforo listId(int id_commentforo);
}
