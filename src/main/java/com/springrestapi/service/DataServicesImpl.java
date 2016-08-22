package com.springrestapi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrestapi.dao.DataDAO;
import com.springrestapi.entity.Employee;
import com.springrestapi.entity.UserLogin;

@Transactional
@Service
public class DataServicesImpl implements DataServices {

	@Autowired(required =true)
	DataDAO dd;
	
	public boolean addEntity(Employee emp) throws Exception
	{
		return dd.addEntity(emp);
		
	}

	public Employee getEntityById(long id) throws Exception {
		// TODO Auto-generated method stub
		return dd.getEntityById(id); 
	}

	public List<Employee> getEntityList() throws Exception {
		// TODO Auto-generated method stub
		return dd.getEntityList();
	}

	public boolean deletEntityById(long id) throws Exception {
		// TODO Auto-generated method stub
		return dd.deletEntityById(id);
	}

	public String addUser(UserLogin user) {
		// TODO Auto-generated method stub
		return dd.addUser(user);
		
	}

	public UserLogin getUserbyId(Long id) {
		// TODO Auto-generated method stub
		return dd.getUserbyId(id);
	
	}

	public List<UserLogin> getAlluser() {
		// TODO Auto-generated method stub
		return dd.getAlluser();
	}

	public String deleteUser(Long id) {
		// TODO Auto-generated method stub
		return dd.deleteUser(id);
	}

	public List<Employee> getEmpByname(String name) {
		// TODO Auto-generated method stub
		return dd.getEmpByname(name);
	}
	
	
	
	
}
