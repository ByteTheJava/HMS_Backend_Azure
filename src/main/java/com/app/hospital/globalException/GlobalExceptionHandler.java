package com.app.hospital.globalException;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.app.hospital.age.exception.AgeNotFoundException;
import com.app.hospital.appointment.exception.AppointmentNotFoundException;
import com.app.hospital.appointmentStatus.exception.AppointmentStatusNotFoundException;
import com.app.hospital.appointmentType.exception.AppointmentTypeNotFoundException;
import com.app.hospital.call.exception.CallStatusNotFoundException;
import com.app.hospital.department.exception.DepartmentNotFoundException;
import com.app.hospital.doctor.exception.DoctorNotFoundException;
import com.app.hospital.gender.exception.GenderNotFoundException;
import com.app.hospital.patient.exception.PatientNotFoundException;
import com.app.hospital.schedule.exception.ScheduleNotFoundException;
import com.app.hospital.slots.exception.SlotsNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(AgeNotFoundException.class)
    public ResponseEntity<?> ageNotFoundException(AgeNotFoundException ex, WebRequest request) 
	{
         ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(AppointmentNotFoundException.class)
    public ResponseEntity<?> appointmentNotFoundException(AppointmentNotFoundException ex, WebRequest request) 
	{
         ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(AppointmentStatusNotFoundException.class)
    public ResponseEntity<?> appointmentStatusNotFoundException(AppointmentStatusNotFoundException ex, WebRequest request) 
	{
         ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(AppointmentTypeNotFoundException.class)
    public ResponseEntity<?> appointmentTypeNotFoundException(AppointmentTypeNotFoundException ex, WebRequest request) 
	{
         ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(CallStatusNotFoundException.class)
    public ResponseEntity<?> callStatusIdNotFoundException(CallStatusNotFoundException ex, WebRequest request) 
	{
         ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<?> departmentNotFoundException(DepartmentNotFoundException ex, WebRequest request) 
	{
         ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<?> doctorNotFoundException(DoctorNotFoundException ex, WebRequest request) 
	{
         ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(GenderNotFoundException.class)
    public ResponseEntity<?> genderNotFoundException(GenderNotFoundException ex, WebRequest request) 
	{
         ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<?> patientNotFoundException(PatientNotFoundException ex, WebRequest request) 
	{
         ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(ScheduleNotFoundException.class)
    public ResponseEntity<?> scheduleNotFoundException(ScheduleNotFoundException ex, WebRequest request) 
	{
         ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(SlotsNotFoundException.class)
    public ResponseEntity<?> slotsNotFoundException(SlotsNotFoundException ex, WebRequest request) 
	{
         ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) 
    {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
