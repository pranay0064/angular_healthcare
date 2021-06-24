import { Component, OnInit } from '@angular/core';
import { DoctorserviceService } from 'src/app/services/doctorservice.service';
import { PatientService } from 'src/app/services/patient.service';
import { ShareService } from 'src/app/services/share.service';

@Component({
  selector: 'app-patienthome',
  templateUrl: './patienthome.component.html',
  styleUrls: ['./patienthome.component.css']
})
export class PatienthomeComponent implements OnInit {
  doctorDetails=null;
  //x:number;
  msg:any;
  docid:number;
  patientid:any;
  pres:any;
  constructor(private doctorService:DoctorserviceService,private patientService:PatientService,private s:ShareService) { }
  //slotA1:number=0;
  //slotA2:number=0;
  ngOnInit(): void {
    this.getDoctorsDetails();
    //this.s.dvalue.subscribe(msg=>this.x=msg); 
    this.patientid=this.patientService.patientDetails.pid;
    this.pres=this.patientService.patientDetails.prescription;
    //localStorage.setItem('patientid',this.patientid);
    //console.log(this.patientid);
  }
  getDoctorsDetails(){
    this.doctorService.getDoctors().subscribe(
      (resp)=>{
        console.log(resp);
        this.doctorDetails=resp;
      },
      (err)=>{
        console.log(err);
      }
    );
  }
  na(){
    alert("Doctor not available")
  }

  fetchAll(doctor){
    /*this.count++;
    console.log(doctor.did);
    this.d.updateDcon(doctor.did);
    localStorage.setItem('doctorid',doctor.did);
    //console.log(this.patientService.patientDetails.pname);
    //this.s.setdid(doctor.did);
    //this.s.setpid(this.patientService.patientDetails.pid);
    this.s.changeValue(doctor.did);
    this.s.changepValue(this.patientService.patientDetails.pid);
    //console.log(this.s.getdid());
    //console.log(this.s.getpid());
    //this.s.alldetails=doctor;
    //this.s.alldetails+=this.patientService.patientDetails;
    //console.log(this.s.alldetails)
    this.xyz();*/
    if(doctor.slot=='A1'){
      //this.slotA1++;
      this.patientService.setSlotADoctor(doctor.did,this.patientid).subscribe(
        (resp)=>{
          console.log(resp);
          this.msg="sucess";
          this.doctorService.setAvailabilityToZero(doctor.did).subscribe(
            (resp)=>{
              //console.log(resp);
              //this.doctorDetails=resp;
              this.getDoctorsDetails();
            },
            (err)=>{
              console.log(err);
            }
          );
        },
        (err)=>{
          console.log(err);
        }
      );
      
    }
    else if(doctor.slot=='A2'){
      //this.slotA2++;
      this.patientService.setSlotBDoctor(doctor.did,this.patientid).subscribe(
        (resp)=>{
          console.log(resp);
          this.msg="sucess";
          this.doctorService.setAvailabilityToZero(doctor.did).subscribe(
            (resp)=>{
              //console.log(resp);
              //this.doctorDetails=resp;
              this.getDoctorsDetails();
            },
            (err)=>{
              console.log(err);
            }
          );
        },
        (err)=>{
          console.log(err);
        }
      );
    }
    
  }
  /*xyz(){
    this.d.dshare.subscribe(x=>this.docid=x);
  }*/
}
