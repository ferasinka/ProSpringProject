package com.ferasinka.prospringproject.ch6.usingannotations;

import com.ferasinka.prospringproject.ch6.Contact;
import com.ferasinka.prospringproject.ch6.ContactTelDetail;
import com.ferasinka.prospringproject.ch6.usingannotations.queries.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("contactDao")
public class JdbcContactDao implements ContactDao {
	private static final Logger LOG = LoggerFactory.getLogger(JdbcContactDao.class);
	
	private DataSource dataSource;
	private SelectAllContacts selectAllContacts;
	private SelectContactByFirstName selectContactByFirstName;
	private UpdateContact updateContact;
	private InsertContact insertContact;
	private InsertContactTelDetail insertContactTelDetail;
	private StoredFunctionFirstNameById storedFunctionFirstNameById;
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	@Resource(name = "dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.selectAllContacts = new SelectAllContacts(dataSource);
		this.selectContactByFirstName = new SelectContactByFirstName(dataSource);
		this.updateContact = new UpdateContact(dataSource);
		this.insertContact = new InsertContact(dataSource);
		this.storedFunctionFirstNameById = new StoredFunctionFirstNameById(dataSource);
	}
	
	@Override
	public List<Contact> findAll() {
		return selectAllContacts.execute();
	}
	
	@Override
	public List<Contact> findByFirstName(String firstName) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("first_name", firstName);
		
		return selectContactByFirstName.executeByNamedParam(paramMap);
	}
	
	@Override
	public String findFirstNameById(Long id) {
		return storedFunctionFirstNameById.execute(id).get(0);
	}
	
	@Override
	public List<Contact> findAllWithDetail() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		
		String sql = "SELECT c.id, c.first_name, c.last_name, c.birth_date, t.id as contact_tel_id, t.tel_type, t.tel_number FROM contact c LEFT JOIN contact_tel_detail t ON c.id = t.contact_id";
		
		return jdbcTemplate.query(sql, new ContactWithDetailExtractor());
	}
	
	@Override
	public void insert(Contact contact) {
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("first_name", contact.getFirstName());
		paramMap.put("last_name", contact.getLastName());
		paramMap.put("birth_date", contact.getBirthDate());
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		insertContact.updateByNamedParam(paramMap, keyHolder);
		
		contact.setId(keyHolder.getKey().longValue());
		
		LOG.info("New contact inserted with id: " + contact.getId());
	}
	
	@Override
	public void insertWithDetail(Contact contact) {
		this.insertContactTelDetail = new InsertContactTelDetail(dataSource);
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("first_name", contact.getFirstName());
		paramMap.put("last_name", contact.getLastName());
		paramMap.put("birth_date", contact.getBirthDate());
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		insertContact.updateByNamedParam(paramMap, keyHolder);
		
		contact.setId(keyHolder.getKey().longValue());
		
		LOG.info("New contact inserted with id: " + contact.getId());
		
		List<ContactTelDetail> contactTelDetails = contact.getContactTelDetails();
		
		if (contactTelDetails != null) {
			for (ContactTelDetail contactTelDetail : contactTelDetails) {
				paramMap = new HashMap<>();
				
				paramMap.put("contact_id", contact.getId());
				paramMap.put("tel_type", contactTelDetail.getTelType());
				paramMap.put("tel_number", contactTelDetail.getTelNumber());
				
				insertContactTelDetail.updateByNamedParam(paramMap);
			}
		}
		
		insertContactTelDetail.flush();
	}
	
	@Override
	public void update(Contact contact) {
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("first_name", contact.getFirstName());
		paramMap.put("last_name", contact.getLastName());
		paramMap.put("birth_date", contact.getBirthDate());
		paramMap.put("id", contact.getId());
		
		updateContact.updateByNamedParam(paramMap);
		
		LOG.info("Existing contact update with id: " + contact.getId());
	}
	
	@SuppressWarnings("Duplicates")
	private static final class ContactWithDetailExtractor implements ResultSetExtractor<List<Contact>> {
		@Override
		public List<Contact> extractData(ResultSet rs) throws SQLException, DataAccessException {
			Map<Long, Contact> map = new HashMap<>();
			Contact contact;
			
			while (rs.next()) {
				Long id = rs.getLong("id");
				contact = map.get(id);
				
				if (contact == null) {
					contact = new Contact();
					
					contact.setId(id);
					contact.setFirstName(rs.getString("first_name"));
					contact.setLastName(rs.getString("last_name"));
					contact.setBirthDate(rs.getDate("birth_date"));
					contact.setContactTelDetails(new ArrayList<>());
					
					map.put(id, contact);
				}
				
				Long contactTelDetailId = rs.getLong("contact_tel_id");
				
				if (contactTelDetailId > 0) {
					ContactTelDetail contactTelDetail = new ContactTelDetail();
					
					contactTelDetail.setId(contactTelDetailId);
					contactTelDetail.setContactId(id);
					contactTelDetail.setTelType(rs.getString("tel_type"));
					contactTelDetail.setTelNumber(rs.getString("tel_number"));
					
					contact.getContactTelDetails().add(contactTelDetail);
				}
			}
			
			return new ArrayList<>(map.values());
		}
	}
}
