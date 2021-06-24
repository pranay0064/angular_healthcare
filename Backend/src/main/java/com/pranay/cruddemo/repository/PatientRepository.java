package com.pranay.cruddemo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pranay.cruddemo.entity.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient,Integer>{
}
