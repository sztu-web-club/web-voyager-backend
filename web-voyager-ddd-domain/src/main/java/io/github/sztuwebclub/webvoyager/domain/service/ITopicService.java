package io.github.sztuwebclub.webvoyager.domain.service;

import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import io.github.sztuwebclub.webvoyager.domain.topic.TopicUser;

public interface ITopicService {
    PageResult<TopicUser> pageQuery(Integer page, Integer pagesize, Integer problemId, Integer contestId, Integer reply);
}
