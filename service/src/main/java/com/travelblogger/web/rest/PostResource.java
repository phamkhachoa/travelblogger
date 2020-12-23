package com.travelblogger.web.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.travelblogger.service.PostService;
import com.travelblogger.service.dto.PostDTO;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/post")
public class PostResource {

    private final PostService postService;
    private final ModelMapper modelMappers;

    public PostResource(PostService postService, ModelMapper modelMappers) {
        this.postService = postService;
        this.modelMappers = modelMappers;
    }

    protected <T, E> List<T> mapList(List<E> inputData, Class<T> clazz) {
        return CollectionUtils.isEmpty(inputData) ?
            Collections.emptyList() :
            inputData.stream()
            .map(i -> modelMappers.map(i, clazz))
            .collect(Collectors.toList());
    }

    @GetMapping()
    public ResponseEntity<List<PostDTO>> doSearch(PostDTO dto, Pageable pageable) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        ObjectMapper mapper = new ObjectMapper();
        String str = postService.doSearch(dto, pageable).getContent().toString();
        List<PostDTO> pp3 = mapper.readValue(str, new TypeReference<List<PostDTO>>() {});
//        List<PostDTO> list = this.mapList(postService.doSearch(dto, pageable), PostDTO.class);

        return new ResponseEntity<>(pp3, headers, HttpStatus.OK);
    }

    @GetMapping(value = "/likes/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Integer> likesTransactionEvents(@PathVariable Integer id) throws Exception {
        return postService.likesTransaction(id);
    }


}
