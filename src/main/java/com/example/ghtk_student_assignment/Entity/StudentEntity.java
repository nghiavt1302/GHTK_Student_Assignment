package com.example.ghtk_student_assignment.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter @Setter
@Entity
@Table(name = "student")
public class StudentEntity {
    private Integer stt;
    private String school;
    private String dist;
    @Id
    private String std_id;
    @Column(name = "class")
    private String std_class;
    private String fullname;
    private Integer born_day;
    private Integer born_month;
    private Integer born_year;
    private String gender;
    private String born_location;
    private String ethnic;
    private String household_address;
    private String phone;
    private Integer grade_1;
    private Integer grade_2;
    private Integer grade_3;
    private Integer grade_4;
    private Integer grade_5;
    private Integer total_grade;
    private Integer pri_point;
    private Integer total_grade_addmission;
    private String notes;

}
