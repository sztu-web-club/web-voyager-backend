package io.github.sztuwebclub.webvoyager.domain.topic;

import io.github.sztuwebclub.webvoyager.constant.AuditableEntity;
import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import io.github.sztuwebclub.webvoyager.domain.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class TopicUser extends AuditableEntity implements Serializable {
    private Long topicid;
    private User user;
    private String content;
    private Integer reply;
    private Integer publicshow;
    private Integer contestid;
    private Date indate;
    private Integer problemid;

    private TopicUser topicToTopicUser(Topic topic,ITopicUserRepo topicUserRepo){
        return TopicUser.builder()
                .topicid(topic.getTopicid())
                .user(User.builder()
                        .id(Long.valueOf(topic.getUserid()))
                        .build()
                        .getUserById(topicUserRepo))
                .content(topic.getContent())
                .reply(topic.getReply())
                .publicshow(topic.getPublicshow())
                .contestid(topic.getContestid())
                .indate(topic.getIndate())
                .problemid(topic.getProblemid())
                .build();
    }

    private List<TopicUser> topicListToTopicUserList(List<Topic> topicList,ITopicUserRepo topicUserRepo){
        List<TopicUser> topicUserList = new ArrayList<>();
        for(Topic topic : topicList){
            topicUserList.add(topicToTopicUser(topic,topicUserRepo));
        }
        return topicUserList;
    }

    public PageResult<TopicUser> pageQuery(Integer page, Integer pagesize, ITopicUserRepo topicUserRepo) {
        Topic topic = Topic.builder()
                .problemid(problemid)
                .contestid(contestid)
                .reply(reply)
                .build();
        PageResult<Topic> topicPageResult = topic.pageQuery(page,pagesize,topicUserRepo);
        List<TopicUser> resultList = topicListToTopicUserList(topicPageResult.getList(),topicUserRepo);
        return new PageResult<>(topicPageResult.getTotal(), topicPageResult.getStart() + 1, pagesize, resultList);
    }
}
