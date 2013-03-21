package com.comsysto.pages.blog.panel;

import com.comsysto.domain.Post;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import java.text.DateFormat;
import java.util.Locale;

/**
 * @author sekibomazic
 */
public class PostPanel extends Panel {

    public PostPanel(String id, IModel<Post> model) {
        super(id, model);

        title(model);

        dateAndUser(model);

        categories(model);

        content(model);

        commentForm(model);
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

    private void content(IModel<Post> model) {
        add(new MultiLineLabel("content", new PropertyModel<String>(model, "content")));
    }

    private void commentForm(IModel<Post> model) {
        add(new CommentFormPanel("commentForm", model));
    }


}