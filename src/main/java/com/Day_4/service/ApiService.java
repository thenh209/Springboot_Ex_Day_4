package com.Day_4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Day_4.model.Student;
import com.Day_4.repository.ApiRepository;


@Service
public class ApiService {
	@Autowired
	ApiRepository ar;
	
	public List<Student> saveinfo(List<Student> s)
	{
		return (List<Student>)ar.saveAll(s);
	}
	
	public List<Student> showinfo()
	{
		return ar.findAll();
	}
	
	public Student getEmployeeById(int id) {
		Optional<Student> employeeOptional = ar.findById(id);
        return employeeOptional.orElse(null);
	}
	
	public Student changeinfo(Student s)
	{
		return ar.saveAndFlush(s);
	}
	
	public String changeinfobyid(int id,Student s)
	{
		if(ar.existsById(id))
		{
			ar.saveAndFlush(s);
			return "Updated";
		}
		else
		{
			return "Enter Valid Id";
		}
	}
	
//	public void deleteinfo(Student s)
//	{
//		ar.delete(s);
//	}
	
	public String deleteid(int id)
	{
		if(ar.existsById(id))
		{
			ar.deleteById(id);
			return "Deleted";
		}
		else
		{
			return "Enter Valid Id";
		}
	}
}
 