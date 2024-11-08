package com.example.west.domain.style.domain.repository;

import com.example.west.domain.style.domain.Style;
import com.example.west.domain.style.domain.StyleFavorite;
import com.example.west.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StyleFavoriteRepository extends JpaRepository<StyleFavorite, Long> {
    Optional<StyleFavorite> findByUserAndStyleAndStyleImageUrl(User user, Style style, String styleImageUrl);

    List<StyleFavorite> findByUser(User user);
}
