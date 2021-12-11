package com.student;

import org.springframework.stereotype.Controller;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	/*@RequestMapping("/")
	public String getAll() {
		return "index";
	}*/
	
	
	@GetMapping("/")
	public String studentsList(Map<String, List<Student>> map)
	{
		List<Student> students = this.studentService.getAll();
		map.put("students", students);
		return "index";
	}
	
	@GetMapping("/search")
	public String searchBook(@RequestParam(required = false) String sName,
			Map<String, List<Student>> map)
	{
		List<Student> students = this.studentService.searchBy(sName);
		map.put("students", students);
		return "index";
	}
	

	@GetMapping("/delete")
	public  String deleteStudentForm(@RequestParam int id)
	{
		studentService.deleteById(id);
		return "redirect:/";
	}
	
	

	
	
	@GetMapping("/add")
	public String addBook(Model theModel) {

		// create model attribute to bind form data
		Student theStudent = new Student();

		theModel.addAttribute("student", theStudent);
	
		return "registrationForm";
	}
	
	

	@PostMapping("/save")
	public String addOrUpdateBook(Student student)
	{
		System.out.println("saving "+student);
		this.studentService.save(student);
		return "redirect:/";
	}
}		
