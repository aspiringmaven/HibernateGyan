package my.framework.hibernate.mapping.pojo;

import java.util.List;

//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="TechnicalSkill")
public class Skill {
	@GenericGenerator(name="skill_generator" , strategy="increment")
	@Id @GeneratedValue(strategy=GenerationType.AUTO, generator="skill_generator")
	private int skillId;
	private String skillName;
	
	private List<Engineer> engineers;
	
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public List<Engineer> getEngineers() {
		return engineers;
	}
	public void setEngineers(List<Engineer> engineers) {
		this.engineers = engineers;
	}
	

}
