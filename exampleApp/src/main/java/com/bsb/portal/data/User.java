package com.bsb.portal.data;

import java.util.List;
import java.util.Objects;

public class User {

	private String email;

	private String password;

	private List<Role> roles;

	public User(User user) {
		this(user.getEmail(), user.getPassword(), user.getRoles());
	}

	public User(String email, String password, List<Role> roles) {
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		User user = (User) o;
		return email.equals(user.email) && password.equals(user.password) && roles.equals(user.roles);
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, password, roles);
	}
}
