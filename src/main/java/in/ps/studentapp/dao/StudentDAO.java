package in.ps.studentapp.dao;

import java.util.ArrayList;

import in.ps.studentapp.dto.Student;

public interface StudentDAO {
	public boolean insertStudent(Student s);//create
	public boolean updateStudent(Student s);//update
	public boolean deleteStudent(int id);//delete
	public Student getStudent(String mail, String password);//retrieve
	public ArrayList<Student> getStudent();//retrieve
	public ArrayList<Student> getStudent(String name);
	public Student getStudent(long phone,String mail);
	
	
	
	
	
	
	
	
	
	
}
