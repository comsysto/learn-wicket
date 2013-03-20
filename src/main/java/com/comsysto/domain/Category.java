package com.comsysto.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author sekibomazic
 */
@Entity
public class Category extends PersistentEntity {

    public static Category newCategory() {
        return new Category();
    }

    @Column(length=20)
    private String name;

    @Column(length=255)
    private String description;

    //@ManyToOne
    //private Blog blog;

    // Blog.java
    // @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // private final Set<Category> categories = new LinkedHashSet<Category>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*
    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
    */

    public Category name(String name) {
        this.name = name;
        return this;
    }

    public Category description(String description) {
        this.description = description;
        return this;
    }

}