package br.com.til.ms.classroom.feign.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.til.ms.classroom.adapter.dto.Course;

@FeignClient(name = "til-course", path = "/v1/admin/courses")
public interface CourseFeignClientService {

	@GetMapping("/{id}")
	ResponseEntity<Course> findCourseById(@PathVariable Long id);
}
