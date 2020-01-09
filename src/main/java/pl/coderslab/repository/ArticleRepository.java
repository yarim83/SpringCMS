package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Article;

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

    private Article create(Article article){
        entityManager.persist(article);
        return article;
    }

    private void delete(Article article){
        entityManager.remove(entityManager.contains(article) ?
                article : entityManager.merge(article));
    }

    private void update(Article article){
       entityManager.merge(article);
    }

    private List<Article> getAll(){
        Query query = entityManager.createQuery("SELECT p FROM article p");
        return query.getResultList();
    }
}
