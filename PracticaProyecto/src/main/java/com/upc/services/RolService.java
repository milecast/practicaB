package com.upc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.repository.RolRepository;

@Service
public class RolService implements IRolService{

	@Autowired
	private RolRepository rolRepository;
}
