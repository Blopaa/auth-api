package dev.pablosabater.jwt_auth.infrastructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import dev.pablosabater.jwt_auth.dom.entities.User;
import dev.pablosabater.jwt_auth.infrastructure.exceptions.ServerException;
import org.springframework.stereotype.Component;

@Component
public class JWTUtils {

    public String creation(User user) {
        try{
            var algorithm = Algorithm.HMAC256("SECRET");
            return JWT.create()
                    .withClaim("id", user.getId())
                    .sign(algorithm);
        }catch(JWTCreationException e){
            throw new ServerException("internal server error", "couldn't convert claims to json or an error occurred with sign key");
        }
    }
}
