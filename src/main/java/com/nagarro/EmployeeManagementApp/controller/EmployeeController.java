package com.nagarro.EmployeeManagementApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.EmployeeManagementApp.Employee;
import com.nagarro.EmployeeManagementApp.dao.EmployeeDao;

/**
 * Rest controller to map various urls to to different operations........... 
 * @author sanjeevsingh01
 *
 */
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeDao dao;//creating a EmployeeDao which is autowired...........
	
	/**
	 * This method take employee code and delete it from database.............
	 * @param code
	 * @return
	 */
	@DeleteMapping("/employee/{code}")
	public String deleteEmployee(@PathVariable int code)
	{
		dao.delete(dao.getOne(code));//deleting data from database.................
		return "Deleted";
	}
	
	/**
	 * This method maps /employee with save data to database.......... 
	 * @param employee
	 * @return
	 */
	@PutMapping("/employee")
	public Employee saveOrUpdateEmployee(@RequestBody Employee employee)
	{
		dao.save(employee);//It store data to database............
		return employee;
	}
	
	/**
	 * It is post mapping method to store data to database............
	 * @param employee
	 * @return
	 */
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		dao.save(employee);//It store data to database..............
		return employee;
	}
	
	/**
	 * getEmployee method find all the employee from data base...............
	 * @return
	 */
	@GetMapping("/employee")
	public List<Employee> getEmployee()
	{
		return dao.findAll();//it find all the employee from database..........
	}
	
	/**
	 * getEmployee function is use to find data by id from database..............
	 * @param code
	 * @return
	 */
	@GetMapping("/employee/{code}")
	public Optional<Employee> getEmployee(@PathVariable("code") int code)
	{
		return dao.findById(code);//it will find data by id form data base..................
	}
	
}


