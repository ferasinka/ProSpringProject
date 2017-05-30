package com.ferasinka.prospringproject.ch6.usingannotations.queries;

import com.ferasinka.prospringproject.ch6.Contact;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAllContacts extends MappingSqlQuery<Contact> {
	private static final String SQL_SELECT_ALL_CONTACT = "SELECT id, first_name, last_name, birth_date FROM contact";
	
	public SelectAllContacts(DataSource dataSource) {
		super(dataSource, SQL_SELECT_ALL_CONTACT);
	}
	
	@Override
	@SuppressWarnings("Duplicates")
	protected Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact contact = new Contact();
		
		contact.setId(rs.getLong("id"));
		contact.setFirstName(rs.getString("first_name"));
		contact.setLastName(rs.getString("last_name"));
		contact.setBirthDate(rs.getDate("birth_date"));
		
		return contact;
	}
}
