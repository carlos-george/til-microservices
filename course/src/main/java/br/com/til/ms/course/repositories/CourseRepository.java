package br.com.til.ms.course.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.til.ms.course.entities.Course;

public interface CourseRepository extends PagingAndSortingRepository< Course, Long> {

}
