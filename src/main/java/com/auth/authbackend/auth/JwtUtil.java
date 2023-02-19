package com.auth.authbackend.auth;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class JwtUtil {
    private static final String SECRET_KEY = "secreting_fniq123141";

  public static String generateToken(String username, String role) {
    return Jwts.builder()
        .setSubject(username)
        .claim("role", role)
        .setExpiration(new Date(System.currentTimeMillis() + 600000))
        .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
        .compact();
    // SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    // long nowMillis = System.currentTimeMillis();
    // Date now = new Date(nowMillis);

    // //We will sign our JWT with our ApiKey secret
    // byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
    // Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

    // //Let's set the JWT Claims
    // JwtBuilder builder = Jwts.builder().setId(username)
    //         .setIssuedAt(now)
    //         .setSubject(role)
    //         .signWith(signatureAlgorithm, signingKey);
  
    // //if it has been specified, let's add the expiration
    // long ttlMillis=6000890;
    // if (ttlMillis > 0) {
    //     long expMillis = nowMillis + ttlMillis;
    //     Date exp = new Date(expMillis);
    //     builder.setExpiration(exp);
    // }  
  
    // //Builds the JWT and serializes it to a compact, URL-safe string
    // return builder.compact();
  }
  public static boolean validateToken(String token) {
    //System.out.println("hello+"+token);
    try {
       Claims claims = Jwts.parser()
             .setSigningKey(SECRET_KEY)
             .parseClaimsJws(token)
             .getBody();
      // Claims claims = Jwts.parser()
      //       .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
      //       .parseClaimsJws(token).getBody();
      
    } catch (MalformedJwtException e) {
        return false;
    } catch (ExpiredJwtException e) {
        return false;
    }catch (SignatureException e) {
        return false;
    }catch (UnsupportedJwtException e) {
        return false;
    }catch (IllegalArgumentException e) {
        return false;
    }
    return true;
}
      public static String getUsernameFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody().getSubject();
      }
}
