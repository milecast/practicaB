package com.upc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.repository.TipoRepository;

@Service
public class TipoService implements ITipoService{

	@Autowired
	private TipoRepository tipoRepository;
}
