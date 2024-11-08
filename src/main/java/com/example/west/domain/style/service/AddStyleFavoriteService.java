package com.example.west.domain.style.service;

import com.example.west.domain.style.domain.Style;
import com.example.west.domain.style.domain.StyleFavorite;
import com.example.west.domain.style.domain.repository.StyleFavoriteRepository;
import com.example.west.domain.style.presentation.dto.request.StyleFavoriteRequest;
import com.example.west.domain.user.domain.User;
import com.example.west.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AddStyleFavoriteService {

    private final StyleFavoriteRepository styleFavoriteRepository;
    private final StyleService styleService;
    private final UserFacade userFacade;

    @Transactional
    public void addStyleFavorite(StyleFavoriteRequest request) {
        User user = userFacade.getCurrentUser();
        Style style = styleService.getStyleByName(request.getName());
        String styleImageUrl = styleService.getStyleImageUrl(style);

        StyleFavorite favorite = StyleFavorite.builder()
                .user(user)
                .style(style)
                .styleImageUrl(styleImageUrl)
                .build();

        styleFavoriteRepository.save(favorite);
    }
}
