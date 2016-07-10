package my.framework.hibernate.mapping.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class CodeUser {
	@GenericGenerator(name = "code_user", strategy = "increment")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "code_user")
	private int codeid;
	private String email;
	private String name;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy="codeUser")
	private CodeUserDetails codeUserDetails;

	@Override
	public String toString() {
		return "CodeUser [codeid=" + codeid + ", email=" + email + ", name=" + name + ", codeUserDetails="
				+ codeUserDetails + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CodeUserDetails getCodeUserDetails() {
		return codeUserDetails;
	}

	public void setCodeUserDetails(CodeUserDetails codeUserDetails) {
		this.codeUserDetails = codeUserDetails;
	}

	public int getCodeid() {
		return codeid;
	}

	public void setCodeid(int codeid) {
		this.codeid = codeid;
	}

}
