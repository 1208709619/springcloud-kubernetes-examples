package com.kubernetes.example.department.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.kubernetes.example.department.dao.DepartmentDao;
import com.kubernetes.example.department.domain.Department;
import com.kubernetes.example.department.protocol.EmployeeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentDao repository;
    @Autowired
   private EmployeeClient employeeClient;

    @PostMapping("/")
    public Department add(@RequestBody Department department) {
        LOGGER.info("Department add:{}", department);
        return repository.save(department);
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") String id) {
        LOGGER.info("Department find: id={}", id);
        return repository.findById(id).get();
    }

    @GetMapping("/")
    public Iterable findAll() {
        LOGGER.info("Department find");
        return repository.findAll();
    }

    @GetMapping("/organization/{organizationId}/with-employees")
    public List findByOrganizationWithEmployees(@PathVariable("organizationId") String organizationId) {
        LOGGER.info("Department find: organizationId={}", organizationId);
        List<Department> departments = repository.findDepartmentsByOrganizationId(organizationId);
        departments.forEach(d -> d.setEmployees(employeeClient.findByDepartment(d.getId())));
        return departments;
    }
}
