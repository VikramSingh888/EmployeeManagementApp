package com.nagarro.EmployeeManagementApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nagarro.EmployeeManagementApp.Employee;


/**
 * This method extends jpsRepository and it use to perform CURD operation...........
 * @author sanjeevsingh01
 *
 */
public interface EmployeeDao extends JpaRepository<Employee,Integer>
{

}
