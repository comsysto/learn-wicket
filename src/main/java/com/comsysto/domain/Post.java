package com.comsysto.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sekibomazic
 */

@Entity
public class Post extends PersistentEntity {

    public static Post newPost() {
        return new Post();
    }

	@Column(length = 500, nullable = false)
	private String title;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Post_Categories", joinColumns = @JoinColumn(name = "Post_id"), inverseJoinColumns = @JoinColumn(name = "Category_id"))
    private Set<Category> categories = new HashSet<Category>();

	@Column(length = 5000)
	private String content;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Comment> comments = new ArrayList<Comment>();

	@ManyToOne(optional = false)
	private User user;


	public void addComment(Comment comment) {

        if (!getComments().contains(comment)) {
            getComments().add(comment);
            comment.setPost(this);
        }
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getExcerpt() {
		String res = content.length() > 100 ? content.substring(0, 100) : content;

        return res + "...";
	}


	public List<Comment> getComments() {
		return comments;
	}

    public String getCategory() {
        StringBuffer sb = new StringBuffer();

        for (Category cat : categories) {
            sb.append(cat.getName()).append(" ");
        }

        return sb.toString();
    }

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

    public Post title(String title) {
        this.title = title;
        return this;
    }

    public Post content(String content) {
        this.content = content;
        return this;
    }

    public Post user(User user) {
        this.user = user;
        return this;
    }

    public Post addCategory(Category category) {
        categories.add(category);
        return this;
    }

}