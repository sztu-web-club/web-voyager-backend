package io.github.sztuwebclub.webvoyager.infra.repo;

import io.github.sztuwebclub.webvoyager.domain.problem.IProblemRepo;
import io.github.sztuwebclub.webvoyager.infra.dao.ProblemMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class ProblemRepo implements IProblemRepo {
    @Resource
    private ProblemMapper problemDao;
}
