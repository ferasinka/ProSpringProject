package com.ferasinka.prospringproject.ch6;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlainContactDao implements ContactDao {
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Contact> findAll() {
		List<Contact> result = new ArrayList<>();
		
		try (Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM contact");
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Contact contact = new Contact();
				
				contact.setId(resultSet.getLong("id"));
				contact.setFirstName(resultSet.getString("first_name"));
				contact.setLastName(resultSet.getString("last_name"));
				contact.setBirthDate(resultSet.getDate("birth_date"));
				
				result.add(contact);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public List<Contact> findByFirstName(String firstName) {
		return null;
	}
	
	@Override
	public List<Contact> findAllWithDetail() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String findLastNameById(Long id) {
		return null;
	}
	
	@Override
	public String findFirstNameById(Long id) {
		return null;
	}
	
	@Override
	public void insert(Contact contact) {
		try (Connection connection = getConnection()) {
			PreparedStatement statement =
					connection.prepareStatement("INSERT INTO contact (first_name, last_name, birth_date) VALUES (?, ?, ?)",
							Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, contact.getFirstName());
			statement.setString(2, contact.getLastName());
			statement.setDate(3, contact.getBirthDate());
			statement.execute();
			
			ResultSet generatedKeys = statement.getGeneratedKeys();
			
			if (generatedKeys.next()) {
				contact.setId(generatedKeys.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void update(Contact contact) {
	
	}
	
	@Override
	public void delete(Long contactId) {
		try (Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement("DELETE FROM contact WHERE id=?");
			
			statement.setLong(1, contactId);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/prospring", "ferasinka", "12345");
	}
}
