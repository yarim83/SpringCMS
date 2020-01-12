package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

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

    public Author create(Author author) {
        entityManager.persist(author);
        return author;
    }

    public void delete(Author author) {
        entityManager.remove(entityManager.contains(author)
                ? author : entityManager.merge(author));
    }

    public void update(Author author) {
        entityManager.merge(author);
    }

    public List getAll() {
        Query query = entityManager.createQuery("SELECT p FROM Author p");
        return query.getResultList();
    }

    public Author getById(long id){
        return entityManager.find(Author.class, id);
    }
}
