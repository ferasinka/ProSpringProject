package com.ferasinka.prospringproject.ch12;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.impl.client.BasicCredentialsProvider;

public class CustomCredentialsProvider extends BasicCredentialsProvider {
	@Override
	public void setCredentials(AuthScope authscope, Credentials credentials) {
		this.setCredentials(AuthScope.ANY, credentials);
	}
}
