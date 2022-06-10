package com.example.ghtk_student_assignment.Controller;

import com.example.ghtk_student_assignment.Entity.Request.StudentSearchRequest;
import com.example.ghtk_student_assignment.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;


@Controller
public class StudentControllerUI {
    @Autowired
    StudentService studentService;

    @GetMapping("/import")
    public String home() {
        return "import";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) throws IOException {
        // check if file is empty
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/import";
        }
        //import to db
        studentService.importStudentFromExcel(file);
        // normalize the file path
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        // return success response
        attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');
        return "redirect:/import";
    }

    @GetMapping("/search")
    public String searchForm(Model model) {
        StudentSearchRequest request = new StudentSearchRequest();
        model.addAttribute("request", request);
        return "search";
    }

    @PostMapping("/search")
    public String searchSubmit(@ModelAttribute StudentSearchRequest request, Model model){
        model.addAttribute("request", request);
        model.addAttribute("list",studentService.searchStudent(request));
        return "result";
    }
}
