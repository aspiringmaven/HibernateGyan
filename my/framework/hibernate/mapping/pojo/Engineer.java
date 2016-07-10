package my.framework.hibernate.mapping.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="TechnicalResource")
public class Engineer {
	@GenericGenerator(name="engineer_generator", strategy="increment")
	@Id @GeneratedValue
	private int engineerId;
	private String name;
	private String designation;

	@ManyToMany(cascade=CascadeType.ALL , fetch=FetchType.EAGER)
	@JoinTable(name="Engineer_Skill_Junction" , joinColumns = {
			@JoinColumn(name="engineerID_FK", referencedColumnName="engineerId")			
	} , inverseJoinColumns = {
			@JoinColumn(name="skillId_FK" , referencedColumnName="skillId")
	})
	private List<Skill> skills;

	public int getEngineerId() {
		return engineerId;
	}

	public void setEngineerId(int engineerId) {
		this.engineerId = engineerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

}
