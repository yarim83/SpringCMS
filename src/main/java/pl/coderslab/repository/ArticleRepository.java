package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleRepository {
    @PersistenceContext
    EntityManager entityManager;

    public Article create(Article article){
        entityManager.persist(article);
        return article;
    }

    public void delete(Article article){
        entityManager.remove(entityManager.contains(article) ?
                article : entityManager.merge(article));
    }

    public void update(Article article){
       entityManager.merge(article);
    }

    public List<Article> getAll(){
        Query query = entityManager.createQuery("SELECT p FROM Article p");
        return query.getResultList();
    }

    public List<Article> getFiveArticle(){
        Query query = entityManager.createQuery("SELECT p FROM Article p ORDER BY p.created DESC");
        return query.setMaxResults(5).getResultList();
    }
    public Article getById(long id){
        return entityManager.find(Article.class,id);
    }

}
