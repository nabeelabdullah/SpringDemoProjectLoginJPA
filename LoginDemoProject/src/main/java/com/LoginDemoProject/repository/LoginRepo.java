package com.LoginDemoProject.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.LoginDemoProject.Entity.LoginTable;

@Transactional
public interface LoginRepo extends CrudRepository<LoginTable, Long>{
	
	
	@Query("from LoginTable where email=?")
	LoginTable findByEmail(String email);

}
