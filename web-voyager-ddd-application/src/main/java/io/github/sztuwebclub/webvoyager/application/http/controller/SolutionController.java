package io.github.sztuwebclub.webvoyager.application.http.controller;

import io.github.sztuwebclub.webvoyager.api.user.request.SolutionSubmitRequest;
import io.github.sztuwebclub.webvoyager.application.http.assembler.SolutionAssembler;
import io.github.sztuwebclub.webvoyager.constant.ResponseCode;
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
    public Response<String> submit(@PathVariable("id") Integer id,
                                   @RequestBody SolutionSubmitRequest solutionSubmitRequest){
        log.info("提交题解");
        Solution solution = SolutionAssembler.solutionSubmitRequestToSolution(solutionSubmitRequest);
        solution.setProblemid(id);
        solution.setUserid(ContextUtil.getCurrentId());
        solutionService.submit(solution);
        return Response.<String>builder()
                .code(ResponseCode.SUCCESS.getCode())
                .info(ResponseCode.SUCCESS.getInfo())
                .data("提交题解")
                .build();
    }

    @GetMapping(value = "/solution/page",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter list(@RequestParam("page")Integer page,
                                               @RequestParam("pagesize")Integer pagesize,
                                               @RequestParam("problemId")Integer problemId,
                                               @RequestParam("contestId")Integer contestId,
                                               @RequestParam("userId")Integer userId){
        log.info("题解列表获取");
        return solutionService.streamSolutionsWithSSE(page,pagesize,problemId,contestId,userId);
    }
}
