package com.springrestapi.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springrestapi.entity.Employee;
import com.springrestapi.entity.UserLogin;

@Repository
public class DataDAOImpl implements DataDAO {
	
	@Autowired(required = true)
	SessionFactory sessionFactory;
	Session session=null;
	Transaction tx=null;
	
	
	public boolean addEntity(Employee emp) 
	{
		try
		{
		session=sessionFactory.openSession();
		tx=session.beginTransaction();
		session.save(emp);
		tx.commit();
		session.close();
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Employee getEntityById(long id) throws Exception {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		Employee employee = (Employee) session.load(Employee.class,id);
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return employee;
	}

	public List<Employee> getEntityList() throws Exception {
		// TODO Auto-generated method stub
		session=sessionFactory.openSession();
		tx=session.beginTransaction();
		List<Employee> emplist=session.createCriteria(Employee.class).list();
		tx.commit();
		session.close();
		return emplist;
	}

	public boolean deletEntityById(long id) throws Exception {
		// TODO Auto-generated method stub
		
		session=sessionFactory.openSession();
		Object o=session.load(Employee.class,id);
		tx=session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		session.close();
		return false;
	}

	public String addUser(UserLogin user) {
		// TODO Auto-generated method stub
		try
		{
		session=sessionFactory.openSession();
		tx=session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		return "success";
	}

	public UserLogin getUserbyId(Long id) {
		// TODO Auto-generated method stub
		UserLogin lg=new UserLogin();
		try
		{
		session=sessionFactory.openSession();
		lg=(UserLogin)session.load(UserLogin.class, new Long(id));
		tx=session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return lg=null;
		}
		
		return lg;
	}

	public List<UserLogin> getAlluser() {
		// TODO Auto-generated method stub
		
		List<UserLogin> lg=null;
		try
		{
		session=sessionFactory.openSession();
		tx=session.beginTransaction();
		lg=session.createCriteria(UserLogin.class).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return lg;
		}
		
		return lg;
	}

	public String deleteUser(Long id) {
		// TODO Auto-generated method stub
		try
		{
		session=sessionFactory.openSession();
		Object o=(Object)session.load(UserLogin.class, new Long(id));
		tx=session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "failure";
		}
		return "success";
		
	}

	public List<Employee> getEmpByname(String name) {
		// TODO Auto-generated method stub
		List<Employee> ee=null;
		try
		{
			session=sessionFactory.openSession();
			tx=session.getTransaction();
			session.beginTransaction();
			Criteria crit=session.createCriteria(Employee.class);
			crit.add(Restrictions.eqOrIsNull("name", name));
			ee=crit.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		return ee;
		}
		
		return ee;
	}
	
	
	
	
	
	
	
	

}
