package com.comsysto.pages.blog.panel;

import com.comsysto.domain.Comment;
import com.comsysto.domain.Post;
import com.comsysto.repositories.PostRepository;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.validator.StringValidator;

/**
 * @author sekibomazic
 */
public class CommentFormPanel extends Panel {

    Form<Void> form;
    IModel<Comment> commentModel;
    IModel<Post> postModel;

    @SpringBean
    private PostRepository postRepository;

    public CommentFormPanel(String id, IModel<Post> model) {
        super(id);

        this.postModel = model;

        commentModel = Model.of(new Comment());

        form();
    }

    private void form() {
        form = new Form<Void>("form");
        add(form);

        feedback();

        name();
        email();
        content();

        saveComment();
    }

    private void feedback() {
        form.add(new FeedbackPanel("feedback"));
    }

    private void name() {
        form.add(new TextField<String>("name", new PropertyModel<String>(commentModel, "name")));
    }

    private void email() {
        form.add(new TextField<String>("email", new PropertyModel<String>(commentModel, "email")));
    }

    private void content() {
        TextArea<String> content = new TextArea<String>("content", new PropertyModel<String>(commentModel, "content"));
        content.add(StringValidator.maximumLength(1000));
        content.setRequired(true);

        form.add(content);
    }

    private void saveComment() {
        Button save = new Button("save") {
            @Override
            public void onSubmit() {
                Post post = postModel.getObject();

                post.addComment(commentModel.getObject());

                postRepository.save(post);

                form.clearInput();
                commentModel.setObject(Comment.newComment());
            }
        };

        form.add(save);
    }

}