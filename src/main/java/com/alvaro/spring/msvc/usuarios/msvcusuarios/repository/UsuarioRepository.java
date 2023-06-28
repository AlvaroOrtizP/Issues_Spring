package com.alvaro.spring.msvc.usuarios.msvcusuarios.repository;

import com.alvaro.spring.msvc.usuarios.msvcusuarios.model.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
