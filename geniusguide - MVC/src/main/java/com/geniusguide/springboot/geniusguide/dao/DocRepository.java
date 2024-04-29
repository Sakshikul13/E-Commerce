package com.geniusguide.springboot.geniusguide.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geniusguide.springboot.geniusguide.entity.Doc;


public interface DocRepository  extends JpaRepository<Doc,Integer>{

}
