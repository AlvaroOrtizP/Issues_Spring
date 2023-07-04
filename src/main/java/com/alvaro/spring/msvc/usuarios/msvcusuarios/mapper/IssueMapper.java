package com.alvaro.spring.msvc.usuarios.msvcusuarios.mapper;

import com.alvaro.spring.msvc.usuarios.msvcusuarios.model.dto.Issue;
import com.alvaro.spring.msvc.usuarios.msvcusuarios.model.entity.IssueEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "string")
public interface IssueMapper {
    Issue toIssue (IssueEntity issueEntity);
    IssueEntity toIssueEntity (Issue issueEntity);

    List<Issue> toIssueList (List<IssueEntity> issueEntity);
}
