package com.travelblogger.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.travelblogger.domain.entities.TblPostEntity;
import com.travelblogger.repository.PostRepository;
import com.travelblogger.service.dto.PostDTO;
import io.swagger.models.auth.In;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PostService {
    private final PostRepository postRepository;

    private Integer oldLike = 0;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Page<ObjectNode> doSearch(PostDTO dto, Pageable pageable) {
        return postRepository.getPosts(dto, pageable);
    }

    public Flux<Integer> likesTransaction(Integer id) throws Exception {
        Flux<Long> interval = Flux.interval(Duration.ofMillis(1000));
        interval.subscribe((i) -> {
            try {
                TblPostEntity entity = postRepository.findById(id).orElseThrow(() -> new Exception("aa"));
                if(!oldLike.equals(entity.getLikes())) {
                    oldLike = entity.getLikes();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Flux<Integer> stockTransactionFlux = Flux.fromStream(Stream.generate(() -> new Integer(oldLike)));
        return Flux.zip(interval, stockTransactionFlux).map(Tuple2::getT2);
    }
}
