package com.comsysto.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author sekibomazic
 */

@Entity
public class Blog extends PersistentEntity {

    @Column(length = 100, nullable = false, unique = true)
    private String name;

    @Column(length = 1000)
    private String description;

    @Column(length = 255)
    private String tagline;

    //@ManyToOne
    //private List<User> users;

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

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    //public List<User> getUsers() {
    //    return users;
    //}

    //public void setUsers(List<User> users) {
    //    this.users = users;
    //}
}