package io.github.sztuwebclub.webvoyager.infra.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.sztuwebclub.webvoyager.domain.topic.Topic;
import io.github.sztuwebclub.webvoyager.infra.po.TopicPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopicMapper extends BaseMapper<TopicPO> {
    Integer topicCount(@Param("problemId")Integer problemId, @Param("contestId")Integer contestId, @Param("reply")Integer reply);

    List<Topic> pageQuery(@Param("start") Integer start, @Param("pagesize") Integer pagesize, @Param("problemId")Integer problemId, @Param("contestId")Integer contestId, @Param("reply")Integer reply);
}
