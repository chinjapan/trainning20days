package com.bookstore.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.extension.ResourceNotFoundException;
import com.bookstore.model.bookinfor;
import com.bookstore.repository.bookinforrepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class bookinforcontroller {
	
	@Autowired
	private bookinforrepository bookinforepository ;
	
	//get all bookinfo
	@GetMapping("/getallbookinfo")
	public List<bookinfor> getallbookinfo(){
		return bookinforepository.findAll();
	}
	
	//Create bookinfo
	@PostMapping("/createbookinfo")
	public bookinfor createbookinfo(@RequestBody bookinfor bookinfo) {
		return bookinforepository.save(bookinfo);
	}
	
	//Get Bookinfo by Id rest api
	@GetMapping("/bookinfo/{id}")
	public ResponseEntity<bookinfor> getbookinfobyid(@PathVariable Long id) {
		bookinfor bookinfo = bookinforepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Bookinfo not exist with: " + id));
		return ResponseEntity.ok(bookinfo);
	}
	
	//update bookinfo
		@PutMapping("/updatebookinfo/{id}")
		public ResponseEntity<bookinfor> updatebookinfo(@PathVariable Long id, @RequestBody bookinfor bookinfodetail) {
			bookinfor bookinfo = bookinforepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Bookinfo not exist with: " + id));
			
			bookinfo.setBookname(bookinfodetail.getBookname());
			bookinfo.setCompanyname(bookinfodetail.getCompanyname());
			bookinfo.setCost(bookinfodetail.getCost());
			bookinfo.setPagenumber(bookinfodetail.getPagenumber());
			
			bookinfor updatebookinfo = bookinforepository.save(bookinfo);
			return ResponseEntity.ok(updatebookinfo);
		}
		
		//delete bookinfo	
		@DeleteMapping("/deletebookinfo/{id}")
		public ResponseEntity<Map<String, Boolean>> deletebookinfo(@PathVariable Long id){
			bookinfor bookinfo = bookinforepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Bookinfo not exist with: " + id));
			
			bookinforepository.delete(bookinfo);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			
			return ResponseEntity.ok(response);
			
		}

}
