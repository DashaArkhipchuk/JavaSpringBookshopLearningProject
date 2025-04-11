package com.coursework.bookshop.security.filter;

import com.coursework.bookshop.security.entity.CustomUserDetails;
import com.coursework.bookshop.user.service.CookieService;
import com.google.gson.Gson;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Log4j2
@Component
@RequiredArgsConstructor
public class SignInRequestFilter extends OncePerRequestFilter {
    private final CookieService cookieService;

    @Value("${security.app.authentication.cookie}")
    private String USER_COOKIE_CREDENTIALS;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jsonPrincipal = cookieService.getCookie(USER_COOKIE_CREDENTIALS, request);
        if(jsonPrincipal!=null){
            CustomUserDetails customUserDetails = new Gson().fromJson(jsonPrincipal, CustomUserDetails.class);
            log.info("principal: "+ customUserDetails);

            UsernamePasswordAuthenticationToken authToken= new UsernamePasswordAuthenticationToken(
                    customUserDetails,
                    null,
                    customUserDetails.getAuthorities()
            );

            SecurityContextHolder.getContext().setAuthentication(authToken);
        }

        //get credentials from cookies
        //decrypt\json->object
        //apply credentials

        filterChain.doFilter(request,response);
    }
}
