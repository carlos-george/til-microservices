package br.com.til.ms.course.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.til.ms.course.adapter.dto.SpeakerDTO;
import br.com.til.ms.course.adapter.dto.Worker;
import br.com.til.ms.course.entities.Speaker;
import br.com.til.ms.course.feignclient.WorkerFeignClientService;
import br.com.til.ms.course.repositories.SpeakerRepository;

@Service
public class SpeakerService {

	@Autowired
	private SpeakerRepository speakerRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private WorkerFeignClientService workerFeignService;
	
	
	public Page<Speaker> findAll(Pageable pageable) {
		
		return speakerRepository.findAll(pageable);
	}


	public SpeakerDTO findSpeakerByWorkerId(Long id) {
		
		Speaker speaker = speakerRepository.findSpeakerByWorkerId(id);
		
		SpeakerDTO dto = modelMapper.map(speaker, SpeakerDTO.class);
		
		Worker worker = workerFeignService.findById(id).getBody();
		
		dto.setName(worker.getName());
		
		return dto;
	}
}
