package com.kubernetes.example.organzation.controller;

import com.kubernetes.example.organzation.dao.OrganizationDao;
import com.kubernetes.example.organzation.domain.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrganizationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);

    @Autowired
    private OrganizationDao repository;

    @PostMapping("/")
    public Organization add(@RequestBody Organization organization) {
        LOGGER.info("Organization add:{}", organization);
        return repository.save(organization);
    }

    @GetMapping("/{id}")
    public Organization findById(@PathVariable("id") String id) {
        LOGGER.info("Organization find: id={}", id);
        return repository.findById(id).get();
    }

    @GetMapping("/")
    public Iterable findAll() {
        LOGGER.info("Organization find");
        return repository.findAll();
    }
}
