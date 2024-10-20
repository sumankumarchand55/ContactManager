package com.smart.contact.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.smart.contact.helper.ResourceNotFoundException;
import com.smart.contact.model.Contact;
import com.smart.contact.model.User;
import com.smart.contact.repository.ContactRepository;
import com.smart.contact.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Contact saveContact(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
	public Contact getContactById(int id) {
		return contactRepository.findById(id).orElse(null);
	}

	@Override
	public Contact updateContact(int id,Contact contact) {
		Contact existingContact=contactRepository.findById(id).
				orElseThrow(()->new ResourceNotFoundException("contact not found"));
		 if (existingContact!= null) {
			 existingContact.setFirstName(contact.getFirstName());
			 existingContact.setLastName(contact.getLastName());
			 existingContact.setEmail(contact.getEmail());
			 existingContact.setImage(contact.getImage());
			 existingContact.setPhone(contact.getPhone());
			 existingContact.setFavorite(contact.isFavorite());
		  return contactRepository.save(existingContact);
	        }
	        return null;
	    }

	@Override
	public void deleteContact(int id) {
		Contact contact2=contactRepository.findById(id).
				orElseThrow(()->new ResourceNotFoundException("Contact not found"));
		contactRepository.delete(contact2);
	}

	@Override
	public List<Contact> getAllContacts() {
	return contactRepository.findAll();
	}

	@Override
	public List<Contact> getByUserId(String userId) {
		return contactRepository.findByUserId(userId);
	}

	@Override
	public Page<Contact> getByUser(User user,int page,int size,String sortBy,String direction) {

		Sort sort=direction.equals("desc")?Sort.by(sortBy).descending():Sort.by(sortBy).ascending();
		var pageable=PageRequest.of(page, size,sort);

		return contactRepository.findByUser(user,pageable);
	}

	@Override
	public Page<Contact> getFavoriteContactsByUser(User user, int page, int size, String sortBy, String direction) {
	    PageRequest pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), sortBy));
	    return contactRepository.findByUserAndFavoriteTrue(user, pageable);
	}

	@Override
	public Page<Contact> searchByFirstName(User user,String firstNameKeyword, int size, int page, String sortBy, String order) {
	   Sort sort=order.equals("desc")?Sort.by(sortBy).descending():Sort.by(sortBy).ascending();
		PageRequest pageable = PageRequest.of(page, size, sort);
		return contactRepository.findByUserAndFirstNameContaining(user,firstNameKeyword,pageable);
	}

	@Override
	public Page<Contact> searchByLastName(User user,String lastNameKeyword, int size, int page, String sortBy, String order) {
		 Sort sort=order.equals("desc")?Sort.by(sortBy).descending():Sort.by(sortBy).ascending();
			PageRequest pageable = PageRequest.of(page, size, sort);
			return contactRepository.findByUserAndLastNameContaining(user,lastNameKeyword,pageable);
	}

	@Override
	public Page<Contact> searchByEmail(User user,String emailKeyword, int size, int page, String sortBy, String order) {
		 Sort sort=order.equals("desc")?Sort.by(sortBy).descending():Sort.by(sortBy).ascending();
			PageRequest pageable = PageRequest.of(page, size, sort);
			return contactRepository.findByUserAndEmailContaining(user,emailKeyword,pageable);
	}

	@Override
	public Page<Contact> searchByPhoneNumber(User user,String phoneKeyword, int size, int page, String sortBy, String order) {
		 Sort sort=order.equals("desc")?Sort.by(sortBy).descending():Sort.by(sortBy).ascending();
			PageRequest pageable = PageRequest.of(page, size, sort);
			return contactRepository.findByUserAndPhoneContaining(user,phoneKeyword,pageable);
	}

	@Override
	public List<Contact> getAllContactsByUser(User user) {
	    return contactRepository.findByUser(user); 
	}


}