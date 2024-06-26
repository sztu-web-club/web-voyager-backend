package io.github.sztuwebclub.webvoyager.application.http.controller;

import io.github.sztuwebclub.webvoyager.api.user.response.TopicPage;
import io.github.sztuwebclub.webvoyager.application.http.assembler.TopicAdssembler;
import io.github.sztuwebclub.webvoyager.constant.ResponseCode;
import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import io.github.sztuwebclub.webvoyager.constant.model.Response;
import io.github.sztuwebclub.webvoyager.domain.service.ITopicService;
import io.github.sztuwebclub.webvoyager.domain.topic.TopicUser;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TopicController {
    @Resource
    private ITopicService topicService;

    @GetMapping("/topic/page")
    public Response<PageResult<TopicPage>> page(@RequestParam("page")Integer page,
                                                @RequestParam("pagesize")Integer pagesize,
                                                @RequestParam("problemId")Integer problemId,
                                                @RequestParam("contestId")Integer contestId,
                                                @RequestParam("reply")Integer reply){
        log.info("留言列表获取");
        PageResult<TopicUser> topicUserPageResult = topicService.pageQuery(page,pagesize,problemId,contestId,reply);
        PageResult<TopicPage> pageResult = TopicAdssembler.topicUserPageResultToTopicPageRespPageResult(topicUserPageResult);
        return Response.<PageResult<TopicPage>>builder()
                .code(ResponseCode.SUCCESS.getCode())
                .info(ResponseCode.SUCCESS.getInfo())
                .data(pageResult)
                .build();
    }
}
