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
    @Column(name = "std_id")
    private String studentId;
    @Column(name = "class")
    private String studentClass;
    private String fullname;
    @Column(name = "born_day")
    private Integer bornDay;
    @Column(name = "born_month")
    private Integer bornMonth;
    @Column(name = "born_year")
    private Integer bornYear;
    private String gender;
    @Column(name = "born_location")
    private String bornLocation;
    private String ethnic;
    @Column(name = "household_address")
    private String householdAddress;
    private String phone;
    @Column(name = "grade_1")
    private Integer grade1;
    @Column(name = "grade_2")
    private Integer grade2;
    @Column(name = "grade_3")
    private Integer grade3;
    @Column(name = "grade_4")
    private Integer grade4;
    @Column(name = "grade_5")
    private Integer grade5;
    @Column(name = "total_grade")
    private Integer totalGrade;
    @Column(name = "pri_point")
    private Integer priPoint;
    @Column(name = "total_grade_addmission")
    private Integer totalGradeAddmission;
    private String notes;

}
