package my.framework.hibernate.mapping.pojo;

import java.util.Set;

//import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Department {
	@GenericGenerator(name="dept_generator", strategy="increment")
	@Id @GeneratedValue(generator="dept_generator" , strategy = GenerationType.AUTO)
	private int deptId;
	private String name;
	private String location;
	@OneToMany(mappedBy="dept")
//	@JoinColumn(name="deptId_fk", referencedColumnName="deptId")
	private Set<Employee> employees;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the employees
	 */
	public Set<Employee> getEmployees() {
		return employees;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

//	public Set<Employee> getEmploees() {
//		return emploees;
//	}
//
//	public void setEmploees(Set<Employee> emploees) {
//		this.emploees = emploees;
//	}
}
