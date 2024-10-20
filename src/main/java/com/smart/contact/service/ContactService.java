package com.smart.contact.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.smart.contact.model.Contact;
import com.smart.contact.model.User;

public interface ContactService {
	Contact saveContact(Contact contact);
    Contact  getContactById(int id);
    Contact updateContact(int id,Contact contact);
    void deleteContact(int id);
    List<Contact> getAllContacts();

    Page<Contact> searchByFirstName(User user, String firstNameKeyword,int size,int page,String sortBy,String order);
    Page<Contact> searchByLastName(User user, String lastNameKeyword,int size,int page,String sortBy,String order);
    Page<Contact> searchByEmail(User user, String emailKeyword,int size,int page,String sortBy,String order);
    Page<Contact> searchByPhoneNumber(User user, String phoneKeyword,int size,int page,String sortBy,String order);

    List<Contact> getByUserId(String userId);
	Page<Contact> getByUser(User user, int page, int size, String sortBy, String direction);
	Page<Contact> getFavoriteContactsByUser(User user, int page, int size, String sortBy, String direction);
	List<Contact> getAllContactsByUser(User user);
}
