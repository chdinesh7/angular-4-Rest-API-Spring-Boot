package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class A_Service_Imp implements A_Service {
	@Autowired
	public AngularDao angularDao;
	
	@Override
	    public AngularModel in(AngularModel angularModel) {
		
		return angularDao.save(angularModel);
	}
	@Override
    public AngularModel up(AngularModel angularModel) {
	
	return angularDao.save(angularModel);
}
     
}
