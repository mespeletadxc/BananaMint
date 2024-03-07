package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetJPARepository_old extends JpaRepository<Budget, Long> {
    /*public List<Budget> findAll(Long idCustomer) throws SQLException;

    public List<Budget> findByCustomerAndCategoryName(Long idCustomer, String categoryName) throws SQLException;

    public Budget save(Budget budget) throws SQLException;*/

    //En cuanto activo el siguiente metodo no me pasa el test de humo
    /*public List<Budget> findByCustomerAndCategoryName(Long idCustomer, String categoryName) throws SQLException;*/
}
