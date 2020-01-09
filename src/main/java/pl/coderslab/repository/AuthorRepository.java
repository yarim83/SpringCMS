package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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
}
