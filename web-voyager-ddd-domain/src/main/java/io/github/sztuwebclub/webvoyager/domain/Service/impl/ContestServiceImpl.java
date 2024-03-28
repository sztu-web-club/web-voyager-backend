package io.github.sztuwebclub.webvoyager.domain.Service.impl;

import io.github.sztuwebclub.webvoyager.domain.Contest.Contest;
import io.github.sztuwebclub.webvoyager.domain.Contest.IContestRepo;
import io.github.sztuwebclub.webvoyager.domain.Service.ContestService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ContestServiceImpl implements ContestService {
    @Resource
    private IContestRepo contestRepo;

    @Override
    public void creatContest(Contest contest) {

    }
}
