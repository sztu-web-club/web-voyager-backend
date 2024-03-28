package io.github.sztuwebclub.webvoyager.infra.repo;

import io.github.sztuwebclub.webvoyager.domain.Contest.IContestRepo;
import io.github.sztuwebclub.webvoyager.infra.dao.ContestMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class ContestRepo implements IContestRepo {
    @Resource
    private ContestMapper contestDao;

    
}
