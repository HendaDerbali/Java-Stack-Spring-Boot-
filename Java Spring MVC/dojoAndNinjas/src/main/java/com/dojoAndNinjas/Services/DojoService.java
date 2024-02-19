package com.dojoAndNinjas.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dojoAndNinjas.Repositories.DojoRepository;
import com.dojoAndNinjas.models.Dojo;

@Service
public class DojoService {

	// adding the Dojo repository as a dependency
    private final DojoRepository dojoRepository;
    
    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }
    // returns all the Dojos
    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
    // creates a Dojo
    public Dojo createDojo(Dojo b) {
        return dojoRepository.save(b);
    }
    // retrieves a Dojo
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {  //isPresent() : method to check if our object exists.
            return optionalDojo.get();
        } else {
            return null;
        }
    }
     // update a Dojo
  	  public Dojo updateDojo(Dojo b) {
        return dojoRepository.save(b);
    }
  	  
     // find by containing
  	  public List<Dojo> DojosContaining(String search) {
        return dojoRepository.findByNameContaining(search);
    }
	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
	}
	

}

