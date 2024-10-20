package com.smart.contact.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.contact.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

	Optional<User> findByEmail(String email);
	Optional<User> findByEmailAndPassword(String email,String password);
	Optional<User> findByemailToken(String token);
	Optional<User> findByPasswordResetToken(String token);

}
