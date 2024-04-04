package io.github.sztuwebclub.webvoyager.application.http.controller;

import io.github.sztuwebclub.webvoyager.api.user.request.SolutionSubmitRequest;
import io.github.sztuwebclub.webvoyager.constant.ResponseCode;
import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import io.github.sztuwebclub.webvoyager.constant.model.Response;
import io.github.sztuwebclub.webvoyager.constant.utils.ContextUtil;
import io.github.sztuwebclub.webvoyager.domain.service.ISolutionService;
import io.github.sztuwebclub.webvoyager.domain.solution.Solution;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Slf4j
@RestController
public class SolutionController {

    @Resource
    private ISolutionService solutionService;

    @PostMapping("/solution/submit/{id}")
    public Response<String> submit(@PathVariable("id") Integer problemId,
                                   @RequestBody SolutionSubmitRequest solutionSubmitRequest){
        log.info("提交题解");
        solutionService.submit(problemId,
                ContextUtil.getCurrentId(),
                solutionSubmitRequest.getConstestid(),
                solutionSubmitRequest.getLang(),
                solutionSubmitRequest.getCode());
        return Response.<String>builder()
                .code(ResponseCode.SUCCESS.getCode())
                .info(ResponseCode.SUCCESS.getInfo())
                .data("提交题解")
                .build();
    }

    @GetMapping("/solution/page")
    public Response<PageResult<Solution>> page(@RequestParam("page")Integer page,
                                               @RequestParam("pagesize")Integer pagesize,
                                               @RequestParam("problemId")Integer problemId,
                                               @RequestParam("contestId")Integer contestId,
                                               @RequestParam("userId")Integer userId){
        log.info("题解列表获取");
        PageResult<Solution> pageResult = solutionService.pageQuery(page,pagesize,problemId,contestId,userId);
        return Response.<PageResult<Solution>>builder()
                .code(ResponseCode.SUCCESS.getCode())
                .info(ResponseCode.SUCCESS.getInfo())
                .data(pageResult)
                .build();
    }

    @GetMapping(value = "/solution/ssepage",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter ssepage(@RequestParam("page")Integer page,
                                               @RequestParam("pagesize")Integer pagesize,
                                               @RequestParam("problemId")Integer problemId,
                                               @RequestParam("contestId")Integer contestId,
                                               @RequestParam("userId")Integer userId){
        log.info("题解列表获取");
        return solutionService.streamSolutionPageWithSSE(page,pagesize,problemId,contestId,userId);
    }
    @GetMapping(value = "/solution/info/{id}")
    public Response<Solution> info(@PathVariable("id")Integer id){
        log.info("题解详细信息获取");
        Solution solution = solutionService.getSolutionById(id);
        return Response.<Solution>builder()
                .code(ResponseCode.SUCCESS.getCode())
                .info(ResponseCode.SUCCESS.getInfo())
                .data(solution)
                .build();
    }

    //为前端sse准备的备用方案
    @GetMapping(value = "/solution/sseinfo/{id}",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter sseinfo(@PathVariable("id")Integer id){
        log.info("题解详细信息获取");
        return solutionService.streamSolutionWithSSE(id);
    }
}
