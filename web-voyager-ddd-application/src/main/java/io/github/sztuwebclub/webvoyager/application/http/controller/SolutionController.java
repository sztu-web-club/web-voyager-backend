package io.github.sztuwebclub.webvoyager.application.http.controller;

import io.github.sztuwebclub.webvoyager.api.user.request.SolutionSubmitRequest;
import io.github.sztuwebclub.webvoyager.application.http.assembler.SolutionAssembler;
import io.github.sztuwebclub.webvoyager.constant.ResponseCode;
import io.github.sztuwebclub.webvoyager.constant.model.Response;
import io.github.sztuwebclub.webvoyager.constant.utils.ContextUtil;
import io.github.sztuwebclub.webvoyager.domain.Service.SolutionService;
import io.github.sztuwebclub.webvoyager.domain.solution.Solution;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SolutionController {

    @Resource
    private SolutionService solutionService;

    @PostMapping("/solution/submit/{id}")
    public Response<String> submit(@PathVariable("id") Integer id, @RequestBody SolutionSubmitRequest solutionSubmitRequest){
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
}
