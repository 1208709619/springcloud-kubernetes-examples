package com.kubernetes.example.organzation.dao;

import com.kubernetes.example.organzation.domain.Organization;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;


@Transactional
public interface OrganizationDao extends CrudRepository<Organization,String> {

}
