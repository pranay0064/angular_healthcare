import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';
import { DoctorserviceService } from 'src/app/services/doctorservice.service';
@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent implements OnInit {
  NgForm = NgForm;
  doctorDetails = null;
  doctorToUpdate = {
    did: '',
    dname: '',
    emailid: '',
    password:'',
    specialization: '',
    availability: '',
    slot: ''
  };
  constructor(private doctorService: DoctorserviceService) {}

  ngOnInit(): void {
    this.getDoctorDetails();
    //this.getUserDetails();
  }
  register(registerForm: NgForm) {
    this.doctorService.registerDoctor(registerForm.value).subscribe(
      resp => {
        console.log(resp);
        registerForm.reset();
        this.getDoctorDetails();
      },
      err => {
        console.log(err);
      }
    );
    console.log('reg');
  }

  getDoctorDetails() {
    this.doctorService.getDoctors().subscribe(
      resp => {
        console.log(resp);
        this.doctorDetails = resp;
      },
      err => {
        console.log(err);
      }
    );
    console.log('doctor');
  }
  deleteDoctor(doctor) {
    this.doctorService.deleteDoctor(doctor.did).subscribe(
      resp => {
        console.log(resp);
        this.getDoctorDetails();
      },
      err => {
        console.log(err);
      }
    );
    console.log('reg');
  }

  edit(doctor) {
    this.doctorToUpdate = doctor;
  }
  updateDoctorDetails(updateForm: NgForm) {
    console.log("here near update)");
    this.doctorService.updateDoctor(this.doctorToUpdate).subscribe(
      resp => {
        console.log(resp);

        this.getDoctorDetails();
        updateForm.reset();
      },
      err => {
        console.log(err);
      }
    );
    console.log('reg');
  }

}
