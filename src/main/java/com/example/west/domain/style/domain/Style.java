package com.example.west.domain.style.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Style {

    @Id
    @Column(name = "style_name", columnDefinition = "varchar(50)", nullable = false)
    private String name;

    @Column(name = "image_url_male", columnDefinition = "varchar(500)", nullable = false)
    private String imageUrlMale;

    @Column(name = "image_url_female", columnDefinition = "varchar(500)", nullable = false)
    private String imageUrlFemale;

    @Builder
    public Style(String name, String imageUrlMale, String imageUrlFemale) {
        this.name = name;
        this.imageUrlMale = imageUrlMale;
        this.imageUrlFemale = imageUrlFemale;
    }
}
