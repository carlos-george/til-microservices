package br.com.til.ms.classroom.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.til.ms.classroom.entities.LectureStudent;

public interface LectureStudentRepository extends PagingAndSortingRepository<LectureStudent, Long> {

}
