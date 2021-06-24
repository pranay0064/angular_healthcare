package com.pranay.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranay.cruddemo.entity.Doctor;
import com.pranay.cruddemo.repository.DoctorRepository;

@Service
public class DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;
	public List<Doctor> getDoctors(){
		return(List<Doctor>) doctorRepository.findAll();
		//return null;
	}
	public Doctor registerDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	public void deleteDoctor(Integer id) {
		doctorRepository.deleteById(id);
	}
	public Doctor updateDoctor(Doctor doctor) {
		Integer id=doctor.getDid();
		Doctor dnr=doctorRepository.findById(id).get();
		dnr.setDname(doctor.getDname());
		dnr.setEmailid(doctor.getEmailid());
		dnr.setPassword(doctor.getPassword());
		dnr.setAvailability(doctor.getAvailability());
		dnr.setSlot(doctor.getSlot());
		dnr.setSpecialization(doctor.getSpecialization());
		return doctorRepository.save(dnr);
		//return dnr;
	}
	public Doctor getOnlyDoctor(Integer id) {
		Doctor dnr=doctorRepository.findById(id).get();
		return dnr;
	}
	public void setDoctorAvailability(Integer id) {
		Doctor dnr=doctorRepository.findById(id).get();
		dnr.setAvailability(0);
		doctorRepository.save(dnr);
	}
	public Doctor checkDoctor(Doctor user) {
		List<Doctor> dnr = (List<Doctor>) doctorRepository.findAll();
		for (Doctor other : dnr) {
			//System.out.println(other.getEmail()+" "+user.getEmail() +" "+ other.getPassword()+" "+user.getPassword());
            if (other.getEmailid().equals(user.getEmailid()) && other.getPassword().equals(user.getPassword())) {
            	
                return other;
            }
        }
		return null;
	}
}
