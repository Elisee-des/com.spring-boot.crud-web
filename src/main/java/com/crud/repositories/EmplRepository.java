package com.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.model.Employee;

@Repository
public interface EmplRepository  extends JpaRepository<Employee, Integer>{

}
