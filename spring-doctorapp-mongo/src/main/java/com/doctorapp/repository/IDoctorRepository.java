package com.doctorapp.repository;

import com.doctorapp.exceptions.DoctorNotFoundException;
import com.doctorapp.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDoctorRepository extends MongoRepository<Doctor,Integer> {

    // derived queries - derived from properties
    // readByPropertyName
    // findByPropertyName
    // getByPropertyName

    List<Doctor>  findBySpeciality(String special);
    List<Doctor>  findByHospitalName(String hospitalName);

    // custom query
    @Query("{fees:{$lte:?0}}")
    List<Doctor>  getByFee(double fees); // db.doctor.find("{fees:{$lte:1000}}")
    @Query("{experience:{$gte:?0}}")
    List<Doctor>  readByExp(int experience); // db.doctor.find("{experience:{$gte:10}}")

    //db.doctor.find("{speciality:'Cardio ',fees:{$lte:1000}}")
    // db.doctor.find("{$and:[{speciality:'Cardio '},{fees:{$lte:1000}}]}")
    @Query("{speciality:?0,fees:{$lte:?1}}")
    List<Doctor>  getBySpecialityFees(String speciality, double fees);

    @Query("{$and:[{hospitalName:?0},{speciality:?1}]}")
    List<Doctor>  findByHospitalAndSpeciality(String hospitalName, String speciality) ;

    @Query("{$or:[{experience:{$gte:?1}},{speciality:?0}]}")
    List<Doctor>  findBySpecialityOrExp(String speciality,int exp);

}
