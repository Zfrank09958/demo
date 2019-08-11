package com.example.demo.dao;


import com.example.demo.model.ControlModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ControlModelMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(ControlModel record);

    int updateByPrimaryKeySelective(ControlModel record);

    List<ControlModel> selectAll();
}