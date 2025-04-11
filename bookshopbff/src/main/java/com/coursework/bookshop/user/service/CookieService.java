package com.coursework.bookshop.user.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.stereotype.Service;

@Service
public class CookieService {

    //CreateCookies
    public void createCookie(String cookieName, String data, int expirationDate, HttpServletResponse response){
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(cookieName);
        String encryptedData = encryptor.encrypt(data);

        Cookie cookie = new Cookie(cookieName,encryptedData);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(expirationDate);
        response.addCookie(cookie);
        cookie.setPath("/");


    }

    public String getCookie(String cookieName, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String data=null;
        if (cookies!=null) {
            for (Cookie c : cookies) {
                if (cookieName.equals(c.getName())) {
                    String value = c.getValue();
                    StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
                    encryptor.setPassword(cookieName);
                    data = encryptor.decrypt(value);
                }
            }
        }

        return data;
    }



}
