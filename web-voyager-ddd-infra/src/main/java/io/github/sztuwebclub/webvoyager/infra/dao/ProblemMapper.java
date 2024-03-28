package io.github.sztuwebclub.webvoyager.infra.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.sztuwebclub.webvoyager.domain.problem.Problem;
import io.github.sztuwebclub.webvoyager.domain.problem.ProblemDetails;
import io.github.sztuwebclub.webvoyager.infra.po.ProblemPO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProblemMapper extends BaseMapper<ProblemPO> {
    Integer problemCount(@Param("title") String title);
    List<Problem> pageQuery(@Param("start") Integer start, @Param("pagesize") Integer pagesize, @Param("title") String title);

    @Select("select id, title, time_limit, memory_limit, total_solved, total_submit, author_id, author_name from problem where id = #{id}")
    Problem getProblemById(@Param("id") Integer id);

    @Select("select id, description, hint_input, hint_output, sample_input, sample_output, hint, input, output from problem_details where id = #{id}")
    ProblemDetails getProblemDeatilsById(@Param("id") Integer id);
}
