package com.example.service;

import com.example.dao.entity.Article;
import com.example.dao.repository.IArticleDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ArticleService {

    @Resource
    private IArticleDao articleDao;

    public Article getArticleById(int articleId){
        Article obj = articleDao.getArticleById(articleId);
        return obj;
    }

    public Map<String, Object> getArticle(String title){
        Map<String, Object> map = articleDao.getArticle(title);
        return map;
    }

    public List<Article> getAllArticles(){
        return articleDao.getAllArticles();
    }

    @Transactional
    public synchronized boolean addArticle(Article article){
        if(articleDao.articleExists(article.getTitle(), article.getCategory())){
            return false;
        }else {
            articleDao.addArticle(article);
            return true;
        }
    }

    @Transactional
    public void updateArticle(Article article){
        articleDao.updateArticle(article);
    }

    @Transactional
    public void deleteArticle(int articleId){
        articleDao.deleteArticle(articleId);
    }
}
