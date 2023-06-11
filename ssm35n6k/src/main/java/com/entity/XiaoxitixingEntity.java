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
 * 消息提醒
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-02-19 19:16:19
 */
@TableName("xiaoxitixing")
public class XiaoxitixingEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XiaoxitixingEntity() {
		
	}
	
	public XiaoxitixingEntity(T t) {
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
	 * 提醒编号
	 */
					
	private String tixingbianhao;
	
	/**
	 * 提醒标题
	 */
					
	private String tixingbiaoti;
	
	/**
	 * 区域
	 */
					
	private String quyu;
	
	/**
	 * 提醒时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date tixingshijian;
	
	/**
	 * 提醒视频
	 */
					
	private String tixingshipin;
	
	/**
	 * 通知方式
	 */
					
	private String tongzhifangshi;
	
	/**
	 * 提醒详情
	 */
					
	private String tixingxiangqing;
	
	
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
	 * 设置：提醒编号
	 */
	public void setTixingbianhao(String tixingbianhao) {
		this.tixingbianhao = tixingbianhao;
	}
	/**
	 * 获取：提醒编号
	 */
	public String getTixingbianhao() {
		return tixingbianhao;
	}
	/**
	 * 设置：提醒标题
	 */
	public void setTixingbiaoti(String tixingbiaoti) {
		this.tixingbiaoti = tixingbiaoti;
	}
	/**
	 * 获取：提醒标题
	 */
	public String getTixingbiaoti() {
		return tixingbiaoti;
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
	 * 设置：提醒时间
	 */
	public void setTixingshijian(Date tixingshijian) {
		this.tixingshijian = tixingshijian;
	}
	/**
	 * 获取：提醒时间
	 */
	public Date getTixingshijian() {
		return tixingshijian;
	}
	/**
	 * 设置：提醒视频
	 */
	public void setTixingshipin(String tixingshipin) {
		this.tixingshipin = tixingshipin;
	}
	/**
	 * 获取：提醒视频
	 */
	public String getTixingshipin() {
		return tixingshipin;
	}
	/**
	 * 设置：通知方式
	 */
	public void setTongzhifangshi(String tongzhifangshi) {
		this.tongzhifangshi = tongzhifangshi;
	}
	/**
	 * 获取：通知方式
	 */
	public String getTongzhifangshi() {
		return tongzhifangshi;
	}
	/**
	 * 设置：提醒详情
	 */
	public void setTixingxiangqing(String tixingxiangqing) {
		this.tixingxiangqing = tixingxiangqing;
	}
	/**
	 * 获取：提醒详情
	 */
	public String getTixingxiangqing() {
		return tixingxiangqing;
	}

}
