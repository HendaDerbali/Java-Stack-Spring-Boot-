package com.dojoAndNinjas.Services;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dojoAndNinjas.Repositories.NinjaRepository;
import com.dojoAndNinjas.models.Ninja;

@Service
public class NinjaService {
	
	// adding the ninja repository as a dependency
    private final NinjaRepository ninjaRepository;
    
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
    // returns all the Ninjas
    public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }
    // creates a Ninja
    public Ninja createNinja(Ninja b) {
        return ninjaRepository.save(b);
    }
    // retrieves a Ninja
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if(optionalNinja.isPresent()) {  //isPresent() : method to check if our object exists.
            return optionalNinja.get();
        } else {
            return null;
        }
    }
     // update a Ninja
  	  public Ninja updateNinja(Ninja b) {
        return ninjaRepository.save(b);
    }
  	  
     // find by containing
  	  public List<Ninja> NinjasContaining(String search) {
        return ninjaRepository.findByFirstNameContaining(search);
    }
	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
	}

}

