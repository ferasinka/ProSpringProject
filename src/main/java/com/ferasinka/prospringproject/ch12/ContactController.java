package com.ferasinka.prospringproject.ch12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/contact")
public class ContactController {
	private static final Logger LOG = LoggerFactory.getLogger(ContactController.class);
	
	private ContactService contactService;
	
	@Autowired
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}
	
	@ResponseBody
	@RequestMapping(value = "/listdata", method = RequestMethod.GET)
	public Contacts listData() {
		return new Contacts(contactService.findAll());
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Contact findContactById(@PathVariable Long id) {
		return contactService.findById(id);
	}
	
	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Contact create(@RequestBody Contact contact) {
		LOG.info("Creating contact: " + contact);
		
		contactService.save(contact);
		
		LOG.info("Contact created successfully with info: " + contact);
		
		return contact;
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@RequestBody Contact contact, @PathVariable Long id) {
		LOG.info("Updating contact: " + contact);
		
		contactService.save(contact);
		
		LOG.info("Contact updated successfully with info: " + contact);
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		LOG.info("Deleting contact with id: " + id);
		
		Contact contact = contactService.findById(id);
		contactService.delete(contact);
		
		LOG.info("Contact deleted successfully");
	}
}
