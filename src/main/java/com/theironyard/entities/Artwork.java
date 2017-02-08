package com.theironyard.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@DiscriminatorValue("artwork")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Artwork extends Item{

    @Column(unique = true)
    @JsonProperty("id")
    private String artsyArtworkId;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column
    private String title;

    @Column
    private String category;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column
    private String medium;

    @Column
    private String date;

    @Transient
    @JsonProperty("dimensions")
    private Map<String, Map<String, Object>> rawDims;

    @Column
    private String size;

    @Transient
    @JsonProperty("_links")
    private Map<String, Map> imagesMap;

    @Transient
    @JsonProperty("image_versions")
    private List<String> imageVersions = new ArrayList<>();

    @Column
    private String imgThumb;

    @Column
    private String imgLarge;

    @Column
    private String imgZoom;

    public Artwork() {
    }

    public String getArtsyArtworkId() {
        return artsyArtworkId;
    }

    public void setArtsyArtworkId(String artsyArtworkId) {
        this.artsyArtworkId = artsyArtworkId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Map<String, Map<String, Object>> getRawDims() {
        return rawDims;
    }

    public void setRawDims(Map<String, Map<String, Object>> rawDims) {
        this.rawDims = rawDims;
    }

    public Map<String, Map> getImagesMap() {
        return imagesMap;
    }

    public void setImagesMap(Map<String, Map> imagesMap) {
        this.imagesMap = imagesMap;
    }

    public List<String> getImageVersions() {
        return imageVersions;
    }

    public void setImageVersions(List<String> imageVersions) {
        this.imageVersions = imageVersions;
    }

    public String getImgThumb() {
        return imgThumb;
    }

    public void setImgThumb(String imgThumb) {
        this.imgThumb = imgThumb;
    }

    public String getImgLarge() {
        return imgLarge;
    }

    public void setImgLarge(String imgLarge) {
        this.imgLarge = imgLarge;
    }

    public String getImgZoom() {
        return imgZoom;
    }

    public void setImgZoom(String imgZoom) {
        this.imgZoom = imgZoom;
    }

    @Override
    public String toString() {
        return "Artwork{" +
                "id=" + super.getId() +
                ", artsyArtworkId='" + artsyArtworkId + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

}
