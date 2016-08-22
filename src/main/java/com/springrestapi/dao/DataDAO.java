package com.springrestapi.dao;

import java.util.List;

import com.springrestapi.entity.Employee;
import com.springrestapi.entity.UserLogin;

public interface DataDAO {
	
	public boolean addEntity(Employee employee);
	public Employee getEntityById(long id) throws Exception;
	public List<Employee> getEntityList() throws Exception;
	public boolean deletEntityById(long id)throws Exception;
	
	public List<Employee> getEmpByname(String name);
	
	
	public String addUser(UserLogin user);
	public UserLogin getUserbyId(Long id);
	public List<UserLogin> getAlluser();
	public String deleteUser(Long id);
	

}
