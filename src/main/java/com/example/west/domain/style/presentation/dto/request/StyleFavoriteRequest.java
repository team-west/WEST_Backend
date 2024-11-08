package com.example.west.domain.style.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class StyleFavoriteRequest {

    @NotNull
    private String name;
}
