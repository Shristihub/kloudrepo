package com.doctorapp.service;

import com.doctorapp.exceptions.DoctorNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.repository.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorServiceImpl implements IDoctorService{

    private IDoctorRepository doctorRepository;

    @Autowired
    public void setDoctorRepository(IDoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctorRepository.insert(doctor);
    }
    @Override
    public void updateDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }
    @Override
    public void deleteDoctor(int doctorId) {
        doctorRepository.deleteById(doctorId);
    }
    @Override
    public Doctor getById(int doctorId) {
        return doctorRepository
                .findById(doctorId)
                .orElseThrow(()->new DoctorNotFoundException("Invalid Id"));
    }
    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public List<Doctor> getByFees(double fees) {
        List<Doctor> doctors = doctorRepository.getByFee(fees);
        if(doctors.isEmpty())
            throw new DoctorNotFoundException("doctors with lesser fees not available");
        return doctors;
    }

    @Override
    public List<Doctor> getBySpeciality(String speciality) {
        List<Doctor> doctors = doctorRepository.findBySpeciality(speciality);
        if(doctors.isEmpty())
            throw new DoctorNotFoundException("doctors with this speciality not available");
        return doctors;
    }

    @Override
    public List<Doctor> getByExperience(int experience) {
        List<Doctor> doctors = doctorRepository.readByExp(experience);
        if(doctors.isEmpty())
            throw new DoctorNotFoundException("doctors with this experience not available");
        return doctors;
    }

    @Override
    public List<Doctor> getByHospitalName(String hospitalName) {
        List<Doctor> doctors = doctorRepository.findByHospitalName(hospitalName);
        if(doctors.isEmpty())
            throw new DoctorNotFoundException("doctors not available at this time");
        return doctors;
    }

    @Override
    public List<Doctor> getByHospitalAndSpeciality(String hospitalName, String speciality) {
        List<Doctor> doctors = doctorRepository.findByHospitalAndSpeciality(hospitalName,speciality);
        if(doctors.isEmpty())
            throw new DoctorNotFoundException("doctor with this speciality not available in this hospital");
        return doctors;
    }

    @Override
    public List<Doctor> getBySpecialityAndFees(String speciality, double fees) {
        List<Doctor> doctors = doctorRepository.getBySpecialityFees(speciality, fees);
        if(doctors.isEmpty())
            throw new DoctorNotFoundException("doctor with this speciality not available");
        return doctors;
    }

    @Override
    public List<Doctor> getBySpecialityOrExp(String speciality, int exp) {
        List<Doctor> doctors = doctorRepository.findBySpecialityOrExp(speciality, exp);
        if(doctors.isEmpty())
            throw new DoctorNotFoundException("doctor with this speciality and exp not available");
        return doctors;
    }
}
