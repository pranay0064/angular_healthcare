package com.pranay.cruddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pranay.cruddemo.entity.Patient;
import com.pranay.cruddemo.service.PatientService;

@RestController
@CrossOrigin(allowedHeaders="*",origins="*")
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/getPatients")
	public List<Patient> getPatients(){
		return patientService.getPatients();
		
	}
	@PostMapping("/loginPatient")
	public Patient checkPatient(@RequestBody Patient user) {
		
		return patientService.checkPatient(user);
	}
	@GetMapping("/setSlotADoctor")
	public Patient setSlotADoctor(@RequestParam Integer did,@RequestParam Integer pid) {
		return patientService.setSlotADoctor(did,pid);
	}
	@GetMapping("/setSlotBDoctor")
	public Patient setSlotBDoctor(@RequestParam Integer did,@RequestParam Integer pid) {
		return patientService.setSlotBDoctor(did,pid);
	}
	@GetMapping("/getPatientsbySlot")
	public List<Patient> getPatientsbySlot(@RequestParam Integer did){
		return patientService.getPatientsbySlot(did);
		
	}
	@PutMapping("/updatePatient")
	public Patient updatePatient(@RequestBody Patient patient) {
		return patientService.updatePatient(patient);
	}
	@GetMapping("/updatePrescription")
	public Patient updatePatientPrescription(@RequestParam Integer pid,@RequestParam String pres) {
		return patientService.updatePatientPrescription(pid,pres);
	}
	@PostMapping("/registerPatient")
	public Patient registerPatient(@RequestBody Patient patient) {
		patient.setSlot1(0);
		patient.setSlot2(0);
		patient.setPrescription(null);
		return patientService.registerPatient(patient);
	}
}
