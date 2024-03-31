package io.github.sztuwebclub.webvoyager.application.http.controller;

import io.github.sztuwebclub.webvoyager.api.user.request.ContestCreatRequest;
import io.github.sztuwebclub.webvoyager.api.user.response.ContestInfoResp;
import io.github.sztuwebclub.webvoyager.application.http.assembler.ContestAssembler;
import io.github.sztuwebclub.webvoyager.constant.ResponseCode;
import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import io.github.sztuwebclub.webvoyager.constant.model.Response;
import io.github.sztuwebclub.webvoyager.domain.contest.Contest;
import io.github.sztuwebclub.webvoyager.domain.contest.ContestProblem;
import io.github.sztuwebclub.webvoyager.domain.service.IContestService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ContestController {
    @Resource
    private IContestService contestService;

    @PostMapping("/contest/creat")
    public Response<String> creat(@RequestBody ContestCreatRequest contestCreatRequest){
        log.info("创建比赛");
        List<ContestProblem> contestProblemList = ContestAssembler.contestCreatRequestToContestProblemList(contestCreatRequest);
        contestService.creatContest(contestCreatRequest.getName(),
                contestCreatRequest.getStarttime(),
                contestCreatRequest.getEndtime(),
                contestCreatRequest.getDesp(),
                contestProblemList);

        return Response.<String>builder()
                .code(ResponseCode.SUCCESS.getCode())
                .info(ResponseCode.SUCCESS.getInfo())
                .data("创建比赛")
                .build();
    }

    @GetMapping("/contest/page")
    public Response<PageResult<Contest>> list(@RequestParam("page")Integer page,
                                              @RequestParam("pagesize")Integer pagesize,
                                              @RequestParam("name")String name){
        log.info("比赛列表获取");
        PageResult<Contest> pageResult = contestService.pageQuery(page,pagesize,name);
        return Response.<PageResult<Contest>>builder()
                .code(ResponseCode.SUCCESS.getCode())
                .info(ResponseCode.SUCCESS.getInfo())
                .data(pageResult)
                .build();
    }

    @GetMapping("/contest/info/{id}")
    public Response<ContestInfoResp> info(@PathVariable("id") Integer id){
        log.info("比赛详细信息获取");
        Contest contest = contestService.getContestById(id);
        List<ContestProblem> contestProblemList = contestService.getContestProblemListByContestId(id);
        ContestInfoResp contestInfoResp = ContestAssembler.contestWithProblemListToContestInfoResp(contest,contestProblemList);
        return Response.<ContestInfoResp>builder()
                .code(ResponseCode.SUCCESS.getCode())
                .info(ResponseCode.SUCCESS.getInfo())
                .data(contestInfoResp)
                .build();
    }
}
