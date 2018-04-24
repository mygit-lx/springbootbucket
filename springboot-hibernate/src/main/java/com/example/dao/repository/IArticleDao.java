package com.example.dao.repository;

import com.example.dao.entity.Article;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by luox on 2018/3/5.
 */
public interface IArticleDao {

    List<Article> getAllArticles();

    Article getArticleById(int articleId);

    Map<String,Object> getArticle(String title);

    void addArticle(Article article);

    void updateArticle(Article article);

    void deleteArticle(int articleId);

    boolean articleExists(String title, String category);

    void BatchDelete(List<?> list);
}
