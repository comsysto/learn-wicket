package com.comsysto.pages.blog.panel;

import com.comsysto.domain.Comment;
import com.comsysto.domain.Post;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
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

        comments(model);
    }

    private void title(IModel<Post> model) {
        add(new Label("title", new PropertyModel<String>(model, "title")));
    }

    private String postedBy(String user, Date date) {
        Locale locale = getLocale();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM, locale);
        String by = (locale == Locale.UK) ? "by" : "von";
        return dateFormat.format(date) + " " + by + " " + user;
    }

    private void dateAndUser(final IModel<Post> model) {
        add(new Label("date_user", new AbstractReadOnlyModel<String>() {
            @Override
            public String getObject() {
                String user = model.getObject().getUser().getFullName();

                return postedBy(user != null ? user : "Anonymous", model.getObject().getUpdated());
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

    private void comments(IModel<Post> model) {

        IModel<List<Comment>> commentListModel = new PropertyModel<List<Comment>>(model, "comments");

        ListView<Comment> commentList = new ListView<Comment>("comments", commentListModel) {
            @Override
            protected void populateItem(final ListItem<Comment> item) {
                item.add(new Label("name_time", new AbstractReadOnlyModel<String>() {
                    @Override
                    public String getObject() {
                        String user = item.getModelObject().getName();

                        return postedBy(user != null ? user : "Anonymous", item.getModelObject().getCreated());
                    }
                }));

                item.add(new MultiLineLabel("content", new PropertyModel<String>(item.getModel(), "content")));
            }
        };

        add(commentList);
    }

}