package io.github.sztuwebclub.webvoyager.domain.Service.impl;

import io.github.sztuwebclub.webvoyager.domain.Service.TopicService;
import io.github.sztuwebclub.webvoyager.domain.topic.ITopicRepo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService {
    @Resource
    private ITopicRepo topicRepo;
}
