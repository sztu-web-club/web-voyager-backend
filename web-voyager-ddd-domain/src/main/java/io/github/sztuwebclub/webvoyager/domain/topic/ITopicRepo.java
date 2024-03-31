package io.github.sztuwebclub.webvoyager.domain.topic;

import io.github.sztuwebclub.webvoyager.domain.user.User;

import java.util.List;

public interface ITopicRepo {
    Integer topicCount(Integer problemId, Integer contestId, Integer reply);

    List<Topic> pageQuery(Integer start, Integer pagesize, Integer problemId, Integer contestId, Integer reply);
}
