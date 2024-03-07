package com.banana.bananamint.persistence;


import com.banana.bananamint.domain.Budget;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Setter
@Repository
public class JPABudgetJPARepository implements BudgetJPARepository {

    @PersistenceContext // Accede al emf; emf.createEntityManager();
    EntityManager em;


    @Override
    public List<Budget> findAll(Long idCustomer) throws SQLException {
        return em.createQuery("SELECT s FROM Budget s", Budget.class).getResultList();
    }



    @Override
    public List<Budget> findByCustomerAndCategoryName(Long idCustomer, String categoryName) throws SQLException {
        return null;
    }

    @Override
    @Transactional
    public Budget save(Budget budget) throws SQLException {
        em.persist(budget);
        return budget;
    }


}
