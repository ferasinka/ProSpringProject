package com.ferasinka.prospringproject.ch13;

import com.ferasinka.prospringproject.ch12.Contact;
import com.ferasinka.prospringproject.ch12.ContactService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;
import java.util.List;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceTestConfig.class})
@TestExecutionListeners({ServiceTestExecutionListener.class})
public class ContactServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private ContactService contactService;
	
	@PersistenceContext
	private EntityManager em;
	
	@Test
	public void testAddContact() throws Exception {
		deleteFromTables("contact");
		
		Contact contact = new Contact();
		
		contact.setFirstName("Rod");
		contact.setLastName("Johnson");
		
		contactService.save(contact);
		
		em.flush();
		
		List<Contact> contacts = contactService.findAll();
		
		Assert.assertEquals(1, contacts.size());
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void testAddContactWithJSR349Error() throws Exception {
		deleteFromTables("contact");
		
		Contact contact = new Contact();
		
		contactService.save(contact);
		
		em.flush();
		
		List<Contact> contacts = contactService.findAll();
		
		Assert.assertEquals(0, contacts.size());
	}
	
	@Test
	@DataSets(setUpDataSet = "ContactServiceImplTest.xls")
	public void testFindAll() throws Exception {
		List<Contact> result = contactService.findAll();
		
		Assert.assertNotNull(result);
		Assert.assertEquals(1, result.size());
	}
	
	@Test
	@DataSets(setUpDataSet = "ContactServiceImplTest.xls")
	public void testFindByFirstName1() throws Exception {
		Contact result = contactService.findByFirstName("Chris").get(0);
		
		Assert.assertNotNull(result);
	}
	
	@Test
	@DataSets(setUpDataSet = "ContactServiceImplTest.xls")
	public void testFindByFirstName2() throws Exception {
		Contact result = contactService.findByFirstName("Peter").get(0);
		
		Assert.assertNull(result);
	}
}
