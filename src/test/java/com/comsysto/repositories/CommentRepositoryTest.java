package com.comsysto.repositories;

import com.comsysto.domain.Category;
import com.comsysto.domain.Comment;
import com.comsysto.domain.Post;
import com.comsysto.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author sekibomazic
 */
public class CommentRepositoryTest extends RepositoryTest {

    @Before
    public void setUp() throws Exception {
        super.setUp();

        createTestUser();
        createTestCategories();

    }

    @Test
    public void readWriteTest() throws Exception {

        Assert.assertEquals(0, commentRepository.count());

        User user = getTestUser();
        List<Category> categories = getAllCategories();

        Category cat = categories.get(0);

        Post post = Post.newPost()
                .title("Dummy Post")
                .content("Hier kommt endloses Gelaber")
                .user(user)
                .addCategory(cat);

        Post savedPost = postRepository.save(post);

        Comment comment1 = Comment.newComment().name("Joe").email("guest@mail.de").content("Sehr gut");
        Comment comment2 = Comment.newComment().email("ich@yahoo.de").content("Nicht schlecht").post(savedPost);
        Comment comment3 = Comment.newComment().email("du@gmail.com").content("Genau!!!").post(savedPost);
        Comment comment4 = Comment.newComment().email("unbekannt@trashmail.de").content("Na so was!").post(savedPost);

        savedPost.addComment(comment1);
        savedPost.addComment(comment2);
        savedPost.addComment(comment3);
        savedPost.addComment(comment4);

        commentRepository.save(Arrays.asList(comment1, comment2, comment3, comment4));

        Assert.assertEquals(4, savedPost.getComments().size());
    }

}