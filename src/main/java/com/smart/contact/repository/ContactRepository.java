package com.smart.contact.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smart.contact.model.Contact;
import com.smart.contact.model.User;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

	Page<Contact> findByUser(User user, Pageable pageable);
	List<Contact> findByUser(User user);

	@Query("SELECT c FROM Contact c WHERE c.user.id=:userId")
	List<Contact> findByUserId(@Param("userId") String userId);

	Page<Contact> findByUserAndFavoriteTrue(User user, PageRequest pageable);

	@Query("SELECT c FROM Contact c WHERE LOWER(c.firstName) LIKE LOWER(CONCAT('%', :firstNamekeyword, '%')) AND c.user = :user")
	Page<Contact> findByUserAndFirstNameContaining(@Param("user") User user,
			@Param("firstNamekeyword") String firstNamekeyword, Pageable pageable);

	@Query("SELECT c FROM Contact c WHERE LOWER(c.lastName) LIKE LOWER(CONCAT('%', :lastNamekeyword, '%')) AND c.user = :user")
	Page<Contact> findByUserAndLastNameContaining(@Param("user") User user,
			@Param("lastNamekeyword") String lastNamekeyword, Pageable pageable);

	@Query("SELECT c FROM Contact c WHERE LOWER(c.email) LIKE LOWER(CONCAT('%', :emailkeyword, '%')) AND c.user = :user")
	Page<Contact> findByUserAndEmailContaining(@Param("user") User user, @Param("emailkeyword") String emailkeyword,
			Pageable pageable);

	Page<Contact> findByUserAndPhoneContaining(User user, String phonekeyword, Pageable pageable);

}
