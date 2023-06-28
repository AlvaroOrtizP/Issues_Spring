package com.alvaro.spring.msvc.usuarios.msvcusuarios.service;


import com.alvaro.spring.msvc.usuarios.msvcusuarios.model.dto.Issue;
import com.alvaro.spring.msvc.usuarios.msvcusuarios.model.entity.IssueEntity;
import com.alvaro.spring.msvc.usuarios.msvcusuarios.repository.IssueRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class IssueService {
    private final IssueRepository repository;
    public IssueService(IssueRepository repository) {
        this.repository = repository;
    }

    public Page<IssueEntity> customFind(){
        Page<IssueEntity> lista=  repository.customFind("", "", 0, true);
        return lista;
    }

    public List<IssueEntity> findAll(){
        List<IssueEntity> lista = repository.findAll();
        return lista;
    }
}
