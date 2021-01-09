package com.example.springsocial.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface Users extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByEmail(String email);

    Boolean existsByEmail(String email);

}
