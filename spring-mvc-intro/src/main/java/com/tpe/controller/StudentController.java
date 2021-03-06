package com.tpe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tpe.domain.Student;
import com.tpe.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    
    

    @GetMapping("/welcome")
    @ResponseBody
    public String welcome( ) {
        return "Welcome to Student Controller";
    }
    

    
    // LIST STUDENTS

    // @RequestMapping(value="/students", method = RequestMethod.GET)
    @GetMapping
    public ModelAndView getStudents() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("students",studentService.getAll());
        mav.setViewName("students");
        return mav;
    }
    
    
    // ADD NEW STUDENT ----------------
    
    @GetMapping("/new")
    public String newStudent(@ModelAttribute("student") Student student) {
    	return "newStudent";
    }
    
    @PostMapping("/new")
    public String createStudent(@ModelAttribute Student student ) {
    	studentService.createStudent(student);
    	return "redirect:/students";
    }
    
    
    // UPDATE STUDENT ------------------
    
    @GetMapping("/update/{id}")
    public String getStudent(@PathVariable Long id, ModelMap modelMap) {
    	Student student =studentService.findStudent(id);
    	modelMap.put("student", student);
    	return "updateStudent";
    }
    
    @PostMapping("/update/{id}")
    public String updateStudent(@ModelAttribute Student student ) {
    	studentService.updateStudent(student);
    	return "redirect:/students";
    }
    
    // DELETE STUDENT ----------
    
    @GetMapping("/delete/{id}")
    public String getStudentForDelete(@PathVariable Long id, ModelMap modelMap) {
    	Student student =studentService.findStudent(id);
    	modelMap.put("student", student);
    	return "deleteStudent";
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id ) {
    	studentService.deleteStudent(id);
    	return "redirect:/students";
    }

}



