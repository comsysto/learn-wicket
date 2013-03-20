package com.comsysto.bootstrap;

import com.comsysto.domain.Category;
import com.comsysto.domain.Post;
import com.comsysto.domain.User;
import com.comsysto.repositories.CategoryRepository;
import com.comsysto.repositories.CommentRepository;
import com.comsysto.repositories.PostRepository;
import com.comsysto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * @author sekibomazic
 */
@Component
public class Bootstrap {

    private static final String CONTENT = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet";
    private static final String TITLE = "Lorem ipsum ";

    private static final int QUANTITY = 5;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;


    private void insertCategories() {
        Category cat1 = Category.newCategory().name("Wicket").description("Everything about wicket framework");
        Category cat2 = Category.newCategory().name("Javascript").description("Javascript in frontend");
        Category cat3 = Category.newCategory().name("Personal").description("Stuff from my life");
        categoryRepository.save(Arrays.asList(cat1, cat2, cat3));
    }

    private void insertUsers() {
        User user1 = User.newUser()
                .firstName("Sekib")
                .lastName("Omazic")
                .emailAddress("sekib@comsysto.com")
                .password("secret");

        User user2 = User.newUser()
                .firstName("Uli")
                .lastName("Hoeneß")
                .emailAddress("uli@fcb.de")
                .password("geheim");

        User user3 = User.newUser()
                .firstName("Franz")
                .lastName("Beckenbauer")
                .emailAddress("kaiser@fcb.de")
                .password("secret");

        userRepository.save(Arrays.asList(user1, user2, user3));
    }


    private void insertPosts() {
        List<User> users = userRepository.findAll();
        List<Category> categories = categoryRepository.findAll();


        for (int j = 0; j < 3; j++) {

            User user = users.get(j);
            Category cat = categories.get(j);

            for (int i = 0; i < QUANTITY; i++) {

                Post post = Post.newPost()
                        .title(TITLE)
                        .content(CONTENT)
                        .user(user)
                        .addCategory(cat);

                postRepository.save(post);
            }
        }
    }

    @PostConstruct
    public void init() {
        insertCategories();
        insertUsers();
        insertPosts();
    }

}