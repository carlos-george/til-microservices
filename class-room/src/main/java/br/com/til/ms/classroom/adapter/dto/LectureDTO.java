package br.com.til.ms.classroom.adapter.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LectureDTO {
	
	private Long id;

	private String speakerName;
	
	private String course;
	
	private List<StudentDTO> students = new ArrayList<StudentDTO>();

	public LectureDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LectureDTO(Long id, String speakerName, String course, List<StudentDTO> students) {
		super();
		this.id = id;
		this.speakerName = speakerName;
		this.course = course;
		this.students = students;
	}

	public LectureDTO(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSpeakerName() {
		return speakerName;
	}

	public void setSpeakerName(String speakerName) {
		this.speakerName = speakerName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public List<StudentDTO> getStudents() {
		return students;
	}

	public void setStudents(List<StudentDTO> students) {
		this.students = students;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LectureDTO other = (LectureDTO) obj;
		return Objects.equals(id, other.id);
	} 
	
}
