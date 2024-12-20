package com.example.west.domain.style.service;

import com.example.west.domain.style.domain.Style;
import com.example.west.domain.style.domain.repository.StyleRepository;
import com.example.west.domain.style.exception.StyleNotFoundException;
import com.example.west.domain.user.domain.User;
import com.example.west.domain.user.domain.type.Gender;
import com.example.west.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StyleService {

    private final StyleRepository styleRepository;
    private final UserFacade userFacade;

    public Style getStyleByName(String styleName) {
        return styleRepository.findByName(styleName)
                .orElseThrow(() -> StyleNotFoundException.EXCEPTION);
    }

    public String getStyleImageUrl(Style style) {
        User currentUser = userFacade.getCurrentUser();
        return currentUser.getGender() == Gender.MALE ? style.getImageUrlMale() : style.getImageUrlFemale();
    }
}
