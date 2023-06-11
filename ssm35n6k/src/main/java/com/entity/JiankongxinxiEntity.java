package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 监控信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-02-19 19:16:19
 */
@TableName("jiankongxinxi")
public class JiankongxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiankongxinxiEntity() {
		
	}
	
	public JiankongxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 编号
	 */
					
	private String bianhao;
	
	/**
	 * 标题
	 */
					
	private String biaoti;
	
	/**
	 * 区域
	 */
					
	private String quyu;
	
	/**
	 * 更新时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date gengxinshijian;
	
	/**
	 * 监控画面
	 */
					
	private String jiankonghuamian;
	
	/**
	 * 监控视频
	 */
					
	private String jiankongshipin;
	
	/**
	 * 监控详情
	 */
					
	private String jiankongxiangqing;
	
	/**
	 * 工作状态
	 */
					
	private String gongzuozhuangtai;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	/**
	 * 浏览时长
	 */
					
	private Integer browseduration;

	public Integer getIsWarning() {
		return isWarning;
	}

	public void setIsWarning(Integer isWarning) {
		this.isWarning = isWarning;
	}

	@TableField("isWarning")
	private Integer isWarning;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：编号
	 */
	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}
	/**
	 * 获取：编号
	 */
	public String getBianhao() {
		return bianhao;
	}
	/**
	 * 设置：标题
	 */
	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}
	/**
	 * 获取：标题
	 */
	public String getBiaoti() {
		return biaoti;
	}
	/**
	 * 设置：区域
	 */
	public void setQuyu(String quyu) {
		this.quyu = quyu;
	}
	/**
	 * 获取：区域
	 */
	public String getQuyu() {
		return quyu;
	}
	/**
	 * 设置：更新时间
	 */
	public void setGengxinshijian(Date gengxinshijian) {
		this.gengxinshijian = gengxinshijian;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getGengxinshijian() {
		return gengxinshijian;
	}
	/**
	 * 设置：监控画面
	 */
	public void setJiankonghuamian(String jiankonghuamian) {
		this.jiankonghuamian = jiankonghuamian;
	}
	/**
	 * 获取：监控画面
	 */
	public String getJiankonghuamian() {
		return jiankonghuamian;
	}
	/**
	 * 设置：监控视频
	 */
	public void setJiankongshipin(String jiankongshipin) {
		this.jiankongshipin = jiankongshipin;
	}
	/**
	 * 获取：监控视频
	 */
	public String getJiankongshipin() {
		return jiankongshipin;
	}
	/**
	 * 设置：监控详情
	 */
	public void setJiankongxiangqing(String jiankongxiangqing) {
		this.jiankongxiangqing = jiankongxiangqing;
	}
	/**
	 * 获取：监控详情
	 */
	public String getJiankongxiangqing() {
		return jiankongxiangqing;
	}
	/**
	 * 设置：工作状态
	 */
	public void setGongzuozhuangtai(String gongzuozhuangtai) {
		this.gongzuozhuangtai = gongzuozhuangtai;
	}
	/**
	 * 获取：工作状态
	 */
	public String getGongzuozhuangtai() {
		return gongzuozhuangtai;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
	/**
	 * 设置：浏览时长
	 */
	public void setBrowseduration(Integer browseduration) {
		this.browseduration = browseduration;
	}
	/**
	 * 获取：浏览时长
	 */
	public Integer getBrowseduration() {
		return browseduration;
	}

}
