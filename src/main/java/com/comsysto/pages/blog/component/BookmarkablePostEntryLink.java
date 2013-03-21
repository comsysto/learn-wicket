package com.comsysto.pages.blog.component;

import com.comsysto.domain.Post;
import com.comsysto.pages.blog.BlogPage;
import com.comsysto.pages.blog.PostEntryPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.IModel;

/**
 * @author sekibomazic
 */
public class BookmarkablePostEntryLink extends BookmarkablePageLink {
    private static final long serialVersionUID = 1L;

	//private IModel<Post> postModel;

	/**
	 * Constructs the link.
	 * 
	 * @param id
	 *            the component id
	 * @param postModel
	 *            the post
	 */
	public BookmarkablePostEntryLink(String id, IModel<Post> postModel) {
		super(id, PostEntryPage.class, BlogPage.constructPostEntryPageParameters(postModel.getObject()));
		//this.postModel = postModel;
	}



	/**
	 * Constructs the link.
	 * 
	 * @param id
	 *            the component id
	 * @param post
	 *            the post
	 * @param label
	 *            the label for the link
	 */
    /*
	public BookmarkablePostEntryLink(String id, DetachablePostModel post, IModel label) {
		this(id, post);
		setModel(label);
	}
    */

    /*
	@Override
	protected void onComponentTagBody(MarkupStream markupStream, ComponentTag openTag) {
		String title = getModelObjectAsString();
		title = Strings.isEmpty(title) ? postModel.getObject().getTitle() : title;
		replaceComponentTagBody(markupStream, openTag, title);
	}
    */
}