package io.github.sztuwebclub.webvoyager.infra.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.sztuwebclub.webvoyager.domain.contest.ContestProblem;
import io.github.sztuwebclub.webvoyager.infra.po.ContestProblemPO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ContestProblemMapper extends BaseMapper<ContestProblemPO> {
    @Select("select contest_id,problem_id,sequence,title from contest_problem where contest_id = #{contestId} order by sequence")
    List<ContestProblem> getContestProblemListByContestId(@Param("contestId") Integer contestId);
}
