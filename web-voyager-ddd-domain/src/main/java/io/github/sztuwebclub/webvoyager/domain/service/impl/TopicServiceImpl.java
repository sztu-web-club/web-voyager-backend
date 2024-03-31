package io.github.sztuwebclub.webvoyager.domain.service.impl;

import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import io.github.sztuwebclub.webvoyager.domain.service.ITopicService;
import io.github.sztuwebclub.webvoyager.domain.topic.ITopicRepo;
import io.github.sztuwebclub.webvoyager.domain.topic.Topic;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements ITopicService {
    @Resource
    private ITopicRepo topicRepo;

    @Override
    public PageResult<Topic> pageQuery(Integer page, Integer pagesize, Integer problemId, Integer contestId, Integer reply) {
        Topic topic = Topic.builder()
                .problemid(problemId)
                .contestid(contestId)
                .reply(reply)
                .build();
        return topic.pageQuery(page,pagesize,topicRepo);
    }
}
