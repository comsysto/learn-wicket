package com.comsysto.pages.blog.panel;

import com.comsysto.domain.Post;
import com.comsysto.pages.blog.component.BootstrapAjaxPagingNavigator;
import com.comsysto.pages.blog.model.PostProvider;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;

/**
 * @author sekibomazic
 */
public class RecentPostsPanel extends Panel {

    public RecentPostsPanel(String id) {
        super(id);

        posts();

        setOutputMarkupId(true);
    }

    private void posts() {
        DataView<Post> dataView = new DataView<Post>("posts", new PostProvider()) {
            @Override
            protected void populateItem(Item<Post> item) {
                item.add(new PostPreviewPanel("postPreview", item.getModel()));
            }
        };

        dataView.setItemsPerPage(6L);
        add(dataView);

        add(new BootstrapAjaxPagingNavigator("navigator", dataView));
    }

}