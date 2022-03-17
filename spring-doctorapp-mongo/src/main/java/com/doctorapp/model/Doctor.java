package com.doctorapp.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document
//@Document(collection = "newdoctor")
public class Doctor {
    private String name;
    @Id
    private Integer doctorId;
    private String speciality;
    private int experience;
    private double fees;
    @Field(name = "hospital")
    private String hospitalName;


}
