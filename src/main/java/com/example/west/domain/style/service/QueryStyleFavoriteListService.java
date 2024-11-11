package com.example.west.domain.style.service;

import com.example.west.domain.style.domain.StyleFavorite;
import com.example.west.domain.style.domain.repository.StyleFavoriteRepository;
import com.example.west.domain.style.presentation.dto.response.StyleFavoriteResponse;
import com.example.west.domain.user.domain.User;
import com.example.west.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryStyleFavoriteListService {
    private final StyleFavoriteRepository styleFavoriteRepository;
    private final StyleService styleService;
    private final UserFacade userFacade;

    public List<StyleFavoriteResponse> getFavoriteStyles() {
        User user = userFacade.getCurrentUser();
        List<StyleFavorite> favorites = styleFavoriteRepository.findByUser(user);

        return favorites.stream()
                .map(f -> StyleFavoriteResponse.from(f, styleService.getStyleImageUrl(f.getStyle())))
                .collect(Collectors.toList());
    }
}
