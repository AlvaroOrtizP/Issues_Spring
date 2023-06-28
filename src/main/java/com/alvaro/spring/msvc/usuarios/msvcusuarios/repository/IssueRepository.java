package com.alvaro.spring.msvc.usuarios.msvcusuarios.repository;

import com.alvaro.spring.msvc.usuarios.msvcusuarios.model.entity.IssueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends PagingAndSortingRepository<IssueEntity, Long>, JpaSpecificationExecutor<IssueEntity>, IssueRepositoryCustom, JpaRepository<IssueEntity, Long> {
}
