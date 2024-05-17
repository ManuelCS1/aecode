package ai.aecode.aecode.services;
import ai.aecode.aecode.entities.Article;

import java.util.List;

public interface IArticleService {

    public void insert(Article article);
    List<Article> list();
    public void delete(int id_article);
    public Article listId(int id_article);
}
