package com.kubernetes.example.department.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class Employee {
    private String id;
    private Long organizationId;
    private Long departmentId;
    private String name;
    private int age;
    private String position;
}
