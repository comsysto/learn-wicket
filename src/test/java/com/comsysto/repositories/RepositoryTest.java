package com.comsysto.repositories;

import com.comsysto.domain.Category;
import com.comsysto.domain.User;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @author sekibomazic
 */
@ContextConfiguration(classes = TestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public abstract class RepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;


    @Before
    public void setUp() throws Exception {
        cleanRepositories();

    }

    protected void cleanRepositories() {
        commentRepository.deleteAll();
        userRepository.deleteAll();
        postRepository.deleteAll();
        categoryRepository.deleteAll();
    }


    protected void createTestUser() {
        User user = User.newUser()
                .firstName("Sekib")
                .lastName("Omazic")
                .emailAddress("sekib@comsysto.com")
                .password("secret");

        userRepository.save(user);
    }

    protected void createTestCategories() {
        Category cat1 = Category.newCategory().name("Bla").description("Bla bla");
        Category cat2 = Category.newCategory().name("Labern").description("Labern labern ohne Ende");
        categoryRepository.save(Arrays.asList(cat1, cat2));
    }

    protected User getTestUser() {
        return userRepository.findByLastName("Omazic").get(0);
    }

    protected List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}