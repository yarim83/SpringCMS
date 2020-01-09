package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorRepository {

    @PersistenceContext
    EntityManager entityManager;

    private Author create(Author author){
        entityManager.persist(author);
        return author;
    }

    private void delete(Author author){
        entityManager.remove(entityManager.contains(author)
                ? author : entityManager.merge(author));
    }

    private void update(Author author){
        entityManager.merge(author);
    }

    private List getAll(){
        Query query = entityManager.createQuery("SELECT p FROM Author p");
        return query.getResultList();
    }
}
