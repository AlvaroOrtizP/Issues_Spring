package com.alvaro.spring.msvc.usuarios.msvcusuarios.repository;

import com.alvaro.spring.msvc.usuarios.msvcusuarios.model.entity.IssueEntity;
import org.springframework.data.domain.Page;

public interface IssueRepositoryCustom {
    Page<IssueEntity> customFind(String nombre, String descripcion, int codigo, boolean resuelta);
}
