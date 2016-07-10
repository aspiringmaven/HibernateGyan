package my.framework.hibernate.mapping.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class School {
	@Id @GeneratedValue
	private int schoolId;
	private String name;
	@OneToMany (
			targetEntity=Teacher.class, 
			mappedBy = "school",
			cascade = CascadeType.ALL , 
			fetch = FetchType.EAGER
			)
	private List<Teacher> teachers;	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

}
