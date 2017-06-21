package com.ferasinka.prospringproject.ch10;

public enum Gender {
	MALE("M"), FEMALE("F");
	
	private String code;
	
	Gender(String code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return this.code;
	}
}
