package br.com.til.ms.worker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.til.ms.worker.entities.Worker;
import br.com.til.ms.worker.services.WorkerService;

@RestController
@RequestMapping("/v1/admin/workers")
public class WorkerController {
	
	@Autowired
	private WorkerService workerService;

	@GetMapping
	public ResponseEntity<Page<Worker>> findAll(Pageable pageable) {
		
		return ResponseEntity.ok(workerService.findAll(pageable));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Worker> findById(@RequestParam Long id) {
		
		return ResponseEntity.ok(workerService.findById(id));
	}
	
	
}
