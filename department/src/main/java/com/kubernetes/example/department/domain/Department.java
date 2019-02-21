package com.kubernetes.example.department.domain;



import com.alibaba.druid.support.json.JSONUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_department")
public class Department {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "organizationId")
    private String organizationId;

    @Column(name = "name")
    private String name;


    @Transient
    private transient List<Employee> employees;

    @Column(name = "employeeListJson")
    private String employeeListJson;


    public Department(){
        this.employees = new ArrayList<>();
        this.employeeListJson="";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        if(this.employees==null){
            this.employees = (List<Employee>) JSONUtils.parse(this.employeeListJson);
        }
        return employees;
    }


    public  void setEmployees(List<Employee> employees) {
        this.employees = employees;
        this.employeeListJson = JSONUtils.toJSONString(this.employees);
    }

    public String getEmployeeListJson() {
        return employeeListJson;
    }

    public void setEmployeeListJson(String employeeListJson) {
        this.employeeListJson = employeeListJson;
        this.employees = (List<Employee>) JSONUtils.parse(this.employeeListJson);
    }
}
