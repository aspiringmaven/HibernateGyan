package my.framework.hibernate.mapping.pojo;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToOne;
//import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class CodeUserDetails {
	@GenericGenerator(name = "code_user_details", strategy = "increment")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int detailId;
	private String company;
	private String designation;
	private String project;
	// Two possible way
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@PrimaryKeyJoinColumn
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "codeId_FK", referencedColumnName = "codeId", unique = true)
	private CodeUser codeUser;

	@Override
	public String toString() {
		return "CodeUserDetails [detailId=" + detailId + ", company=" + company + ", designation=" + designation
				+ ", project=" + project + "]";
	}

	public CodeUser getCodeUser() {
		return codeUser;
	}

	public void setCodeUser(CodeUser codeUser) {
		this.codeUser = codeUser;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}
}