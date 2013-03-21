package com.comsysto.pages.blog;

import com.comsysto.pages.blog.model.DetachablePostModel;
import com.comsysto.pages.blog.panel.PostPanel;
import org.apache.wicket.Component;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * @author sekibomazic
 */
public class PostEntryPage extends BlogPage {

    long postId = -1L;

    public PostEntryPage(PageParameters parameters) {
        super(parameters);

        this.postId = parameters.get("id").toLong();
    }

    @Override
    public Component getContent(String id) {
        /*
        return new Label(id, new AbstractReadOnlyModel<String>() {
            @Override
            public String getObject() {
                return "Post ID: " + postId;
            }
        });
        */

        return new PostPanel(id, new DetachablePostModel(postId));
    }

}