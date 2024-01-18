package com.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.crud.model.Employee;
import com.crud.repositories.EmplRepository;

@Service
public class EmplService {
	
	private EmplRepository emplRepo;
	
    @Autowired
    public EmplService(EmplRepository emplRepo) {
        this.emplRepo = emplRepo;
    }
	
	public void addEmpl(Employee e)
	{
		emplRepo.save(e);
	}

	public List<Employee> getAllEmpl()
	{
		return emplRepo.findAll();
	}

    public Employee getEMpById(int id) {
        Optional<Employee> e = emplRepo.findById(id);
        return e.orElse(null);
    }
	
	public void deleteEMp(int id) {
		emplRepo.deleteById(id);
	}
	

}
