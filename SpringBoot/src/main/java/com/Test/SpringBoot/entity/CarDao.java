package com.Test.SpringBoot.entity;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarDao extends JpaRepository<Car, String>{
	
	@Transactional		
	@Query("select c from Car c where c.carType = :inputcarType")		
	public List<Car> queryBycarType(		
			          @Param("inputcarType")String carType);
}
