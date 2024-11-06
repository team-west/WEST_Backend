package com.example.west.global.security.jwt;

import com.example.west.global.exception.ExpiredTokenException;
import com.example.west.global.exception.InvalidTokenException;
import com.example.west.domain.auth.presentation.dto.response.TokenResponse;
import com.example.west.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class JwtReissueUtil {

    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;

    public TokenResponse reissue(String refreshToken) {

        if (!isRefreshToken(refreshToken)) {
            throw InvalidTokenException.EXCEPTION;
        }

        String accountId = getId(refreshToken);

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(accountId))
                .refreshToken(refreshToken)
                .build();
    }

    private String getId(String token) {
        return getClaims(token).getSubject();
    }

    private Claims getClaims(String token) {
        try {
            return Jwts
                    .parser()
                    .setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }

    private boolean isRefreshToken(String token) {
        return getClaims(token).get("type").equals("refresh");
    }

    public Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);
        UserDetails userDetails = authDetailsService.loadUserByUsername(claims.getSubject());
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }
}
