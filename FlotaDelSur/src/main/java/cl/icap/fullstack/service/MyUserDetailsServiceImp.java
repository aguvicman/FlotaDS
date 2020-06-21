package cl.icap.fullstack.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import cl.icap.fullstack.model.dto.UsuariosDto;

public class MyUserDetailsServiceImp implements UserDetails {
	private String userName;
	private String password;
	private boolean enabled;
	private List<GrantedAuthority> authorities;
	
	
	//private UsersRepository usersRepository;

	public MyUserDetailsServiceImp(UsuariosDto usuariosDto) {
		this.userName = usuariosDto.getUsername();
		this.password = usuariosDto.getPassword();
		this.enabled = usuariosDto.isEnabled();
		this.authorities = Arrays.stream(usuariosDto.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.userName;
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
		return this.enabled;
	}



}