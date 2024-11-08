package com.example.west.domain.style.domain.repository;

import com.example.west.domain.style.domain.Style;
import com.example.west.domain.user.domain.type.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StyleRepository extends JpaRepository<Style, String> {
    //Optional<Style> findByNameAndGender(String name, Gender gender);
    Optional<Style> findByName(String name);
}
