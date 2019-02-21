package com.kubernetes.example.employee.dao;

import com.kubernetes.example.employee.domain.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee,String> {
    List<Employee> findByDepartmentId(Long departmentId);
    List<Employee> findByOrganizationId (Long organizationId);
}
