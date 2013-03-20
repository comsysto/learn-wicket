package com.comsysto.pages.blog.model;

import com.comsysto.domain.Post;
import com.comsysto.repositories.PostRepository;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * @author sekibomazic
 */
public class DetachablePostModel extends LoadableDetachableModel<Post> {

    private final Long id;

    @SpringBean
    PostRepository postRepository;

    public DetachablePostModel(Long id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }

        this.id = id;

        Injector.get().inject(this);
    }

    public DetachablePostModel(Post post) {
        this(post.getId());
    }


    @Override
    protected Post load() {
        return postRepository.findOne(id);
    }

}