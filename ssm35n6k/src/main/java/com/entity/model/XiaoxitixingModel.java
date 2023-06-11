package com.entity.model;

import com.entity.XiaoxitixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 消息提醒
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-02-19 19:16:19
 */
public class XiaoxitixingModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
