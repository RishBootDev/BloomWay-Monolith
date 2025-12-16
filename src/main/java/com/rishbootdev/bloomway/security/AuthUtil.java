package com.rishbootdev.bloomway.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtil {

//    private jwtUserPrincipal verifyUsertoken(String token){
//        Claims claims= Jwts.parser()
//                .verify
//    }

//    public Long getCurrentUserId(){
//        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
//        if(authentication==null || (authentication.getPrincipal() instanceof JwtUserPrincipal)
//            return new RuntimeException();
//    }
}
