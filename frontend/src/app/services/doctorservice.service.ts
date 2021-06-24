import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DoctorserviceService {
  doctorDetails=null;
  constructor(private httpClient:HttpClient) { }
  api='http://localhost:8084';
  public getDoctors(){
    return this.httpClient.get(this.api+'/getDoctors');
  }
  public registerDoctor(doctorData) {
    return this.httpClient.post(this.api + '/registerDoctor', doctorData);
  }
  public deleteDoctor(did) {
    return this.httpClient.delete(this.api + '/deleteDoctor?id=' + did);
  }
  public updateDoctor(doctor) {
    return this.httpClient.put(this.api + '/updateDoctor', doctor);
  }
  public getDoctorById(did){
    return this.httpClient.get(this.api+'/findDoctorbyid?id='+did);
  }
  public setAvailabilityToZero(did){
    return this.httpClient.get(this.api+'/setAvailability?id='+did);
  }
  public checkDoctor(doctor){
    console.log(doctor);
    //console.log(this.httpClient.post(this.api+'/loginDoctor',doctor));
    return this.httpClient.post(this.api+'/loginDoctor',doctor);
  }
  
}
