package br.com.til.ms.classroom.feign.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.til.ms.classroom.adapter.dto.Worker;

@FeignClient(name = "til-worker", path = "/v1/admin/workers")
public interface WorkerFeignService {

	@GetMapping(path = "/{id}")
	ResponseEntity<Worker> findById(@RequestParam Long id);
}
