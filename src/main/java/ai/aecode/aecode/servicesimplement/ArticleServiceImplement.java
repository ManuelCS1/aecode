package ai.aecode.aecode.servicesimplement;

import ai.aecode.aecode.entities.Article;
import ai.aecode.aecode.repositories.IArticleRepository;
import ai.aecode.aecode.services.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImplement implements IArticleService {
    @Autowired
    private IArticleRepository aR;
    @Override
    public void insert(Article article) {
        aR.save(article);
    }

    @Override
    public List<Article> list() {
        return aR.findAll();
    }

    @Override
    public void delete(int id_article) {
        aR.deleteById(id_article);
    }

    @Override
    public Article listId(int id_article) {
        return aR.findById(id_article).orElse(new Article());
    }
}
