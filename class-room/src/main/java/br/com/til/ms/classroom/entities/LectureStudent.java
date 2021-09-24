package br.com.til.ms.classroom.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_LECTURE_STUDENT")
public class LectureStudent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long studentId;
	
	@ManyToOne
	@JoinColumn(name="lecture_id", nullable=false)
	private Lecture lecture;

	public LectureStudent() {
		super();
	}

	public LectureStudent(Long id, Long studentId) {
		super();
		this.id = id;
		this.studentId = studentId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
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
		LectureStudent other = (LectureStudent) obj;
		return Objects.equals(id, other.id);
	}
	
}
