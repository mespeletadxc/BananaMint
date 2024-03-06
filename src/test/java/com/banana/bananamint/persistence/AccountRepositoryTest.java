package com.banana.bananamint.persistence;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//@ExtendWith(SpringExtension.class)
//@DataJpaTest()
//@ComponentScan(basePackages = {"com.microcompany.accountsservice_IBC.AccountService_IBC.persistence"})
//@AutoConfigureTestEntityManager
@SpringBootTest
class AccountRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(AccountRepositoryTest.class);

//    @Autowired
//    private TestEntityManager entityManager;

    @Autowired
    private AccountJPARepository jpaRepo;

    //void addwithcustomer() throws SQLException {
    //save
    @Test
    //@Transactional
    void addwithcustomer() {
        Account newAcc = new Account(null, "Corriente", LocalDate.now(), 1000.00, 100.00,
                new Customer(null, "Juan", "Juan@hotmail.com", LocalDate.now(),"12345678L",null),true);

        jpaRepo.save(newAcc);
        Optional<Account> aAccount = jpaRepo.findById(newAcc.getId());
        System.out.println("Account: "+aAccount.toString());

        assertEquals(aAccount.get().getId(), newAcc.getId());
        // assertThat(aAccount.getId()).isGreaterThan(0);
    }

//    @Test
//    void save() {
//        // given
//        Account aAccount = new Account(null, "Cta test", Date.from(Instant.now()), 1000, 1L, null);
//
//        // when
//        jpaRepo.save(aAccount);
//
//        //System.out.println("cuenta creada:" + aAccount);
//
//        // then
//        assertThat(aAccount.getId()).isGreaterThan(0);
//    }
//
//    @Test
//    void findAll() {
//        // given
////        Product aProduct = new Product(null, "Fake Product", "123-123-1234");
////        entityManager.persist(aProduct);
////        entityManager.flush();
//
//        // when
//        List<Account> accounts = jpaRepo.findAll();
//        logger.info("Accounts:" + accounts.toString());
//        System.out.println("Accounts:" + accounts.toString());
//
//        // then
//        assertThat(accounts.size())
//                .isGreaterThan(0);
//
//        assertNotNull(accounts);
//    }
//
//    @Test
//    void findByOwnerId() {
//        // given
////        Product aProduct = new Product(null, "Fake Product", "123-123-1234");
////        entityManager.persist(aProduct);
////        entityManager.flush();
//
//        // when
//        List<Account> accounts = jpaRepo.findByOwnerId(1L);
//        logger.info("Accounts:" + accounts);
//        logger.info("Size:"+accounts.size());
//        //System.out.println("Accounts:" + accounts.toString());
//
//        // then
//        assertThat(accounts.size())
//                .isGreaterThan(0);
//
//        assertNotNull(accounts);
//    }
    //    @Test
   /* void findById() {
    }*/

    //    @Test
    /*void findByNameContaining() {
    }*/

    //    @Test
   /* void findByName() {
    }*/



    /*@Test
    void deleteById() {
    }*/
}