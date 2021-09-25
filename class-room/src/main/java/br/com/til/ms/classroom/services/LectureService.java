package br.com.til.ms.classroom.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
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
import br.com.til.ms.classroom.repositories.LectureStudentRepository;

@Service
public class LectureService {
	
	Logger logger = LoggerFactory.getLogger(LectureService.class);
	
	@Autowired
	private LectureRepository lectureRepository;
	
	@Autowired
	private LectureStudentRepository lectureStudentRepository;
	
	@Autowired
	private WorkerFeignService workerFeignService;
	
	@Autowired
	private CourseFeignClientService courseFeignService; 
	
	@Autowired
	private KafkaTemplate<String, String> sendMailTemplate;
	
	public LectureDTO findLectureById(Long id) {
		
		Lecture lecture = lectureRepository.findById(id).get();
		
		Worker speaker = workerFeignService.findById(lecture.getSpeakerId()).getBody();
		
		Course course = courseFeignService.findCourseById(lecture.getCourseId()).getBody();
		
		LectureDTO lectureDTO = new LectureDTO(lecture.getId());
		
		lectureDTO.setSpeakerName(speaker.getName());
		
		lectureDTO.setCourse(course.getTitle());
		
		List<StudentDTO> students = lecture.getStudents().stream().map(lectureStudent -> {
			Worker student = workerFeignService.findById(lectureStudent.getStudentId()).getBody();
			
			StudentDTO studentDTO = new StudentDTO(lectureStudent.getStudentId(), student.getName());
			
			return studentDTO;
		}).collect(Collectors.toList());
		
		lectureDTO.getStudents().addAll(students);
		
		return lectureDTO;
	}

	public void subscribeOnLecture(Long id, Long studentId) {
		
		Lecture lecture = lectureRepository.findById(id).get();
		
		LectureStudent lectureStudent = new LectureStudent(studentId, lecture);
		
		lectureStudentRepository.save(lectureStudent);
		
		logger.info("Subscribing student " + studentId);
		
		sendMailTemplate.send("topic.send.mail", studentId.toString());
		
	}

}
