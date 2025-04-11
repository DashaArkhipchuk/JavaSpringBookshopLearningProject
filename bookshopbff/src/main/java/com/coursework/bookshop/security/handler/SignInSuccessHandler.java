package com.coursework.bookshop.security.handler;

import com.coursework.bookshop.security.entity.CustomUserDetails;
import com.coursework.bookshop.user.service.CookieService;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Log4j2
@RequiredArgsConstructor
public class SignInSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final CookieService cookieService;
    @Value("${security.app.authentication.cookie}")
    private String USER_COOKIE_CREDENTIALS;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();
        String jsonPrincipal = new Gson().toJson(principal);
        cookieService.createCookie(USER_COOKIE_CREDENTIALS, jsonPrincipal, 24 * 60 * 60, response);
        response.sendRedirect("/");
    }
}
