package com.ferasinka.prospringproject.ch14;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptTest {
	public static void main(String[] args) {
		ScriptEngineManager mgr = new ScriptEngineManager();
		
		ScriptEngine jsEngine = mgr.getEngineByName("JavaScript");
		
		try {
			jsEngine.eval("print('Hello JavaScript in Java')");
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}
}
