package com.smart.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smart.contact.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer>{

}
