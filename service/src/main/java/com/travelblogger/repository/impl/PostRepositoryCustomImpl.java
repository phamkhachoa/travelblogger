package com.travelblogger.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.travelblogger.repository.PostRepositoryCustom;
import com.travelblogger.service.dto.IPostDTO;
import com.travelblogger.service.dto.PostDTO;
import org.springframework.data.domain.Pageable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class PostRepositoryCustomImpl implements PostRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ObjectNode> getPosts(PostDTO dto, Pageable pageable) {
        StringBuffer sql = new StringBuffer("select ");
        sql.append("p.id as id, ");
        sql.append("p.description as description, ");
        sql.append("p.content as content ");
        sql.append("From tbl_post p");

        Query query = em.createNativeQuery(sql.toString(), Tuple.class);
        List<Tuple> results = query.getResultList();
        List<ObjectNode> json = _toJson(results);

        return json;
    }

    private List<ObjectNode> _toJson(List<Tuple> results) {

        List<ObjectNode> json = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();

        for (Tuple t : results)
        {
            List<TupleElement<?>> cols = t.getElements();

            ObjectNode one = mapper.createObjectNode();

            for (TupleElement col : cols)
            {
                one.put(col.getAlias(), t.get(col.getAlias()).toString());
            }

            json.add(one);
        }

        return json;
    }
}
