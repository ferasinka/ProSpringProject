package com.ferasinka.prospringproject.ch6.usingannotations.queries;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class InsertContact extends SqlUpdate {
	private static final String SQL_INSERT_CONTACT = "INSERT INTO contact (first_name, last_name, birth_date) VALUES (:first_name, :last_name, :birth_date)";
	
	public InsertContact(DataSource dataSource) {
		super(dataSource, SQL_INSERT_CONTACT);
		
		super.declareParameter(new SqlParameter("first_name", Types.VARCHAR));
		super.declareParameter(new SqlParameter("last_name", Types.VARCHAR));
		super.declareParameter(new SqlParameter("birth_date", Types.DATE));
		super.setGeneratedKeysColumnNames("id");
		super.setReturnGeneratedKeys(true);
	}
}
