package com.gnaderi.superhero.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Superhero {
    private Long id;
    private String name;
    private String pseudonym;
    private Date firstAppearance;
    @JsonProperty("publisher")
    private Publisher publisherByPublisherId;

    public Superhero() {
    }

    public Superhero(String name, String pseudonym, Date firstAppearance, Publisher publisherByPublisherId) {
        this.name = name;
        this.pseudonym = pseudonym;
        this.firstAppearance = firstAppearance;
        this.publisherByPublisherId = publisherByPublisherId;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "PSEUDONYM")
    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    @Basic
    @Column(name = "FIRST_APPEARANCE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date getFirstAppearance() {
        return firstAppearance;
    }

    public void setFirstAppearance(Date firstAppearance) {
        this.firstAppearance = firstAppearance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Superhero superhero = (Superhero) o;
        return Objects.equals(id, superhero.id) &&
                Objects.equals(name, superhero.name) &&
                Objects.equals(pseudonym, superhero.pseudonym) &&
                Objects.equals(firstAppearance, superhero.firstAppearance);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, pseudonym, firstAppearance);
    }

    @ManyToOne
    @JoinColumn(name = "PUBLISHER_ID", referencedColumnName = "ID", nullable = false)
    public Publisher getPublisherByPublisherId() {
        return publisherByPublisherId;
    }

    public void setPublisherByPublisherId(Publisher publisherByPublisherId) {
        this.publisherByPublisherId = publisherByPublisherId;
    }
}
