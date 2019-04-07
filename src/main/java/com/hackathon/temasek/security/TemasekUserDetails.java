package com.hackathon.temasek.security;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.hackathon.temasek.model.User;


@SuppressWarnings("serial")
public class TemasekUserDetails implements UserDetails {
	private List<String> userRoles;
	private User user;
	public TemasekUserDetails(User user, List<String> userRoles) {
		this.user = user;
		this.userRoles = userRoles;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String roles = StringUtils.collectionToCommaDelimitedString(userRoles);
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	}
	@Override
	public String getUsername() {
			return user.getUserId();
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}
}

