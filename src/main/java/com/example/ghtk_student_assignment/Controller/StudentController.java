package com.example.ghtk_student_assignment.Controller;

import com.example.ghtk_student_assignment.Entity.Request.StudentSearchRequest;
import com.example.ghtk_student_assignment.Entity.StudentEntity;
import com.example.ghtk_student_assignment.Model.Student;
import com.example.ghtk_student_assignment.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/home")
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/get-all-student")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @PostMapping("/import-excel")
    public List<StudentEntity> importExcelFile(@RequestParam("file") MultipartFile files)throws IOException {
        return studentService.importStudentFromExcel(files);
    }

    @PostMapping("/search-student")
    public List<StudentEntity> searchStudent(@RequestBody StudentSearchRequest request){
        return studentService.searchStudent(request);
    }
}
