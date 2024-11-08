package com.example.west.domain.style.presentation.dto.response;

import com.example.west.domain.style.domain.StyleFavorite;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StyleFavoriteResponse {

    private String name;
    private String imageUrl;

    private StyleFavoriteResponse(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public static StyleFavoriteResponse from(StyleFavorite favorite, String styleImageUrl) {
        return new StyleFavoriteResponse(favorite.getStyle().getName(), styleImageUrl);
    }
}
