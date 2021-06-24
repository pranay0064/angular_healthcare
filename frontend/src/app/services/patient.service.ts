import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PatientService {
  patientDetails=null;
  constructor(private httpClient:HttpClient) { }
  api='http://localhost:8084';
  public getPatients(){
    return this.httpClient.get(this.api+'/getPatients');
  }
  public checkPatient(patient){
    console.log(patient);
    console.log(this.httpClient.post(this.api+'/loginPatient',patient));
    return this.httpClient.post(this.api+'/loginPatient',patient);
  }
  public setSlotADoctor(did,pid){
    return this.httpClient.get(this.api+'/setSlotADoctor?did='+did+'&pid='+pid);
  }
  public setSlotBDoctor(did,pid){
    return this.httpClient.get(this.api+'/setSlotBDoctor?did='+did+'&pid='+pid);
  }
  public getPatientsbySlot(did){
    return this.httpClient.get(this.api+'/getPatientsbySlot?did='+did);
  }
  public updatePatient(patient){
    return this.httpClient.put(this.api+'/updatePatient',patient);
  }
  
  public updatePatientPres(pid,pres){
    return this.httpClient.get(this.api+'/updatePrescription?pid='+pid+'&pres='+pres);
  }
  public registerPatient(patient){
    return this.httpClient.post(this.api+'/registerPatient',patient);
  }
}
