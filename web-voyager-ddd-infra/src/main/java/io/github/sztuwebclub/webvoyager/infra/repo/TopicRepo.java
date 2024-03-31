package io.github.sztuwebclub.webvoyager.infra.repo;

import io.github.sztuwebclub.webvoyager.domain.topic.ITopicRepo;
import io.github.sztuwebclub.webvoyager.domain.topic.Topic;
import io.github.sztuwebclub.webvoyager.domain.user.User;
import io.github.sztuwebclub.webvoyager.infra.dao.TopicMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TopicRepo implements ITopicRepo {
    @Resource
    private TopicMapper topicDao;

    @Override
    public Integer topicCount(Integer problemId, Integer contestId, Integer reply) {
        return topicDao.topicCount(problemId,contestId,reply);
    }

    @Override
    public List<Topic> pageQuery(Integer start, Integer pagesize, Integer problemId, Integer contestId, Integer reply) {
        return topicDao.pageQuery(start,pagesize,problemId,contestId,reply);
    }
}
