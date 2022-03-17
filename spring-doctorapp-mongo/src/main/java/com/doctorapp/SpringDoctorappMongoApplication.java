package com.doctorapp;

import com.doctorapp.model.Doctor;
import com.doctorapp.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDoctorappMongoApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(SpringDoctorappMongoApplication.class, args);
	}
	@Autowired
	private IDoctorService doctorService;
	@Override
	public void run(String... args) throws Exception {
		Doctor doctor = new Doctor("Aparna",3,"Gynaec ",10,800,"Sree Hospital");
//		doctorService.addDoctor(doctor);


//		Doctor doctor1 = doctorService.getById(1);
//		System.out.println("doctor1 = " + doctor1);
//
//		System.out.println("Update Doctor");
//		doctor1.setExperience(12);
//		doctorService.updateDoctor(doctor1);
//
//		System.out.println("Get all doctors");
//		doctorService.getAllDoctors().forEach(System.out::println);

		System.out.println("By Fees");
		doctorService.getByFees(1600).forEach(System.out::println);
		System.out.println("By Experience");
		doctorService.getByExperience(10).forEach(System.out::println);
		System.out.println("By Speciality");
		doctorService.getBySpeciality("Cardio ").forEach(System.out::println);
		System.out.println("By hospital name");
		doctorService.getByHospitalName("Sree Hospital").forEach(System.out::println);

		System.out.println("By Speciality or exp");
		doctorService.getBySpecialityOrExp("Cardio ",9).forEach(System.out::println);
		System.out.println("By Speciality and fees");
		doctorService.getBySpecialityAndFees("Cardio ",1900).forEach(System.out::println);
		System.out.println("By Speciality and hospital");
		doctorService.getByHospitalAndSpeciality("Sree Hospital","Neuro Surgeon").forEach(System.out::println);



	}
}
