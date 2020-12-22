package com.travelblogger.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.travelblogger.repository.PostRepository;
import com.travelblogger.service.dto.PostDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<ObjectNode> doSearch(PostDTO dto, Pageable pageable) {
        return postRepository.getPosts(dto, pageable);
    }

}
