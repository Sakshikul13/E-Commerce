package com.geniusguide.springboot.geniusguide.service;

import java.util.List;
import java.util.Optional;

import com.geniusguide.springboot.geniusguide.entity.Seller;

public interface SellerService {

	public List<Seller> findAll();
	
	public Seller findById(int id);
	
	public Seller save(Seller seller);
	
	void delete(int id);
	
}
