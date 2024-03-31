package io.github.sztuwebclub.webvoyager.domain.service;

import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import io.github.sztuwebclub.webvoyager.domain.topic.Topic;

public interface ITopicService {
    PageResult<Topic> pageQuery(Integer page, Integer pagesize, Integer problemId, Integer contestId, Integer reply);
}
