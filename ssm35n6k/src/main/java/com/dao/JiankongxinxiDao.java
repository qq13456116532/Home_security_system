package com.dao;

import com.entity.JiankongxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiankongxinxiVO;
import com.entity.view.JiankongxinxiView;


/**
 * 监控信息
 * 
 * @author 
 * @email 
 * @date 2023-02-19 19:16:19
 */
public interface JiankongxinxiDao extends BaseMapper<JiankongxinxiEntity> {
	
	List<JiankongxinxiVO> selectListVO(@Param("ew") Wrapper<JiankongxinxiEntity> wrapper);
	
	JiankongxinxiVO selectVO(@Param("ew") Wrapper<JiankongxinxiEntity> wrapper);
	
	List<JiankongxinxiView> selectListView(@Param("ew") Wrapper<JiankongxinxiEntity> wrapper);

	List<JiankongxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JiankongxinxiEntity> wrapper);
	
	JiankongxinxiView selectView(@Param("ew") Wrapper<JiankongxinxiEntity> wrapper);
	

}
