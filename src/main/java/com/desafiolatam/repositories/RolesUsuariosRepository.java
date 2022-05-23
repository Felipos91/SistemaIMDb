package com.desafiolatam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafiolatam.models.Usuario;

@Repository
public interface RolesUsuariosRepository extends JpaRepository<Usuario, Long>{

}
