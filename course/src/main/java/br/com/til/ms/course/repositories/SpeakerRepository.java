package br.com.til.ms.course.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.til.ms.course.entities.Speaker;

@Repository
public interface SpeakerRepository extends PagingAndSortingRepository<Speaker, Long>{
	
	Speaker findSpeakerByWorkerId(Long workerId);

}
