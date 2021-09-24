package br.com.til.ms.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.til.ms.course.entities.Course;
import br.com.til.ms.course.services.CourseService;

@RestController
@RequestMapping("/v1/admin/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Course> findCourseById(@PathVariable Long id) {
		
		return ResponseEntity.ok(courseService.findById(id));
	}
}
