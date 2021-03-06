package com.theironyard.entities;

import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance
@DiscriminatorColumn(name="item_type")
@DiscriminatorOptions(force = true)
@Table(name="items")
public class Item {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column
    private LocalDateTime updatedAt = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.EAGER)
    private Artist artist;

    @ManyToMany(mappedBy = "liked")
    private Set<User> likedBy = new HashSet<>();

    @Transient
    private boolean currentlyLiked = false;

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Set<User> getLikedBy() {
        return likedBy;
    }

    public void setLikedBy(Set<User> likedBy) {
        this.likedBy = likedBy;
    }

    public boolean isCurrentlyLiked() {
        return currentlyLiked;
    }

    public void setCurrentlyLiked(boolean currentlyLiked) {
        this.currentlyLiked = currentlyLiked;
    }
}
