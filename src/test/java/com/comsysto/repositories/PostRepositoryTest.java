package com.comsysto.repositories;

import com.comsysto.domain.Category;
import com.comsysto.domain.Post;
import com.comsysto.domain.User;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author sekibomazic
 */
public class PostRepositoryTest extends RepositoryTest {

    @Before
    public void setUp() throws Exception {
        super.setUp();

        createTestUser();
        createTestCategories();
    }


    @Test
    public void storeAndFetchTwoPosts() {
        User user = getTestUser();
        Assert.assertNotNull(user);

        List<Category> categories = getAllCategories();

        Category cat1 = categories.get(0);
        Category cat2 = categories.get(1);

        Post post1 = Post.newPost()
                        .title("Dummy Post")
                        .content("Hier kommt endloses Gelaber")
                        .user(user)
                        .addCategory(cat2);

        Post savedPost1 = postRepository.save(post1);

        Assert.assertNotNull(savedPost1);
        Assert.assertTrue(savedPost1.getCategories().contains(cat2));

        Post post2 = Post.newPost()
                .title("Coole Post")
                .content("Hier kommt kein dummes Zeug. Nur premium!")
                .user(user)
                .addCategory(cat1)
                .addCategory(cat2);

        Post savedPost2 = postRepository.save(post2);

        Assert.assertNotNull(savedPost2);
        Assert.assertTrue(savedPost2.getCategories().containsAll(categories));

    }

}