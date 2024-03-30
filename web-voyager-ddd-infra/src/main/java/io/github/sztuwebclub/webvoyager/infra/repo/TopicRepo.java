package io.github.sztuwebclub.webvoyager.infra.repo;

import io.github.sztuwebclub.webvoyager.domain.topic.ITopicRepo;
import io.github.sztuwebclub.webvoyager.infra.dao.TopicMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class TopicRepo implements ITopicRepo {
    @Resource
    private TopicMapper topicDao;
}
