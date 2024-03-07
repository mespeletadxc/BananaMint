package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Budget;
import com.banana.bananamint.exception.BudgetException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.SQLException;
import java.util.List;

public interface BudgetJPARepository {
    public List<Budget> findAll(Long idCustomer) throws SQLException;

    public List<Budget> findByCustomerAndCategoryName(Long idCustomer, String categoryName) throws SQLException;

    public Budget save(Budget budget) throws SQLException;

}
