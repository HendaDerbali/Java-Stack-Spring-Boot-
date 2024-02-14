package com.burgerTracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.burgerTracker.models.Burger;
import com.burgerTracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	
	// adding the Burger repository as a dependency
    private final BurgerRepository burgerRepository;
    
    public BurgerService(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }
    // returns all the Burgers
    public List<Burger> allBurgers() {
        return burgerRepository.findAll();
    }
    // creates a Burger
    public Burger createBurger(Burger b) {
        return burgerRepository.save(b);
    }
    // retrieves a Burger
    public Burger findBurger(Long id) {
        Optional<Burger> optionalBurger = burgerRepository.findById(id);
        if(optionalBurger.isPresent()) {  //isPresent() : method to check if our object exists.
            return optionalBurger.get();
        } else {
            return null;
        }
    }
     // update a Burger
  	  public Burger updateBurger(Burger b) {
        return burgerRepository.save(b);
    }
  	  
     // find by containing
  	  public List<Burger> burgersContaining(String search) {
        return burgerRepository.findByNotesContaining(search);
    }
	public void deleteBurger(Long id) {
		burgerRepository.deleteById(id);
	}

}
