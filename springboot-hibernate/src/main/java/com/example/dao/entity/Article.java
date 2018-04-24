package com.example.dao.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "articles")
public class Article implements Serializable{

    private static final long serivalVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private int articleId;

    @Column(name = "title")
    private String title;

    @Column(name = "category")
    private String category;

    public int getArticleId() {
        return articleId;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
