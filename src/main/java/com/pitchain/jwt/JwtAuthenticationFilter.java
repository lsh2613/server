package com.pitchain.jwt;

import com.pitchain.common.apiPayload.statusEnums.ErrorStatus;
import com.pitchain.common.constant.TokenType;
import com.pitchain.common.exception.GeneralHandler;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.PatternMatchUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final TokenUtil tokenUtil;

    public static final String[] whitelist = {
            "/oauth**",
            "/resources/**", "/favicon.ico", // resource
            "/swagger-ui/**", "/api-docs/**", "/v3/api-docs**", "/v3/api-docs/**" , // swagger
    };

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return PatternMatchUtils.simpleMatch(whitelist, request.getRequestURI());
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = tokenUtil.extractToken(request, TokenType.ACCESS_TOKEN);

        if (token == null) {
            log.error("Access token is missing");
            throw new GeneralHandler(ErrorStatus.MISSING_ACCESS_TOKEN);
        }

        // jwt 검증 로직
//        DecodedJWT decodedJWT = tokenUtil.decodedJWT(token);
//        Long id = decodedJWT.getClaim("id").asLong();
//        Authentication authentication = new UsernamePasswordAuthenticationToken(id,null);

        Authentication authentication = new UsernamePasswordAuthenticationToken(1L,null);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        doFilter(request, response, filterChain);
    }
}
