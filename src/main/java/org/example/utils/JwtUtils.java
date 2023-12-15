package org.example.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.example.model.entity.User;

import java.util.Date;

public class JwtUtils {
    /**
     * 过期时间，一周
     */
    private  static final long EXPIRE = 60000 * 60 * 24 * 7;
    //private  static final long EXPIRE = 1;

    /**
     *
     */

    private  static final String SECRET = "xdclass";

    public static String generateToken(User user){

        String token = Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .claim("userId", user.getId())
                .claim("username", user.getName())
                .compact();
        return token;
    }

    public static Claims checkToken(String token){
        try{
            final  Claims claims = Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token).getBody();
            return claims;
        }catch (Exception e){
            return null;
        }
    }
}
