package com.springrestapi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.springrestapi.entity.Employee;
import com.springrestapi.entity.UserLogin;
import com.springrestapi.service.DataServices;



@RestController
public class EmployeeController {
	
	@Autowired(required = true)
	DataServices ds;
	
	@Autowired(required = true)
	HttpSession hs;
	
	public EmployeeController()
	{
		System.out.println("employeecontroller");
	}
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public ModelAndView indexpage()
	{
		hs.setAttribute("name", "kumar");
		return new ModelAndView("Angexample");
	}
	
	//create employee
	@RequestMapping(value="/employee/", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<String> createemployee(@RequestBody Employee emp)
	{
		System.out.println("creatEmployee");
		//boolean status=false;
		System.out.println("Addemployee"+emp.getName());
		try {
			//ds.addEntity(emp);
			
			if(isUserExist(emp.getName()))
			{
				System.out.println("A User with name " + emp.getName() + " already exist");
				return new ResponseEntity<String>("User already exist", HttpStatus.CONFLICT);
			}
			else
			{
				ds.addEntity(emp);
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
			
		}
		return new ResponseEntity<String>("user added",HttpStatus.CREATED);
		
		
	}
	
	
	//get employee list
	@RequestMapping(value="/employeelist",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getEmployee() throws Exception
	{
		List<Employee> emp=ds.getEntityList();
		
		if(emp==null)
		{
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		}
		System.out.println(emp);
		return new ResponseEntity<List<Employee>>(emp,HttpStatus.OK);
	}
	
	
	public boolean isUserExist(String name)
	{
		List<Employee> emp=ds.getEmpByname(name);
		if(emp==null || emp.isEmpty())
		{
			return false;
		}
		return true;
		
	}
	
	//get particular employee
	
	@RequestMapping(value="/employee/{id}",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmpbyId(@PathVariable("id") long id) throws Exception
	{
		Employee emp=ds.getEntityById(id);
		
		if(emp==null || emp.equals(""))
		{
			return new ResponseEntity<Employee>(emp,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	@RequestMapping(value="/employee/delet/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id)throws Exception
	{
		String status=ds.deleteUser(id);
		
		if(status.equalsIgnoreCase("success"))
		{
			return new ResponseEntity<String>("Deleted",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Not Deleted",HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	/*//get user to create page
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public ModelAndView addemployee(@ModelAttribute("userlogin") UserLogin ul,BindingResult br)
	{
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("users", ds.getAlluser());
		return new ModelAndView("adduser",model);
		
	}
	
	@RequestMapping(value="/save" , method=RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("userlogin") UserLogin ul,BindingResult br)
	{
		ds.addUser(ul);
		return new ModelAndView("redirect:/add.html");
	}*/
	
	
	

}
