package ai.aecode.aecode.entities;

import jakarta.persistence.*;

@Entity
@Table(name="article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_article;
    @ManyToOne
    @JoinColumn(name = "id_profile")
    private Profile profile;

    @Column(name = "article_title", length = 50, nullable = false)
    private String article_title;
    @Lob
    @Column(name = "article_pdf", nullable = false)
    private byte[] article_pdf;

    public Article() {
    }

    public Article(int id_article, Profile profile, String article_title, byte[] article_pdf) {
        this.id_article = id_article;
        this.profile = profile;
        this.article_title = article_title;
        this.article_pdf = article_pdf;
    }

    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public byte[] getArticle_pdf() {
        return article_pdf;
    }

    public void setArticle_pdf(byte[] article_pdf) {
        this.article_pdf = article_pdf;
    }
}
