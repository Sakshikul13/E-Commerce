package com.geniusguide.springboot.geniusguide.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geniusguide.springboot.geniusguide.dao.SellerRepository;
import com.geniusguide.springboot.geniusguide.entity.Seller;
@Service
public class SellerServiceImpl implements SellerService{

	private SellerRepository sellerrepository;
	
	@Autowired
	public SellerServiceImpl(SellerRepository thesellerrepository) {
		sellerrepository = thesellerrepository;
	}
	
	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return sellerrepository.findAll();
		
	}

	@Override
	public Seller findById(int id) {
		// TODO Auto-generated method stub
		Seller seller = null;
		
		Optional<Seller> result = sellerrepository.findById(id);
		
		if(result.isPresent()) {
			seller = result.get();
		}else {
//			throw new RuntimeException("Seller Id not found : "+id);
		}
		
		return seller;
	}

	@Override
	public Seller save(Seller seller) {
		// TODO Auto-generated method stub
		return sellerrepository.save(seller);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		sellerrepository.deleteById(id);
	}

}
