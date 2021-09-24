package br.com.til.ms.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.til.ms.course.adapter.dto.SpeakerDTO;
import br.com.til.ms.course.entities.Speaker;
import br.com.til.ms.course.services.SpeakerService;

@RestController
@RequestMapping("/v1/admin/speakers")
public class SpeakerController {

	@Autowired
	private SpeakerService speakerService;
	
	@GetMapping
	public ResponseEntity<Page<Speaker>> findAll(Pageable pageable) {
		
		return ResponseEntity.ok(speakerService.findAll(pageable));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SpeakerDTO> findAllCoursesBySpeaker(@PathVariable Long id) {
		
		return ResponseEntity.ok(speakerService.findSpeakerByWorkerId(id));
	}
	
}
