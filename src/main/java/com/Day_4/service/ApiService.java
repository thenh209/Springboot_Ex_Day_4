package com.Day_4.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Day_4.model.Student;
import com.Day_4.repository.ApiRepository;


@Service
public class ApiService {
	@Autowired
	ApiRepository ar;
	
	public Student saveinfo(Student s)
	{
		return ar.save(s);
	}
	
	public List<Student> showinfo()
	{
		return ar.findAll();
	}
}
 