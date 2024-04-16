package com.geniusguide.springboot.geniusguide.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geniusguide.springboot.geniusguide.entity.Seller;

public interface SellerRepository extends JpaRepository<Seller, Integer>{

}
