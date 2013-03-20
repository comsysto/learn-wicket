package com.comsysto.pages.blog.panel;

import com.comsysto.domain.Post;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import java.text.DateFormat;
import java.util.Locale;

/**
 * @author sekibomazic
 */
public class PostPreviewPanel extends Panel {

    public PostPreviewPanel(String id, IModel<Post> model) {
        super(id);

        title(model);

        dateAndUser(model);

        categories(model);

        excerpt(model);
    }

    private void title(IModel<Post> model) {
        add(new Label("title", new PropertyModel<String>(model, "title")));
    }

    private void dateAndUser(final IModel<Post> model) {
        add(new Label("date_user", new AbstractReadOnlyModel<String>() {
            @Override
            public String getObject() {
                Post post = model.getObject();
                Locale locale = getLocale();
                DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
                String by = (locale == Locale.UK) ? "by" : "von";
                return dateFormat.format(post.getUpdated()) + " " + by + " " + post.getUser().getFullName();
            }
        }));
    }

    private void categories(IModel<Post> model) {
        add(new Label("category", new PropertyModel<String>(model, "category")));
    }

    private void excerpt(IModel<Post> model) {
        add(new Label("excerpt", new PropertyModel<String>(model, "excerpt")));
    }

}