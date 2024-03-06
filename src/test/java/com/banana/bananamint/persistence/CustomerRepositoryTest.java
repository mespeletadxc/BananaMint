package com.banana.bananamint.persistence;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@ExtendWith(SpringExtension.class)
//@DataJpaTest()
//@ComponentScan(basePackages = {"com.microcompany.accountsservice_IBC.AccountService_IBC.persistence"})
//@AutoConfigureTestEntityManager
@SpringBootTest
class CustomerRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(CustomerRepositoryTest.class);

//    @Autowired
//    private TestEntityManager entityManager;

    @Autowired
    private CustomerJPARepository jpaCustomerRepo;

//    @Test
//    void addWithAccounts() throws SQLException {
//        List<Account> cuentas = List.of(
//            new Account(null, "Corriente", 1000, 1, ),
//            new Student(null, "Luisa", "Rosalez", 3)
//        );
//
//        School sch = new School(null, "Mi escuela con estudiantes", estudiantes);
//
//        for (Student estudiante : estudiantes) {
//            estudiante.setMySchool(sch);
//        }
//
//        repo.add(sch);
////        System.out.println(sch);
//        assertNotNull(sch);
//        assertTrue(sch.getId() > 0);
//
//    }
//    @Test
//    void findAll() {
//        // given
//       Account aAccount = new Account(null, "Corriente", 1000, 1,new Customer(null,"Juan","Juan@hotmail",cuentas)) ;
//        entityManager.persist(aProduct);
//        entityManager.flush();
//
//        // when
//        List<Product> prods = jpaRepo.findAll();
//        logger.info("Prods:" + prods);
//
//        // then
//        assertThat(prods.size())
//                .isGreaterThan(0);
//
//        assertNotNull(prods);
//    }
//
//    //    @Test
//    void findById() {
//    }
//
//    //    @Test
//    void findByNameContaining() {
//    }
//
//    //    @Test
//    void findByName() {
//    }
//
//@Test
//    void save() {
//        // given
//    Customer aCustomer = new Customer(null, "Maria", "Maria@yahoo.es",null);
//        // when
//        jpaCustomerRepo.save(aCustomer);
//
//    //System.out.println("cuenta creada:" + aAccount);
//
//        // then
//        assertThat(aCustomer.getId()).isGreaterThan(0);
//    }
//
//    @Test
//    void deleteById() {
//    }
}