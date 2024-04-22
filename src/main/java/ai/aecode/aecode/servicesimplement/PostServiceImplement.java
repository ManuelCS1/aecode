package ai.aecode.aecode.servicesimplement;
import ai.aecode.aecode.entities.Post;
import ai.aecode.aecode.repositories.IPostRepository;
import ai.aecode.aecode.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostServiceImplement implements IPostService {

    @Autowired
    private IPostRepository pR;

    @Override
    public void insert(Post post) {pR.save(post);}

    @Override
    public List<Post> list() {return pR.findAll();}

    @Override
    public void delete(int id_post) {pR.deleteById(id_post);}

    @Override
    public Post listId(int id_post) {return pR.findById(id_post).orElse(new Post());}
}
