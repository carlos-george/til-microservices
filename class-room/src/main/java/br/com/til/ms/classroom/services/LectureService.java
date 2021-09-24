package br.com.til.ms.classroom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.til.ms.classroom.adapter.dto.Course;
import br.com.til.ms.classroom.adapter.dto.LectureDTO;
import br.com.til.ms.classroom.adapter.dto.StudentDTO;
import br.com.til.ms.classroom.adapter.dto.Worker;
import br.com.til.ms.classroom.entities.Lecture;
import br.com.til.ms.classroom.entities.LectureStudent;
import br.com.til.ms.classroom.feign.services.CourseFeignClientService;
import br.com.til.ms.classroom.feign.services.WorkerFeignService;
import br.com.til.ms.classroom.repositories.LectureRepository;

@Service
public class LectureService {
	
	@Autowired
	private LectureRepository lectureRepository;
	
	@Autowired
	private WorkerFeignService workerFeignService;
	
	@Autowired
	private CourseFeignClientService courseFeignService; 
	
	public LectureDTO findLectureById(Long id) {
		
		Lecture lecture = lectureRepository.findById(id).get();
		
		Worker speaker = workerFeignService.findById(lecture.getSpeakerId()).getBody();
		
		Course course = courseFeignService.findCourseById(lecture.getCourseId()).getBody();
		
		LectureDTO lectureDTO = new LectureDTO(lecture.getId());
		
		lectureDTO.setSpeakerName(speaker.getName());
		
		lectureDTO.setCourse(course.getTitle());
		
		for (LectureStudent lectureStudent : lecture.getStudents()) {
			
			Worker student = workerFeignService.findById(lectureStudent.getStudentId()).getBody();
			
			StudentDTO studentDTO = new StudentDTO(lectureStudent.getStudentId(), student.getName());
			
			lectureDTO.getStudents().add(studentDTO);
			
		}
		
		
		return lectureDTO;
	}

}
