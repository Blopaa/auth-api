package dev.pablosabater.jwt_auth.infrastructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import dev.pablosabater.jwt_auth.dom.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JWTUtils {
    private String secret = "SUPER";

    public String creation(User user) {
        try{
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withClaim("id", user.getId())
                    .sign(algorithm);
        }catch(JWTCreationException e){
            return "bla";
        }
    }
}
