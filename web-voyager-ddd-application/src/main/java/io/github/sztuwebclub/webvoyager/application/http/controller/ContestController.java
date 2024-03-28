package io.github.sztuwebclub.webvoyager.application.http.controller;

import io.github.sztuwebclub.webvoyager.api.user.request.ContestCreatRequest;
import io.github.sztuwebclub.webvoyager.application.http.assembler.ContestAssembler;
import io.github.sztuwebclub.webvoyager.constant.ResponseCode;
import io.github.sztuwebclub.webvoyager.constant.model.Response;
import io.github.sztuwebclub.webvoyager.domain.Contest.Contest;
import io.github.sztuwebclub.webvoyager.domain.Service.ContestService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ContestController {
    @Resource
    private ContestService contestService;

    @PostMapping("/contest/creat")
    public Response<String> creat(@RequestBody ContestCreatRequest contestCreatRequest){
        log.info("创建比赛");
        Contest contest = ContestAssembler.contestCreatRequestToContest(contestCreatRequest);
        contestService.creatContest(contest);

        return Response.<String>builder()
                .code(ResponseCode.SUCCESS.getCode())
                .info(ResponseCode.SUCCESS.getInfo())
                .data("创建比赛")
                .build();
    }
}
