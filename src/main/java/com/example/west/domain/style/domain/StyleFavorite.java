package com.example.west.domain.style.domain;

import com.example.west.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class StyleFavorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "style_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Style style;

    @Column(name = "style_image", columnDefinition = "varchar(500)", nullable = false)
    private String styleImageUrl;

    @Builder
    public StyleFavorite(User user, Style style, String styleImageUrl) {
        this.user = user;
        this.style = style;
        this.styleImageUrl = styleImageUrl;
    }
}
