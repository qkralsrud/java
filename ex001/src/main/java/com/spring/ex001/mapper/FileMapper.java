package com.spring.ex001.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.spring.ex001.dto.FileDto;

@Mapper
public interface FileMapper {

	public int regFile(FileDto dto);

}
