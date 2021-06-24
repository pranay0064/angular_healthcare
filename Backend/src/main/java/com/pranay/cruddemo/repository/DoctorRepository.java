package com.pranay.cruddemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pranay.cruddemo.entity.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Integer> {

}
