package com.student;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;    
import java.sql.SQLException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper; 

@Component
public class StudentServiceImpl implements StudentService{


	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Student> getAll() {
		//System.out.println(this.sessionFactory);
		Session session = this.sessionFactory.openSession();
		List<Student> list1 = session.createQuery("from Student").list();
		session.close();
		return list1;
	}
	
	@Override
	public List<Student> searchBy(String sName) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String query="";
		if(sName.length()!=0) {
			query ="from Student where studentName like '%"+sName+"%'";
		}
			
		else {
			System.out.println("Cannot search without input data");
			
		}
			
		System.out.println(query);
		
		tx.commit();
		session.clear();
		List<Student> students = session.createQuery(query).list();
		System.out.println(students);
		return students;
	}
	
	@Override
	public void save(Student theStudent) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(theStudent);
		tx.commit();
		session.close();

	}
		
	/*public int update(Student p){    
	    String sql="update Student set studentName="+p.getStudentName()+" , department= "+p.getDepartment()+" , country ="+p.getCountry()+" where studentId= "+p.getStudentId()+"" ;    
	    
	    return template.update(sql);    
	}*/
	
	@Override
	public Student findById(int theId) {
		Session session = this.sessionFactory.openSession();
		Student student = session.get(Student.class, theId);
		session.close();
		return student;
	}

	@Override
	public void deleteById(int theId) {
		Session session = this.sessionFactory.openSession();

		Student student = findById(theId);
		if(student!=null)
		{
			Transaction tx = session.beginTransaction();
			session.delete(student);
			tx.commit();
		}
		session.close();

	}
}