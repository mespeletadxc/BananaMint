/*package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Budget;
import com.banana.bananamint.domain.Category;
import com.banana.bananamint.domain.Customer;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@ExtendWith(SpringExtension.class)
//@DataJpaTest()
//@ComponentScan(basePackages = {"com.microcompany.accountsservice_IBC.AccountService_IBC.persistence"})
//@AutoConfigureTestEntityManager
@SpringBootTest
class BudgetRepositoryTest_old {

    private static final Logger logger = LoggerFactory.getLogger(BudgetRepositoryTest_old.class);

//    @Autowired
//    private TestEntityManager entityManager;

    @Autowired
    private BudgetJPARepository jpaRepo;

    @Test
    void addwithcustomer() {

        Budget newBud = new Budget(null, new Category(null, "Categoria_A", "Tipo_A", "Descripcion_A", LocalDate.now()), 400, new Customer(null, "Juan", "Juan@hotmail.com", LocalDate.now(),"12345678L"), 400L,
        400L);

        jpaRepo.save(newBud);
        Optional<Budget> aBudget = jpaRepo.findById(newBud.getId());
        System.out.println("Budget: "+aBudget.toString());

        assertEquals(aBudget.get().getId(), newBud.getId());
        // assertThat(aAccount.getId()).isGreaterThan(0);
    }

}*/
