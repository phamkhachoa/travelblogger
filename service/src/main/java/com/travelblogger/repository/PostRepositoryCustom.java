package com.travelblogger.repository;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.travelblogger.domain.entities.TblPostEntity;
import com.travelblogger.service.dto.PostDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostRepositoryCustom {
    List<ObjectNode> getPosts(PostDTO dto, Pageable pageable);
}
