package com.ferasinka.prospringproject.ch6.usingannotations.queries;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class UpdateContact extends SqlUpdate {
	private static final String SQL_UPDATE_CONTACT = "UPDATE contact SET first_name = :first_name, last_name = :last_name, birth_date = :birth_date WHERE id = :id";
	
	public UpdateContact(DataSource dataSource) {
		super(dataSource, SQL_UPDATE_CONTACT);
		
		super.declareParameter(new SqlParameter("first_name", Types.VARCHAR));
		super.declareParameter(new SqlParameter("last_name", Types.VARCHAR));
		super.declareParameter(new SqlParameter("birth_date", Types.DATE));
		super.declareParameter(new SqlParameter("id", Types.INTEGER));
	}
}
