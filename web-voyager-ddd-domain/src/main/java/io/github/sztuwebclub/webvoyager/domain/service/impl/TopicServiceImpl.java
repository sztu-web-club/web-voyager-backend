package io.github.sztuwebclub.webvoyager.domain.service.impl;

import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import io.github.sztuwebclub.webvoyager.domain.service.ITopicService;
import io.github.sztuwebclub.webvoyager.domain.topic.ITopicUserRepo;
import io.github.sztuwebclub.webvoyager.domain.topic.TopicUser;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements ITopicService {
    @Resource
    private ITopicUserRepo topicUserRepo;

    @Override
    public PageResult<TopicUser> pageQuery(Integer page, Integer pagesize, Integer problemId, Integer contestId, Integer reply) {
        TopicUser topicUser = TopicUser.builder()
                .problemid(problemId)
                .contestid(contestId)
                .reply(reply)
                .build();
        return topicUser.pageQuery(page,pagesize,topicUserRepo);
    }
}
