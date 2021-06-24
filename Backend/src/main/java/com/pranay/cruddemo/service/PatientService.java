package com.pranay.cruddemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranay.cruddemo.entity.Patient;
import com.pranay.cruddemo.repository.PatientRepository;

@Service
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;
	public List<Patient> getPatients(){
		return(List<Patient>) patientRepository.findAll();
		//return null;
	}
	public Patient checkPatient(Patient user) {
		List<Patient> u = (List<Patient>) patientRepository.findAll();
		for (Patient other : u) {
			//System.out.println(other.getEmail()+" "+user.getEmail() +" "+ other.getPassword()+" "+user.getPassword());
            if (other.getEmailid().equals(user.getEmailid()) && other.getPassword().equals(user.getPassword())) {
            	
                return other;
            }
        }
		return null;
	}
	public Patient setSlotADoctor(Integer did,Integer pid) {
		/*List<Patient> u = (List<Patient>) patientRepository.findAll();
		for (Patient other : u) {
			//System.out.println(other.getEmail()+" "+user.getEmail() +" "+ other.getPassword()+" "+user.getPassword());
            if (other.getPid()==pid) {
            	System.out.print(other.getPid());
            	other.setSlot1(did);
            	return "success";
            }
        }*/
		Optional<Patient> optional=patientRepository.findById(pid);
		if(optional.isPresent()) {
			Patient p= optional.get();
			p.setSlot1(did);
			patientRepository.save(p);
			return p;
		}
		return null;
	}
	public Patient setSlotBDoctor(Integer did,Integer pid) {
		/*List<Patient> u = (List<Patient>) patientRepository.findAll();
		for (Patient other : u) {
			//System.out.println(other.getEmail()+" "+user.getEmail() +" "+ other.getPassword()+" "+user.getPassword());
            if (other.getPid()==pid) {
            	System.out.print(other.getPid());
            	other.setSlot1(did);
            	return "success";
            }
        }*/
		Optional<Patient> optional=patientRepository.findById(pid);
		if(optional.isPresent()) {
			Patient p= optional.get();
			p.setSlot2(did);
			patientRepository.save(p);
			return p;
		}
		return null;
	}
	public List<Patient> getPatientsbySlot(Integer did){
		List<Patient> u = (List<Patient>) patientRepository.findAll();
		List<Patient> patients=new ArrayList<Patient>();
		for (Patient other : u) {
			//System.out.println(other.getEmail()+" "+user.getEmail() +" "+ other.getPassword()+" "+user.getPassword());
            if (other.getSlot1()==did || other.getSlot2()==did) {
            	
                patients.add(other);
            }
        }
		//return(List<Patient>) patientRepository.findAll();
		return patients;
	} 
	public Patient updatePatient(Patient patient) {
		Integer id=patient.getPid();
		Patient ptn=patientRepository.findById(id).get();
		ptn.setAge(patient.getAge());
		ptn.setEmailid(patient.getEmailid());
		ptn.setPassword(patient.getPassword());
		ptn.setPname(patient.getPname());
		ptn.setPrescription(patient.getPrescription());
		ptn.setSlot1(patient.getSlot1());
		ptn.setSlot2(patient.getSlot2());
		ptn.setSymptoms(patient.getSymptoms());
		return patientRepository.save(ptn);
	}
	public Patient updatePatientPrescription(int pid,String pres) {
		Optional<Patient> optional=patientRepository.findById(pid);
		if(optional.isPresent()) {
			Patient p= optional.get();
			p.setPrescription(pres);
			patientRepository.save(p);
			return p;
		}
		return null;
	}
	public Patient registerPatient(Patient patient) {
		return patientRepository.save(patient);
	}
}
