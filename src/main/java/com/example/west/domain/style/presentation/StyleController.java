package com.example.west.domain.style.presentation;

import com.example.west.domain.style.presentation.dto.request.StyleFavoriteRequest;
import com.example.west.domain.style.presentation.dto.response.StyleFavoriteResponse;
import com.example.west.domain.style.service.AddStyleFavoriteService;
import com.example.west.domain.style.service.QueryStyleFavoriteListService;
import com.example.west.domain.style.service.RemoveStyleFavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RequiredArgsConstructor
@RequestMapping("/styles/favorites")
@RestController
public class StyleController {

    private final AddStyleFavoriteService addStyleFavoriteService;
    private final QueryStyleFavoriteListService queryStyleFavoriteListService;
    private final RemoveStyleFavoriteService removeStyleFavoriteService;

    @PostMapping("/add")
    public void addFavorite(@RequestBody @Valid StyleFavoriteRequest styleFavoriteRequest) {
        addStyleFavoriteService.addStyleFavorite(styleFavoriteRequest);
    }

    @GetMapping("/query")
    public List<StyleFavoriteResponse> getFavorite() {
        return queryStyleFavoriteListService.getFavoriteStyles();
    }

    @DeleteMapping("/remove")
    public void removeFavorite(@RequestBody @Valid StyleFavoriteRequest styleFavoriteRequest) {
        removeStyleFavoriteService.removeStyleFavorite(styleFavoriteRequest);
    }
}
