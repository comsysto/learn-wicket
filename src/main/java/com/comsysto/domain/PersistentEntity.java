package com.comsysto.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @author sekibomazic
 */

@MappedSuperclass
public abstract class PersistentEntity extends AbstractPersistable<Long> {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false, nullable = false)
    private Date created = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date updated = new Date();

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

}