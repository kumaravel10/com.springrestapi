package com.springrestapi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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


//consume rest services

import java.net.URI;
import org.springframework.web.client.RestTemplate;

import com.springrestapi.entity.Employee;

@RestController
public class EmployeeClientController {
	
	@Autowired
	HttpSession hs;
	
	private static final String restservice="http://localhost:8080/com.springrestapi/";
	
	
	@RequestMapping(value="emplist/",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getEmplist()
	{/*
		List<Employee> emplist=new ArrayList<Employee>();
		RestTemplate restTemplate=new RestTemplate();
		List<LinkedHashMap<String,Object>> userobj=restTemplate.getForObject(restservice+"employeelist/", List.class);
		if(userobj!=null)
		{
			for(LinkedHashMap<String,Object> map : userobj)
			{
				Employee emp=new Employee();
				emp.setId(Long.parseLong(map.get("id").toString()));
				emp.setAge(Integer.parseInt(map.get("age").toString()));
				emp.setName(map.get("name").toString());
				emp.setSalary(Float.parseFloat(map.get("salary").toString()));
				
				emplist.add(emp);
				
			}
		*/
		
		System.out.println(hs.getAttribute("name"));
		RestTemplate restTemplate=new RestTemplate();
		Employee[] emplist=restTemplate.getForObject(restservice+"employeelist/",Employee[].class);
		
		for (Employee employee : emplist) {
			System.out.println(employee);
		}
		
		if(emplist!=null)
		{
			return new ResponseEntity(emplist,HttpStatus.OK) ;
		}
		
		return new ResponseEntity<String>("data not available",HttpStatus.NO_CONTENT);
		
		
		
	}
	
	
	@RequestMapping(value="employeelistout/")
	public ModelAndView getEmployees()
	{
		RestTemplate rest=new RestTemplate();
		
		Employee[] emp=rest.getForObject(restservice+"employeelist/", Employee[].class);
		
		if(emp!=null)
		{
			return new ModelAndView("adduser","emp",emp);
		}
		return new ModelAndView("adduser","emp",emp);
		
	}
	
	

}
