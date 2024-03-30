package io.github.sztuwebclub.webvoyager.infra.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.sztuwebclub.webvoyager.domain.problem.ProblemDetails;
import io.github.sztuwebclub.webvoyager.infra.po.ProblemDetailsPO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ProblemDatailsMapper extends BaseMapper<ProblemDetailsPO> {
    @Select("select id, description, hint_input, hint_output, sample_input, sample_output, hint, input, output from problem_details where id = #{id}")
    ProblemDetails getProblemDeatilsById(@Param("id") Integer id);
}
