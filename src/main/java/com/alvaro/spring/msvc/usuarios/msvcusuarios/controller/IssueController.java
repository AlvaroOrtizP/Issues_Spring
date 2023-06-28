package com.alvaro.spring.msvc.usuarios.msvcusuarios.controller;

import com.alvaro.spring.msvc.usuarios.msvcusuarios.model.dto.Issue;
import com.alvaro.spring.msvc.usuarios.msvcusuarios.model.entity.IssueEntity;
import com.alvaro.spring.msvc.usuarios.msvcusuarios.service.IssueService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/issues")
public class IssueController {
    private IssueService issueService;

    public IssueController(IssueService issueService){
        this.issueService = issueService;
    }

    @GetMapping
    public ResponseEntity<List<IssueEntity>> getIssue(){
       List<IssueEntity> lista =  issueService.findAll();
        return ResponseEntity.ok(lista);
    }
}
