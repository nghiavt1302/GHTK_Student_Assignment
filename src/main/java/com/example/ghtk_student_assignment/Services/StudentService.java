package com.example.ghtk_student_assignment.Services;

import com.example.ghtk_student_assignment.Entity.StudentEntity;
import com.example.ghtk_student_assignment.Model.Student;
import com.example.ghtk_student_assignment.Repository.StudentRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getListStudent(){
        List<Student> result = new ArrayList<>();
        List<StudentEntity> entities = studentRepository.findAll();
        if (entities != null && entities.size() > 0){
            entities.forEach(x->{
                Student item = new Student();
                item.setStt(x.getStt());
                item.setSchool(x.getSchool());
                item.setDist(x.getDist());
                item.setStd_id(x.getStd_id());
                item.setStd_class(x.getStd_class());
                item.setFullname(x.getFullname());
                item.setBorn_day(x.getBorn_day());
                item.setBorn_month(x.getBorn_month());
                item.setBorn_year(x.getBorn_year());
                item.setGender(x.getGender());
                item.setBorn_location(x.getBorn_location());
                item.setEthnic(x.getEthnic());
                item.setHousehold_address(x.getHousehold_address());
                item.setPhone(x.getPhone());
                item.setGrade_1(x.getGrade_1());
                item.setGrade_2(x.getGrade_2());
                item.setGrade_3(x.getGrade_3());
                item.setGrade_4(x.getGrade_4());
                item.setGrade_5(x.getGrade_5());
                item.setTotal_grade(x.getTotal_grade());
                item.setPri_point(x.getPri_point());
                item.setTotal_grade_addmission(x.getTotal_grade_addmission());
                item.setNotes(x.getNotes());
                result.add(item);
            });
        }
        return result;
    }

    private String getCellValue(Row row, int cellNo) {
        DataFormatter formatter = new DataFormatter();
        Cell cell = row.getCell(cellNo);
        return formatter.formatCellValue(cell);
    }

    public List<StudentEntity> importStudentFromExcel(MultipartFile files) throws IOException {
        List<Student> students = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(files.getInputStream());
        // Read student data form excel file sheet1.
        XSSFSheet worksheet = workbook.getSheetAt(0);
        for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
            if (index > 0) {
                XSSFRow row = worksheet.getRow(index);
                Student student = new Student();
                student.setStt(Integer.valueOf(getCellValue(row, 0)));
                student.setSchool(getCellValue(row, 1));
                student.setDist(getCellValue(row, 2));
                student.setStd_id(getCellValue(row, 3));
                student.setStd_class(getCellValue(row, 4));
                student.setFullname(getCellValue(row, 5));
                student.setBorn_day(Integer.valueOf(getCellValue(row, 6)));
                student.setBorn_month(Integer.valueOf(getCellValue(row, 7)));
                student.setBorn_year(Integer.valueOf(getCellValue(row, 8)));
                student.setGender(getCellValue(row, 9));
                student.setBorn_location(getCellValue(row, 10));
                student.setEthnic(getCellValue(row, 11));
                student.setHousehold_address(getCellValue(row, 12));
                student.setPhone(getCellValue(row, 13));
                student.setGrade_1(Integer.valueOf(getCellValue(row, 14)));
                student.setGrade_2(Integer.valueOf(getCellValue(row, 15)));
                student.setGrade_3(Integer.valueOf(getCellValue(row, 16)));
                student.setGrade_4(Integer.valueOf(getCellValue(row, 17)));
                student.setGrade_5(Integer.valueOf(getCellValue(row, 18)));
                student.setTotal_grade(Integer.valueOf(getCellValue(row, 19)));
                student.setPri_point(Integer.valueOf(getCellValue(row, 20)));
                student.setTotal_grade_addmission(Integer.valueOf(getCellValue(row, 21)));
                student.setNotes(getCellValue(row, 22));

                students.add(student);
            }
        }

        List<StudentEntity> entities = new ArrayList<>();
        if (students.size() > 0) {
            students.forEach(x->{
                StudentEntity item = new StudentEntity();
                item.setStt(x.getStt());
                item.setSchool(x.getSchool());
                item.setDist(x.getDist());
                item.setStd_id(x.getStd_id());
                item.setStd_class(x.getStd_class());
                item.setFullname(x.getFullname());
                item.setBorn_day(x.getBorn_day());
                item.setBorn_month(x.getBorn_month());
                item.setBorn_year(x.getBorn_year());
                item.setGender(x.getGender());
                item.setBorn_location(x.getBorn_location());
                item.setEthnic(x.getEthnic());
                item.setHousehold_address(x.getHousehold_address());
                item.setPhone(x.getPhone());
                item.setGrade_1(x.getGrade_1());
                item.setGrade_2(x.getGrade_2());
                item.setGrade_3(x.getGrade_3());
                item.setGrade_4(x.getGrade_4());
                item.setGrade_5(x.getGrade_5());
                item.setTotal_grade(x.getTotal_grade());
                item.setPri_point(x.getPri_point());
                item.setTotal_grade_addmission(x.getTotal_grade_addmission());
                item.setNotes(x.getNotes());
                entities.add(item);
            });
            studentRepository.saveAll(entities);
        }
        return entities;
    }
}
