# Health Care Management System

The Health care management system is an online application to store all the health information.

Users of the System:

1. Admin

2. Doctors

3. Patients

Functional Requirements:

• Patients should be able to check doctor availability and book the appointment.

. The doctor should be able to accept or reject the appointment.

• The Doctor's prescription storage and viewable to the respective patient.

• The patient can get their reports based on booking.

• Admin should manage the Doctors.

• Maximum 1 Patient can book an appointment per slot.

#Technologies used
1. Angular,
2. Springboot,
3. mysql

## Installation and working mechanism

Mysql is required to create schema and tables all the code for mysql is provided in starterfile.sql so execute the starterfile and then,

You need eclipse or intellij or vs code to able to execute the springboot project which uses maeven change the required properties like db name,port-number in application.poperties to work on your pc and then,

you need to execute angular project a.k.a frontend by adding into vs code and downloading the dependencies by npm install command and run the project by ng serve command



### Screenshots are attached 


Note_1:- currently according to my mysql code iam not inserting any patient so use sign up form to register patient or write query through mysql and insert data

Note_2:- Please change the api url accordingly from springboot executing port or in other way where api url is being changes so update in the services in angular to work in other case it will not call the working api so all the data will not be available using portal

