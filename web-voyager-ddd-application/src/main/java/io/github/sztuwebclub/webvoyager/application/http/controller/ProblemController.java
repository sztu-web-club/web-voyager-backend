package io.github.sztuwebclub.webvoyager.application.http.controller;

import io.github.sztuwebclub.webvoyager.api.user.response.ProblemInfoResp;
import io.github.sztuwebclub.webvoyager.application.http.assembler.ProblemAssembler;
import io.github.sztuwebclub.webvoyager.constant.ResponseCode;
import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import io.github.sztuwebclub.webvoyager.constant.model.Response;
import io.github.sztuwebclub.webvoyager.domain.Service.ProblemService;
import io.github.sztuwebclub.webvoyager.domain.problem.Problem;
import io.github.sztuwebclub.webvoyager.domain.problem.ProblemDetails;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ProblemController {

    @Resource
    private ProblemService problemService;

    @GetMapping("/problem/page")
    public Response<PageResult<Problem>> list(@RequestParam("page")Integer page,@RequestParam("pagesize")Integer pagesize,@RequestParam("title")String title){
        log.info("问题列表获取");
        PageResult<Problem> pageResult = problemService.pageQuery(page,pagesize,title);
        return Response.<PageResult<Problem>>builder()
                .code(ResponseCode.SUCCESS.getCode())
                .info(ResponseCode.SUCCESS.getInfo())
                .data(pageResult)
                .build();
    }

    @GetMapping("/problem/info/{id}")
    public Response<ProblemInfoResp> info(@PathVariable("id") Integer id){
        log.info("问题详细信息获取");
        Problem problem = problemService.getProblemById(id);
        ProblemDetails problemDetails = problemService.getProblemDetailsById(id);
        ProblemInfoResp problemInfoResp = ProblemAssembler.problemWithDetailsToProblemInfoResp(problem,problemDetails);
        return Response.<ProblemInfoResp>builder()
                .code(ResponseCode.SUCCESS.getCode())
                .info(ResponseCode.SUCCESS.getInfo())
                .data(problemInfoResp)
                .build();
    }

}
