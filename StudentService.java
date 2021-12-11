package com.student;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface StudentService{

	public List<Student> getAll();
	public void deleteById(int theId);
	public List<Student> searchBy(String sName);
	public Student findById(int theId);
	public void save(Student theStudent);

}
