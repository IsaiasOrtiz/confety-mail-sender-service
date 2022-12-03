package com.confety.mail.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.confety.mail.entity.Templates;

@Repository
public interface TemplateRepository extends CrudRepository<Templates, Integer>{

}
