package com.wipro;

import java.util.Map;

import com.wipro.model.Employee;

public class DummyDb {
	Map<Integer, Employee> dbMap;

	public Map<Integer, Employee> getDbMap() {
		return dbMap;
	}

	public void setDbMap(Map<Integer, Employee> dbMap) {
		this.dbMap = dbMap;
	}

	@Override
	public String toString() {
		return "DummyDb [dbMap=" + dbMap + "]";
	}
	
}
