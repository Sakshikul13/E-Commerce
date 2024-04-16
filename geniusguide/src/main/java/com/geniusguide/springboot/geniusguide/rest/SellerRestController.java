package com.geniusguide.springboot.geniusguide.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geniusguide.springboot.geniusguide.entity.Seller;
import com.geniusguide.springboot.geniusguide.service.SellerService;

@RestController
@RequestMapping("/api")
public class SellerRestController {
	
	private SellerService sellerservice;
	
	@Autowired
	public SellerRestController(SellerService thesellerservice) {
		sellerservice = thesellerservice;
	}
	
	@GetMapping("/sellers")
	public List<Seller> findAll(){
		
		return sellerservice.findAll();
	}
	
	@GetMapping("/sellers/{userid}")
	public Seller findById(@PathVariable int userid) {
		
		Seller theseller = sellerservice.findById(userid);
		
		if(theseller == null) {
			throw new RuntimeException("Seller id is not found");
		}
		
		return theseller;
		
	}
	
	@PostMapping("/seller")
	public Seller addUser(@RequestBody Seller theseller) {
		
		theseller.setId(0);
		
		Seller dbseller = sellerservice.save(theseller);
		return dbseller;
	}
	
	@PutMapping("/seller")
	public Seller updateSeller(@RequestBody Seller theseller) {
		
		Seller seller = sellerservice.save(theseller);
		return seller;
	}
	
	@DeleteMapping("/sellers/{sellerid}")
	public String deleteSeller(@PathVariable int sellerid) {
		Seller seller = sellerservice.findById(sellerid);
		
		if(seller == null) {
			throw new RuntimeException("The Seller id is not found "+ sellerid);
		}
		
		sellerservice.delete(sellerid);
		
		return "Deleted Seller with id "+sellerid;
		
	}
	
	
}
