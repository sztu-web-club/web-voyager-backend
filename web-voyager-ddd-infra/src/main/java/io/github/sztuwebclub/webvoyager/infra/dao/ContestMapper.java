package io.github.sztuwebclub.webvoyager.infra.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.sztuwebclub.webvoyager.domain.contest.Contest;
import io.github.sztuwebclub.webvoyager.infra.po.ContestPO;
import io.github.sztuwebclub.webvoyager.infra.po.ContestProblemPO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface ContestMapper extends BaseMapper<ContestPO> {
    Integer contestCount(@Param("name")String name);

    List<Contest> pageQuery(@Param("start") Integer start, @Param("pagesize") Integer pagesize, @Param("name")String name);

    @Select("select id, name, start_time, end_time, desp, isprivate from contest where id = #{id}")
    Contest getContestById(@Param("id") Long id);

    @Select("select id, name, start_time, end_time, desp, isprivate from contest where name = #{name}")
    Contest getContestByName(@Param("name") String name);

}
