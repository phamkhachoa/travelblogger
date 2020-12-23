package com.travelblogger.repository.impl;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.travelblogger.repository.PostRepositoryCustom;
import com.travelblogger.service.dto.PostDTO;
import com.travelblogger.util.JsonUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.*;
import java.util.List;
import java.util.StringJoiner;

public class PostRepositoryCustomImpl implements PostRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Page<ObjectNode> getPosts(PostDTO dto, Pageable pageable) {
        Long count = 0L;
        StringBuffer sql = new StringBuffer("select ");
        sql.append("p.id as id, ");
        sql.append("p.description as description, ");
        sql.append("p.content as content, ");
        sql.append("p.img_post imgPost, ");
        sql.append("p.create_date createDate, ");
        sql.append("p.likes likes, ");
        sql.append("p.district district, ");
        sql.append("p.id_province idProvince, ");
        sql.append("p.id_account idAccount, ");
        sql.append("p.id_topic idTopic, ");
        sql.append("p.name_place namePlace, ");
        sql.append("p.title title, ");
        sql.append("p.active_flag activeFlag ");
        sql.append("From tbl_post p ");

        Sort sort = pageable.getSort();
        if (sort.isSorted()) {
            StringJoiner joiner = new StringJoiner(",");
            sql.append("ORDER BY ");
            sort.get().forEach(s -> {
                joiner.add(s.getProperty() + " " + s.getDirection());
            });
            sql.append(joiner);
        }

        Query query = em.createNativeQuery(sql.toString(), Tuple.class)
            .setFirstResult((int) pageable.getOffset())
            .setMaxResults(pageable.getPageSize());



//        query.setParameter("pageable", "?#{#" +pageable + "}");

        List<Tuple> results = query.getResultList();
        List<ObjectNode> json = JsonUtil._toJson(results);

        return new PageImpl<>(json, pageable, count);
    }
}
