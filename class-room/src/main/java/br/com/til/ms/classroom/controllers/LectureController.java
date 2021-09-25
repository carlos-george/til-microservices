package br.com.til.ms.classroom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.til.ms.classroom.adapter.dto.LectureDTO;
import br.com.til.ms.classroom.services.LectureService;

@RestController
@RequestMapping("/v1/admin/lectures")
public class LectureController {

	@Autowired
	private LectureService lectureService;
	
	@GetMapping("/{id}")
	public ResponseEntity<LectureDTO> findLectureById(@PathVariable Long id) {
		
		return ResponseEntity.ok(lectureService.findLectureById(id));
	}
	
	@PostMapping("/{id}/students/{studentId}")
	public ResponseEntity<String> subscribeOnLecture(@PathVariable Long id, @PathVariable Long studentId) {
		
		lectureService.subscribeOnLecture(id, studentId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("You was subscribed with successful!");
	}
}
