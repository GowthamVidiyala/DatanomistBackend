package com.doc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doc.config.JwtTokenUtil;
import com.doc.config.JwtUserDetailsService;
import com.doc.entity.Patient;
import com.doc.entity.dto.JwtResponse;
import com.doc.entity.dto.PatientLogin;
import com.doc.service.PatientService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/register")
	public boolean register(@RequestBody Patient patient)
	{

		try {
			System.out.println(patient.getEmailId());
			patientService.savePatient(patient);
		    return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	@GetMapping("/dashboard")
	public String hello()
	{
		return "Hello Gowtham";
	}
	
/*
	@PostMapping("/authenticate")
	public boolean logi(@RequestBody PatientLogin patientLogin)
	{
		try {
			Patient patient = patientService.getPatientsByNameAndPassword(patientLogin.getName(), patientLogin.getPassword());
			if(patient!=null)
			{
				
				return true;
			}	
		}
		catch(Exception e)
		{
			
	    }
		
		return false;
	}
	
*/
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	/*
	 * 
	 * Expose a POST API /authenticate using the Controller.
	 *  The POST API gets the username and password in the body.
	 *   Using the Spring Authentication Manager, we authenticate the username and password. 
	 *   If the credentials are valid, a JWT token is created using the JWTTokenUtil and is provided to the client.
	 */
	
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> login(@RequestBody PatientLogin patientLogin) throws Exception {

		authenticate(patientLogin.getName(), patientLogin.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(patientLogin.getName());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

}
