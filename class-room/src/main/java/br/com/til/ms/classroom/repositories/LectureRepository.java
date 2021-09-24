package br.com.til.ms.classroom.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.til.ms.classroom.entities.Lecture;

public interface LectureRepository extends PagingAndSortingRepository<Lecture, Long>{

}
