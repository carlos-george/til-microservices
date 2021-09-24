package br.com.til.ms.classroom.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_LECTURE")
public class Lecture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long speakerId;
	
	private Long courseId;
	
	@OneToMany(mappedBy = "lecture")
	private Set<LectureStudent> lectureStudents = new HashSet<LectureStudent>();

	public Lecture() {
		super();
	}

	public Lecture(Long id, Long speakerId, Long courseId, Set<LectureStudent> lectureStudents) {
		super();
		this.id = id;
		this.speakerId = speakerId;
		this.courseId = courseId;
		this.lectureStudents = lectureStudents;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSpeakerId() {
		return speakerId;
	}

	public void setSpeakerId(Long speakerId) {
		this.speakerId = speakerId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Set<LectureStudent> getStudents() {
		return lectureStudents;
	}

	public void setStudents(Set<LectureStudent> students) {
		this.lectureStudents = students;
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
		Lecture other = (Lecture) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
