package com.ferasinka.prospringproject.ch6;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcContactDao implements ContactDao, InitializingBean {
	private DataSource dataSource;
	//	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//
//		jdbcTemplate.setExceptionTranslator(new SQLErrorCodesTranslator());
//		this.jdbcTemplate = jdbcTemplate;
		
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public List<Contact> findAll() {
		String sql = "SELECT id, first_name, last_name, birth_date FROM contact";
		
		return namedParameterJdbcTemplate.query(sql, new ContactMapper());
	}
	
	@Override
	public List<Contact> findByFirstName(String firstName) {
		return null;
	}
	
	@Override
	public List<Contact> findAllWithDetail() {
		String sql = "SELECT c.id, c.first_name, c.last_name, c.birth_date, t.id as contact_tel_id, t.tel_type, t.tel_number FROM contact c LEFT JOIN contact_tel_detail t ON c.id = t.contact_id";
		
		return namedParameterJdbcTemplate.query(sql, new ContactWithDetailExtractor());
	}
	
	@Override
	public String findLastNameById(Long id) {
//		return jdbcTemplate.queryForObject("SELECT last_name FROM contact WHERE id = ?", new Object[]{id}, String.class);
		
		String sql = "SELECT last_name FROM contact WHERE id = :contactId";
		
		Map<String, Object> namedParameters = new HashMap<>();
		namedParameters.put("contactId", id);
		
		return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);
	}
	
	@Override
	public String findFirstNameById(Long id) {
//		return jdbcTemplate.queryForObject("SELECT first_name FROM contact WHERE id = ?", new Object[]{id}, String.class);
		return "";
	}
	
	@Override
	public void insert(Contact contact) {
	
	}
	
	@Override
	public void update(Contact contact) {
	
	}
	
	@Override
	public void delete(Long contactId) {
	
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if (dataSource == null) {
			throw new BeanCreationException("Must set dataSource on ContactDao");
		}

//		if (jdbcTemplate == null) {
//			throw new BeanCreationException("Null JdbcTemplate on ContactDao");
//		}
		
		if (namedParameterJdbcTemplate == null) {
			throw new BeanCreationException("Null NamedParameterJdbcTemplate on ContactDao");
		}
	}
	
	private static final class ContactMapper implements RowMapper<Contact> {
		@Override
		public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
			Contact contact = new Contact();
			
			contact.setId(rs.getLong("id"));
			contact.setFirstName(rs.getString("first_name"));
			contact.setLastName(rs.getString("last_name"));
			contact.setBirthDate(rs.getDate("birth_date"));
			
			return contact;
		}
	}
	
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
