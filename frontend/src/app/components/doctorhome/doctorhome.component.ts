import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { DoctorserviceService } from 'src/app/services/doctorservice.service';
import { PatientService } from 'src/app/services/patient.service';
import { ShareService } from 'src/app/services/share.service';

@Component({
  selector: 'app-doctorhome',
  templateUrl: './doctorhome.component.html',
  styleUrls: ['./doctorhome.component.css']
})
export class DoctorhomeComponent implements OnInit {
  openForm:Boolean=false;
  constructor(private doctorService:DoctorserviceService,private s:ShareService,private patientService:PatientService) { }
  doctorid:any;
  patientDetails=null;
  patientid:any;
  ngOnInit(): void {
    //console.log(this.s.getdid());
    //this.doctorDetails=this.s.getdid();
    //this.getdpDetails();
    /*this.s.dvalue.subscribe(x=>{
      console.log(x);
      this.did=x
    }
      );
    this.s.pvalue.subscribe(y=>this.pid=y);
    console.log(this.did);*/
    //this.docbabid=localStorage.getItem('doctorid');
    //this.pid=localStorage.getItem('patientid');
    //this.d.dshare.subscribe(x=>this.docbabid=x);
    this.doctorid=this.doctorService.doctorDetails.did;
    console.log(this.doctorid);
    this.getPatientDetails();
  }

  getPatientDetails(){
    this.patientService.getPatientsbySlot(this.doctorid).subscribe(
      (resp)=>{
        console.log(resp);
        //var data=JSON.stringify(resp);
        //const obj=JSON.parse(data);
        //console.log(obj['slot1']);
        this.patientDetails=resp;
      },
      (err)=>{
        console.log(err);
      }
    );
  }
  Accept(patient){
    this.openForm=true;
    this.patientid=patient.pid;
  }
  savePrescription(prescriptionForm: NgForm){
    //let resource = JSON.stringify(prescriptionForm.value);
    //const myObj = JSON.parse(prescriptionForm.value);
    //console.log(myObj.prescription);
    this.patientService.updatePatientPres(this.patientid,prescriptionForm.value.prescription).subscribe(
      
      (resp)=>{
        console.log(resp);
        //this=resp;
        alert("Success");
      },
      (err)=>{
        console.log(err);
      }
    );

    prescriptionForm.reset();
  }
  getdpDetails(){
    console.log(this.s.did);
    this.doctorService.getDoctorById(this.s.did).subscribe(
      (resp)=>{
        console.log(resp);
        //this=resp;
      },
      (err)=>{
        console.log(err);
      }
    );
  }

}
