package com.ferasinka.prospringproject.ch6.usingannotations.queries;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlFunction;

import javax.sql.DataSource;
import java.sql.Types;

public class StoredFunctionFirstNameById extends SqlFunction<String> {
	private static final String SQL = "SELECT getfirstnamebyid(?)";
	
	public StoredFunctionFirstNameById(DataSource dataSource) {
		super(dataSource, SQL);
		
		declareParameter(new SqlParameter(Types.INTEGER));
		compile();
	}
}
