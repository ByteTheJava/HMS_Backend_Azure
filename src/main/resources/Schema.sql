create table app_age_master (
       age_id integer not null, 
	   age_value varchar(255), 
	   primary key (age_id));
	   
create table app_appointment_master (
       appointment_id integer not null, 
	   appointment_date date, 
	   appointment_status_id integer, 
	   appointment_time_from time, 
	   appointment_time_to time, 
	   appointment_type_id integer, 
	   department_id integer, 
	   doctor_id integer, 
	   patient_id integer, 
	   slots_id integer, 
	   primary key (appointment_id));
	   
create table app_appointment_status (
       appointment_status_id integer not null, 
	   appointment_status_value varchar(255), 
	   primary key (appointment_status_id));
	   
create table app_appointment_type (
       appointment_type_id integer not null, 
	   appointment_type_value varchar(255), 
	   primary key (appointment_type_id));
	   
create table app_call_status (
       call_status_id integer not null, 
	   call_status_value varchar(255), 
	   primary key (call_status_id));
	   
create table app_department_master (
	   department_id integer not null, 
	   department_name varchar(255), 
	   primary key (department_id));
	   
create table app_doctor_master (
       doctor_id integer not null, 
	   department_id integer, 
	   email_id varchar(255), 
	   first_name varchar(255), 
	   last_name varchar(255), 
	   mobile_number varchar(255), 
	   primary key (doctor_id));
	   
create table app_gender_master (
       gender_id integer not null, 
	   gender_value varchar(255), 
	   primary key (gender_id));
	   
create table app_patient_master (
       patient_id integer not null, 
	   age_id integer, 
	   appointment_type_id integer, 
	   email_id varchar(255), 
	   first_name varchar(255), 
	   gender_id integer, 
	   last_name varchar(255), 
	   mobile_number varchar(255), 
	   mr_id integer not null, 
	   primary key (patient_id));
	   
create table app_schedule_type_master (
       schedule_type_id integer not null, 
	   schedule_type_value varchar(255), 
	   primary key (schedule_type_id));
	   
create table app_slots_master (
       slots_id integer not null, 
	   slots_value varchar(255), 
	   primary key (slots_id));
