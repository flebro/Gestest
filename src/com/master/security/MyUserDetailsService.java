package com.master.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.master.dao.IAdministrateurDao;
import com.master.model.Administrateur;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IAdministrateurDao administrateurDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Administrateur admin = administrateurDao.findByLogin(username);
		if (admin == null) {
			throw new UsernameNotFoundException(username);
		}
		return new AdministrateurUserDetails(admin);
	}

}
