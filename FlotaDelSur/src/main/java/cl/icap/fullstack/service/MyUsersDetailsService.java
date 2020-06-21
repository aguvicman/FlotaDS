package cl.icap.fullstack.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.icap.fullstack.model.dto.UsuariosDto;
import cl.icap.fullstack.model.repository.UsuariosRepository;


@Service
public class MyUsersDetailsService implements UserDetailsService {
	
	@Autowired
	UsuariosRepository usuariosRepository;

	@Override
	public MyUserDetailsServiceImp loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<UsuariosDto> usuariosDto = usuariosRepository.findByUserName(userName.toUpperCase());
		
		usuariosDto.orElseThrow(() -> new UsernameNotFoundException("Not Found: " + userName));
		
		return usuariosDto.map(MyUserDetailsServiceImp::new).get();
	}
}
