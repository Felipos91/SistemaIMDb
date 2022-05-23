package com.desafiolatam.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Usuario;
import com.desafiolatam.repositories.RolRepository;
import com.desafiolatam.repositories.UsuarioRepository;


@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	RolRepository rolRepository;
	
	public boolean guardarUsuario(Usuario usuario) {
		Usuario usuarioRetorno = usuarioRepository.findByEmail(usuario.getEmail());
		if (usuarioRetorno == null) {
			// password encriptado
			String passHashed = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
			usuario.setPassword(passHashed);

			usuario.setRoles(rolRepository.findByNombre("ROLE_USER"));

			usuarioRepository.save(usuario);
			return true;
		} else {
			return false;
		}
	}
	
}
