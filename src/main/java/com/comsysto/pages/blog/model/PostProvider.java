package com.comsysto.pages.blog.model;

import com.comsysto.domain.Post;
import com.comsysto.repositories.PostRepository;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Iterator;

/**
 * @author sekibomazic
 */
public class PostProvider implements IDataProvider<Post> {

    @SpringBean
    private PostRepository postRepository;

    private transient Page<Post> page;

    public PostProvider() {
        super();

        Injector.get().inject(this);
    }

    @Override
    public Iterator<? extends Post> iterator(long first, long count) {

        PageRequest pageRequest = new PageRequest((int)(first/6), (int)count, Sort.Direction.DESC, "updated");

        Page<Post> page = postRepository.findAll(pageRequest);

        return page.iterator();
    }

    @Override
    public long size() {
        return postRepository.count();
    }

    @Override
    public IModel<Post> model(Post post) {
        return new DetachablePostModel(post);
    }

    @Override
    public void detach() {
        //no op
    }

}