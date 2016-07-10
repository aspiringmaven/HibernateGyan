package my.framework.hibernate.beans;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class FBUser {
	@Id @GeneratedValue
	private int id;
	private String email;
	@OneToMany (
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL
			)
	private Set<FBUser> friendList;
	
	public FBUser() {
		
	}
	
	public FBUser(String email) {
		this.email = email;
		this.friendList = new LinkedHashSet<FBUser>();
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<FBUser> getFriendList() {
		return friendList;
	}
	public void setFriendList(Set<FBUser> friendList) {
		this.friendList = friendList;
	}
	
	@Override
	public boolean equals(Object fbUser) {		
		return this.email.equals(((FBUser)fbUser).email);
	}
	
	@Override
	public int hashCode() {		
		return this.email.length();
	}
}