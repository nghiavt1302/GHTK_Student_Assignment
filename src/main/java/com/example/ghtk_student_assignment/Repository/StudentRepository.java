package com.example.ghtk_student_assignment.Repository;

import com.example.ghtk_student_assignment.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {
    List<StudentEntity> findAll();
    List<StudentEntity> findAllByFullname(String fullname);
    List<StudentEntity> findAllByStudentId(String studentId);
    List<StudentEntity> findAllByStudentIdAndFullname(String studentId, String fullname);
}
