package com.example.dao.repository.impl;


import com.example.dao.entity.Article;
import com.example.dao.repository.IArticleDao;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class ArticleDao implements IArticleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Article> getAllArticles() {
        String hql = "FROM Article as atcl ORDER BY atcl.articleId";
        return (List<Article>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Article getArticleById(int articleId) {
        return entityManager.find(Article.class,articleId);
    }

    @Override
    public Map<String,Object> getArticle(String title) {
        String hql = "SELECT * FROM articles";
        Query nativeQuery = entityManager.createNativeQuery(hql);
        nativeQuery.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List resultList = nativeQuery.getResultList();
        if(resultList.size()>0){
            return (Map<String, Object>) resultList.get(0);
        }
        return null;
    }

    @Override
    public void addArticle(Article article) {
        entityManager.persist(article);
    }

    @Override
    public void updateArticle(Article article) {
        Article article1 = getArticleById(article.getArticleId());
        String title = article.getTitle();
        String category = article.getCategory();
        if(null != title && !StringUtils.isEmpty(title)){
            article1.setTitle(title);
        }
        if(null != category && !StringUtils.isEmpty(category)){
            article1.setCategory(category);
        }
        entityManager.flush();
    }

    @Override
    public void deleteArticle(int articleId) {
        entityManager.remove(getArticleById(articleId));
    }



    @Override
    public boolean articleExists(String title, String category) {
        String hql = "FROM Article as atcl WHERE atcl.title = ? and atcl.category = ?";
        int count = entityManager.createQuery(hql).setParameter(0, title)
                .setParameter(1, category).getResultList().size();
        return count > 0;
    }

    @Override
    public void BatchDelete(List<?> list) {
        String hql = "DELETE FROM Articles as atcl WHERE atclarticle_id IN (:list)";
    }
}
