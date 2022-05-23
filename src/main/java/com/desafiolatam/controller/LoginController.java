package com.desafiolatam.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.desafiolatam.models.Rol;
import com.desafiolatam.models.RolesUsuarios;
import com.desafiolatam.models.Usuario;
import com.desafiolatam.repositories.RolRepository;
import com.desafiolatam.service.RolesUsuariosService;
import com.desafiolatam.service.UsuarioService;

@Controller
public class LoginController {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	RolesUsuariosService rolesUsuariosService;
	
	@Autowired
	RolRepository rolRepository;
	
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null) {
			model.addAttribute("Error", "Credenciales Invalidas, Intente nuevamente.");

		}
		if (logout != null) {
			model.addAttribute("logoutMessage", "Logout realizado!");

		}
		return "login.jsp";
	}

	@RequestMapping("/registro")
	public String registro(Model model, @ModelAttribute("usuario") Usuario usuario) {
		return "/registro.jsp";
	}
	
	@PostMapping("/registro")
	public String formulario(@ModelAttribute("usuario") Usuario usuario,@ModelAttribute("roles_usuarios") RolesUsuarios rolesUsuarios,
			 Rol rol,Model model) {
		
		if(usuario.getNombre().equals("") && usuario.getNombre()!=null && usuario.getPassword().equals("") && 
				usuario.getPassword()!=null && usuario.getEmail().equals("") && usuario.getEmail()!=null) {
			model.addAttribute("Error", "Debe ingresar todos los campos!");
			return "registro.jsp";
		}else {
			boolean resultado = usuarioService.guardarUsuario(usuario);
			if(resultado) {
				//El usuario ya viene con el ID del rol, se le asginó en UsuarioService
				rolesUsuarios.setUsuario(usuario);
				
				return "redirect:/login";
			}else {
				model.addAttribute("Error", "Correo ya existe");
				return "registro.jsp";
			}
		}
		
		
	}
	
	@RequestMapping(value = {"/"})
    public String home(Principal principal, HttpSession session) {
        // 1
        String userEmail = principal.getName();
        session.setAttribute("usuarioEmail", userEmail);
        System.out.println("Probando LOGIN");
        return "redirect:/home";
    }
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
}
