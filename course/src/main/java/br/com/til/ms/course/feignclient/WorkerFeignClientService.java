package br.com.til.ms.course.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.til.ms.course.adapter.dto.Worker;


@FeignClient(name = "til-worker", path = "/v1/admin/workers")
public interface WorkerFeignClientService {

	@GetMapping(path = "/{id}")
	ResponseEntity<Worker> findById(@RequestParam Long id);
}
