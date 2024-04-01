package io.github.sztuwebclub.webvoyager.application.http.assembler;

import io.github.sztuwebclub.webvoyager.api.user.response.TopicPage;
import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import io.github.sztuwebclub.webvoyager.domain.topic.ITopicUserRepo;
import io.github.sztuwebclub.webvoyager.domain.topic.Topic;
import io.github.sztuwebclub.webvoyager.domain.topic.TopicUser;
import io.github.sztuwebclub.webvoyager.domain.user.User;

import java.util.ArrayList;
import java.util.List;

public class TopicAdssembler {

    private static TopicPage topicUserToTopicPage(TopicUser topicUser){
        return TopicPage.builder()
                .topicid(topicUser.getTopicid())
                .nickname(topicUser.getUser().getNickname())
                .content(topicUser.getContent())
                .reply(topicUser.getReply())
                .publicshow(topicUser.getPublicshow())
                .contestid(topicUser.getContestid())
                .indate(topicUser.getIndate())
                .problemid(topicUser.getProblemid())
                .build();
    }

    private static List<TopicPage> topicUserListToTopicPageList(List<TopicUser> topicUserList){
        List<TopicPage> topicPageList = new ArrayList<>();
        for(TopicUser topicUser : topicUserList){
            topicPageList.add(topicUserToTopicPage(topicUser));
        }
        return topicPageList;
    }
    public static PageResult<TopicPage> topicUserPageResultToTopicPageRespPageResult(PageResult<TopicUser> topicUserPageResult){
        List<TopicPage> resultList = topicUserListToTopicPageList(topicUserPageResult.getList());
        return new PageResult<>(topicUserPageResult.getTotal(), topicUserPageResult.getStart() + 1, topicUserPageResult.getSize(), resultList);
    }
}
