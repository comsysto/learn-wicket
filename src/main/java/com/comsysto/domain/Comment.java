package com.comsysto.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author sekibomazic
 */
@Entity
public class Comment extends PersistentEntity {

    public static Comment newComment() {
        return new Comment();
    }

	@Column(length = 1000)
	private String content;

	@Column(length = 30)
	private String name;

	@Column(length = 40)
	private String email;

	@Column(length = 30)
	private String url;

	@ManyToOne(optional = false)
	private Post post;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}


    public Comment name(String name) {
        this.name = name;
        return this;
    }

    public Comment url(String url) {
        this.url = url;
        return this;
    }

    public Comment email(String email) {
        this.email = email;
        return this;
    }

    public Comment content(String content) {
        this.content = content;
        return this;
    }

    public Comment post(Post post) {
        this.post = post;
        return this;
    }

}