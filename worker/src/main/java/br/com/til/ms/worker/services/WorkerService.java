package br.com.til.ms.worker.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.til.ms.worker.entities.Worker;
import br.com.til.ms.worker.repositories.WorkerRepository;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository workerRepository;
	
	public Page<Worker> findAll(Pageable pageable) {
		
		return workerRepository.findAll(pageable);
	}
	
	public Worker findById(Long id) {
		Optional<Worker> workerOpt = workerRepository.findById(id);
		
		if(workerOpt.isEmpty()) {
			throw new IllegalArgumentException("Worker not found.");
		}
		
		return workerOpt.get();
	}
	
}
