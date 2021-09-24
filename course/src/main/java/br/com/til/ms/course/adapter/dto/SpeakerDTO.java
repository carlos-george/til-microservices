package br.com.til.ms.course.adapter.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SpeakerDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private Set<CourseDTO> courses = new HashSet<CourseDTO>();
	

	public SpeakerDTO() {
		super();
	}

	public SpeakerDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<CourseDTO> getCourses() {
		return courses;
	}

	public void setCourses(Set<CourseDTO> courses) {
		this.courses = courses;
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
		SpeakerDTO other = (SpeakerDTO) obj;
		return Objects.equals(id, other.id);
	}


}
