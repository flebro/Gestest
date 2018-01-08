package com.master.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.master.model.Administrateur;

public class AdministrateurUserDetails implements UserDetails {

	private final Administrateur administrateur;
	private List<GrantedAuthority> authorities;
	
	public AdministrateurUserDetails(Administrateur administrateur) {
		this.administrateur = administrateur;
		this.authorities = new ArrayList<>();
		this.authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return administrateur.getMotDePasse();
	}

	@Override
	public String getUsername() {
		return administrateur.getLogin();
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

}
