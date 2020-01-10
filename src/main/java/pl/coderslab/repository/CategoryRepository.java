package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Category create(Category category){
        entityManager.persist(category);
        return category;
    }

    public void delete(Category category){
        entityManager.remove(entityManager.contains(category)
                ? category : entityManager.merge(category));
    }

    public void update(Category category){
        entityManager.merge(category);
    }

    public List<Category> getAll(){
        Query query = entityManager.createQuery("SELECT p FROM Category p");
        return query.getResultList();
    }

    public Category getById(long id){
        return entityManager.find(Category.class,id);
    }
}
