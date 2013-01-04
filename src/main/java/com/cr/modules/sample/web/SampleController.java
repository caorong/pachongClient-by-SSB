package com.cr.modules.sample.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.Validate;
import org.springframework.web.servlet.ModelAndView;

import com.cr.modules.sample.model.SampleReg;
import com.cr.modules.sample.service.SampleService;
import com.cr.support.util.Identities;
import com.cr.support.web.controller.BaseController;

 

/**
 * Controller样例
 * @Description 
 * @author caobin
 * @date 2012-11-15
 * @version 1.0
 */
public class SampleController extends BaseController {

	
	/**
	 * @Description 显示default样例页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author caobin
	 */
	public ModelAndView sampleDisplay(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		return createMAV("sample/default");
	}
	
	
	
	/**
	 * @Description 创建注册信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author caobin
	 */
	public ModelAndView sampleCreate(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		//前台数据和Model进行绑定
		SampleReg sampleReg = this.bindModel(request, SampleReg.class);
		log.debug("SampleReg: {}", new Object[]{sampleReg});
		//设置一个主键
		sampleReg.setId(Identities.create32LenUUID());
		//创建一条注册记录
		sampleService.create(sampleReg);
		//返回成功视图
		return createMAV("sample/success");
	}
	
	/**
	 * @Description 查询所有注册信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author caobin
	 */
	public ModelAndView sampleQueryAll(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		System.out.println("--------sample");
		//查询所有记录
		List<SampleReg> lstSampleReg = sampleService.queryAll();
		
		//返回视图
		return createMAV("sample/default").addObject("sampleRegList", lstSampleReg);
	}
	
	/**
	 * @Description 查询指定注册信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author caobin
	 */
	public ModelAndView sampleQuery(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		//从前台获取id的值
		String id = this.findStringParameterValue(request, "id");
		//检查id是否为空
		Validate.notBlank(id, "id is required.");
		//获取查询结果
//		SampleReg sampleReg = sampleService.query(id);
		//返回视图
		return createMAV("sample/default")/*.addObject("sampleReg", sampleReg)*/;
	}
	
	/**
	 * @Description 更新注册信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author caobin
	 */
	public ModelAndView sampleUpdate(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		//前台数据和Model进行绑定
		SampleReg sampleReg = this.bindModel(request, SampleReg.class);
		log.debug("SampleReg: {}", new Object[]{sampleReg});
		//检查id是否为空
		Validate.notBlank(sampleReg.getId(), "specified id is required.");		
		//更新记录
		sampleService.update(sampleReg);
		//返回视图
		return createMAV("sample/success").addObject("operation", "update");
	}
	
	/**
	 * @Description 删除注册信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author caobin
	 */
	public ModelAndView sampleDelete(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		//从前台获取id的值
		String id = this.findStringParameterValue(request, "id");
		//检查id是否为空
		Validate.notBlank(id, "id is required.");
		//删除记录
		sampleService.delete(id);
		//返回视图
		return createMAV("sample/success").addObject("operation", "delete");
	}
	
	/**
	 * @Description 发送样例消息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author caobin
	 */
	public ModelAndView sampleSendMsg(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		
		//前台数据和Model进行绑定
		SampleReg sampleReg = this.bindModel(request, SampleReg.class);
		log.debug("SampleReg: {}", new Object[]{sampleReg});
		//发送消息到队列
		sampleService.sendRegMessage(sampleReg);
		//返回视图
		return createMAV("sample/success").addObject("operation", "send message");
	}
	
	
	//注入sampleService
	private SampleService sampleService;

	public void setSampleService(SampleService sampleService) {
		this.sampleService = sampleService;
	}
}
