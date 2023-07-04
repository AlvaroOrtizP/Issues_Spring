package com.alvaro.spring.msvc.usuarios.msvcusuarios.service;


import com.alvaro.spring.msvc.usuarios.msvcusuarios.mapper.IssueMapper;
import com.alvaro.spring.msvc.usuarios.msvcusuarios.model.entity.IssueEntity;
import com.alvaro.spring.msvc.usuarios.msvcusuarios.repository.IssueRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class IssueService {
    private final IssueRepository repository;

    private final IssueMapper issueMapper;
    public IssueService(IssueRepository repository, IssueMapper issueMapper) {
        this.repository = repository;
        this.issueMapper = issueMapper;
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
