package com.alvaro.spring.msvc.usuarios.msvcusuarios.repository;

import com.alvaro.spring.msvc.usuarios.msvcusuarios.model.entity.IssueEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.HashMap;
import java.util.Map;

public class IssueRepositoryCustomImpl implements IssueRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;
    //TODO Comprobar que funciona
    @Override
    public Page<IssueEntity> customFind(String nombre, String descripcion, int codigo, boolean resuelta) {
        String sql = "SELECT * FROM ISSUE %s  rn BETWEEN :startResult AND :endResult order by id desc";
        String where = "";

        Map<String, Object> parameters = new HashMap<>();
        if (nombre != null) {
            where += "where nombre = :nombre";
            parameters.put("nombre", nombre);
        }
        sql = "SELECT * FROM ISSUE order by id desc";
        Query query = entityManager.createQuery(String.format(sql, where), IssueEntity.class);
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            query = query.setParameter(entry.getKey(), entry.getValue());
        }

        Pageable pageable = PageRequest.of(2, 1);
        Page<IssueEntity> page = new PageImpl<>(query.getResultList(), pageable, 2);

        return page;
    }
}
