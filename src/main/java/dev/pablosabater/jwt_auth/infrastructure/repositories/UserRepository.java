package dev.pablosabater.jwt_auth.infrastructure.repositories;

import dev.pablosabater.jwt_auth.dom.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
