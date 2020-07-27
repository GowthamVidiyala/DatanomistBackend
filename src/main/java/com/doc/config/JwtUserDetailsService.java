package com.doc.config;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.doc.dao.PatientRepository;
import com.doc.entity.Patient;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	
	@Autowired
	private PatientRepository patientDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Patient patient = patientDao.findByName(username);  
		
		if(patient==null)
			throw new UsernameNotFoundException("User not found with that username"+username);
		
		return new User(patient.getName(), patient.getPassword(),
				new ArrayList<>());
	}			
		
	//Hardcoded
		
//		if ("javainuse".equals(username)) {
//			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
	
}