package br.com.til.ms.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.til.ms.course.entities.Course;
import br.com.til.ms.course.repositories.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public Course findById(Long id) {
		
		return courseRepository.findById(id).get();
	}
}
