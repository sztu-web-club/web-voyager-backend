package io.github.sztuwebclub.webvoyager.domain.topic;

import io.github.sztuwebclub.webvoyager.domain.user.User;

import java.util.List;

public interface ITopicUserRepo {
    Integer topicCount(Integer problemId, Integer contestId, Integer reply);

    List<Topic> pageQuery(Integer start, Integer pagesize, Integer problemId, Integer contestId, Integer reply);

    User getUserById(Long id);
}
