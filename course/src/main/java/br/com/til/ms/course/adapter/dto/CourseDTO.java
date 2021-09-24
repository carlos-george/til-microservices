package br.com.til.ms.course.adapter.dto;

import java.io.Serializable;
import java.util.Objects;

public class CourseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;

	private String title;

	public CourseDTO() {
		super();
	}

	public CourseDTO(Long id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseDTO other = (CourseDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(title, other.title);
	}
	
}
