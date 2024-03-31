package io.github.sztuwebclub.webvoyager.infra.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.sztuwebclub.webvoyager.domain.solution.Solution;
import io.github.sztuwebclub.webvoyager.infra.po.SolutionPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SolutionMapper extends BaseMapper<SolutionPO> {
    Integer solutionCount(@Param("problemId")Integer problemId, @Param("contestId")Integer contestId, @Param("userId")Integer userId);

    List<Solution> pageQuery(@Param("start") Integer start, @Param("pagesize") Integer pagesize, @Param("problemId")Integer problemId, @Param("contestId")Integer contestId, @Param("userId")Integer userId);
}
