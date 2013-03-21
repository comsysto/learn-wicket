package com.comsysto.pages.blog.model;

import com.comsysto.domain.Comment;
import com.comsysto.repositories.CommentRepository;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * @author sekibomazic
 */
public class DetachableCommentModel extends LoadableDetachableModel<Comment> {

    @SpringBean
    private CommentRepository commentRepository;

    private Long commentId = null;

    public DetachableCommentModel() {
        Injector.get().inject(this);
    }

    public DetachableCommentModel(Comment comment) {
        this();
        if (comment != null) {
            commentId = comment.getId();
        }
    }

    public DetachableCommentModel(Long commentId) {
        this();
        this.commentId = commentId;
    }

    @Override
    protected Comment load() {
        if (commentId == null) {
            return new Comment();
        }
        return commentRepository.findOne(commentId);
    }

}