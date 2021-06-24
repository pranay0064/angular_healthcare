package com.pranay.cruddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pranay.cruddemo.entity.Doctor;
import com.pranay.cruddemo.service.DoctorService;


@RestController
@CrossOrigin(allowedHeaders="*",origins="*")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	@PostMapping("/registerDoctor")
	public Doctor registerDonor(@RequestBody Doctor doctor) {
		return doctorService.registerDoctor(doctor);
	}
	@GetMapping("/getDoctors")
	public List<Doctor> getDoctors(){
		return doctorService.getDoctors();
		
	}@DeleteMapping("/deleteDoctor")
	public void deleteDoctor(@RequestParam Integer id) {
		doctorService.deleteDoctor(id);
	}
	@PutMapping("/updateDoctor")
	public Doctor updateDoctor(@RequestBody Doctor doctor) {
		return doctorService.updateDoctor(doctor);
	}
	@GetMapping("/findDoctorbyid")
	public Doctor getDoctor(@RequestParam Integer id) {
		return doctorService.getOnlyDoctor(id);
	}
	@GetMapping("/setAvailability")
	public void setDoctorAvailability(@RequestParam Integer id) {
		doctorService.setDoctorAvailability(id);
	}
	@PostMapping("/loginDoctor")
	public Doctor checkDoctor(@RequestBody Doctor user) {
		
		return doctorService.checkDoctor(user);
	}
}
