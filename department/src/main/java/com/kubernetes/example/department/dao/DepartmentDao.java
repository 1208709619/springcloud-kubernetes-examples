package com.kubernetes.example.department.dao;

import com.kubernetes.example.department.domain.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentDao extends CrudRepository<Department,String> {
    List<Department> findDepartmentsByOrganizationId(String organization);
}
