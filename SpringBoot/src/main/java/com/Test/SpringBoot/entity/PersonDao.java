package com.Test.SpringBoot.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person, String>{

}
