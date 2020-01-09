package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CategoryRepository {

    @PersistenceContext
    EntityManager entityManager;

    private Category create(Category category){
        entityManager.persist(category);
        return category;
    }

    private void delete(Category category){
        entityManager.remove(entityManager.contains(category)
                ? category : entityManager.merge(category));
    }

    private void update(Category category){
        entityManager.merge(category);
    }

}
