package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JiankongxinxiEntity;
import com.entity.view.JiankongxinxiView;

import com.service.JiankongxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 监控信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-02-19 19:16:19
 */
@RestController
@RequestMapping("/jiankongxinxi")
public class JiankongxinxiController {
    @Autowired
    private JiankongxinxiService jiankongxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiankongxinxiEntity jiankongxinxi, 
		HttpServletRequest request){

        EntityWrapper<JiankongxinxiEntity> ew = new EntityWrapper<JiankongxinxiEntity>();


		PageUtils page = jiankongxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankongxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiankongxinxiEntity jiankongxinxi, 
		HttpServletRequest request){
        EntityWrapper<JiankongxinxiEntity> ew = new EntityWrapper<JiankongxinxiEntity>();

		PageUtils page = jiankongxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankongxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiankongxinxiEntity jiankongxinxi){
       	EntityWrapper<JiankongxinxiEntity> ew = new EntityWrapper<JiankongxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiankongxinxi, "jiankongxinxi")); 
        return R.ok().put("data", jiankongxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiankongxinxiEntity jiankongxinxi){
        EntityWrapper< JiankongxinxiEntity> ew = new EntityWrapper< JiankongxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiankongxinxi, "jiankongxinxi")); 
		JiankongxinxiView jiankongxinxiView =  jiankongxinxiService.selectView(ew);
		return R.ok("查询监控信息成功").put("data", jiankongxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiankongxinxiEntity jiankongxinxi = jiankongxinxiService.selectById(id);
		jiankongxinxi.setClicktime(new Date());
		jiankongxinxiService.updateById(jiankongxinxi);
        return R.ok().put("data", jiankongxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiankongxinxiEntity jiankongxinxi = jiankongxinxiService.selectById(id);
		jiankongxinxi.setClicktime(new Date());
		jiankongxinxiService.updateById(jiankongxinxi);
        return R.ok().put("data", jiankongxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiankongxinxiEntity jiankongxinxi, HttpServletRequest request){
    	jiankongxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiankongxinxi);

        jiankongxinxiService.insert(jiankongxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiankongxinxiEntity jiankongxinxi, HttpServletRequest request){
    	jiankongxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiankongxinxi);

        jiankongxinxiService.insert(jiankongxinxi);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiankongxinxiEntity jiankongxinxi, HttpServletRequest request) throws IOException {
        //ValidatorUtils.validateEntity(jiankongxinxi);
//        String file = jiankongxinxi.getJiankongshipin();
//        String contextPath = request.getSession().getServletContext().getRealPath("/");
//        String allPath = contextPath + "/"+file;
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpPost uploadFile = new HttpPost("http://localhost:5000/detect");
//
//        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//        builder.addPart("file", new FileBody(new File(allPath)));
//        HttpEntity multipart = builder.build();
//
//        uploadFile.setEntity(multipart);
//
//        CloseableHttpResponse response = httpClient.execute(uploadFile);
//        HttpEntity responseEntity = response.getEntity();
//
//        String responseString = EntityUtils.toString(responseEntity);
//        System.out.println("Response content: " + responseString);
//
//        JSONObject jsonResponse = new JSONObject(responseString);
//        if(jsonResponse.has("result")){
//            System.out.println(jsonResponse.get("result"));
//            if (jsonResponse.getBoolean("result")) {
//                //存在人的情况
//                jiankongxinxi.setIsWarning(1);
//                System.out.println("Error: " + jsonResponse.getString("error"));
//            } else  {
//                //没有人
//                jiankongxinxi.setIsWarning(0);
//                System.out.println("Result: " + jsonResponse.getString("result"));
//            }
//        }
//        try {
//            response.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }


        jiankongxinxiService.updateById(jiankongxinxi);//全部更新
        return R.ok();
    }
    
    /**
     * 修改浏览时长
     */
    @IgnoreAuth
    @RequestMapping("/updateBrowseDuration/{id}")
    public R updateBrowseDuration(@PathVariable("id") String id,@RequestParam Integer duration, HttpServletRequest request){
        synchronized (this) {
            JiankongxinxiEntity jiankongxinxi = jiankongxinxiService.selectById(id);
            jiankongxinxi.setBrowseduration(jiankongxinxi.getBrowseduration() + duration);
            jiankongxinxiService.updateById(jiankongxinxi);
        }
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiankongxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<JiankongxinxiEntity> wrapper = new EntityWrapper<JiankongxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = jiankongxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,JiankongxinxiEntity jiankongxinxi, HttpServletRequest request,String pre){
        EntityWrapper<JiankongxinxiEntity> ew = new EntityWrapper<JiankongxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "browseduration");
        
        params.put("order", "desc");
		PageUtils page = jiankongxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankongxinxi), params), params));
        return R.ok().put("data", page);
    }









}
