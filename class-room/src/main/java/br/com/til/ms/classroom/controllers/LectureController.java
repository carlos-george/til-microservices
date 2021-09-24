package br.com.til.ms.classroom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
