package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;







@RestController
public class AngularControler {
	@Autowired
	   public A_Service a_Service;
	
	@Autowired
	 public AngularDao angularDao;
	@PostMapping("/insert")
	 public AngularModel web( @RequestBody AngularModel angularModel) {	    	
	        return a_Service.in(angularModel);        
	    }
	@RequestMapping("/r")	
	public List<AngularModel> getAllWebModel(){
		return (List<AngularModel>)angularDao.findAll();
	}	
@RequestMapping("/r/{id}")
	
	public ResponseEntity<Optional<AngularModel>> getWebModelById1(@PathVariable(value = "id") Long Id) {
	Optional<AngularModel> note = angularDao.findById(Id);
	if(note == null) {
        
            return ResponseEntity.notFound().build();
	    }
        return ResponseEntity.ok().body(note);
    }
	
	/*@DeleteMapping("/trash")	
	public String dele(@RequestParam("id")Long id) {
    	Optional<AngularModel> dele = angularDao.findById(id);
    	
    	if(dele.isPresent()) {
    		AngularModel d=dele.get();
    		
    		angularDao.delete(d);
    	}
    	
		return "successfully";
	}*/
	 @RequestMapping("/trash/{id}")
		
		public ResponseEntity<Optional<AngularModel>> getWebModelById(@PathVariable(value = "id") Long Id) {
		 Optional<AngularModel> note = angularDao.findById(Id);
	        if(note.isPresent()) {
	        	AngularModel d=note.get();
	    		angularDao.delete(d);
	        }
	        return ResponseEntity.ok().body(note);
	    }
	 
		@RequestMapping("/edit1")
		 public AngularModel web1( @RequestBody AngularModel angularModel) {	    	
		        return a_Service.up(angularModel);        
		    }
    

}
