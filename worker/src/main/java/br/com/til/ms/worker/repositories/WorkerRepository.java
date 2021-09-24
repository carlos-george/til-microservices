package br.com.til.ms.worker.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.til.ms.worker.entities.Worker;

public interface WorkerRepository extends PagingAndSortingRepository<Worker, Long>{

}
