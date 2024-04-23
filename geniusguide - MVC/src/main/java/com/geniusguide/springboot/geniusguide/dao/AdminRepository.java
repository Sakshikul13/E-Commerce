package com.geniusguide.springboot.geniusguide.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geniusguide.springboot.geniusguide.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
