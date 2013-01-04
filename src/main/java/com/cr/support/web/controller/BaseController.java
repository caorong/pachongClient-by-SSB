package com.cr.support.web.controller;


import java.beans.PropertyEditorSupport;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.util.WebUtils;

import com.cr.support.web.controller.pagination.Pageable;
import com.cr.support.web.controller.pagination.impl.PageRequest;




/**
 * @Description 控制器基类
 * @author caobin
 * @date 2012-11-15
 * @version 1.0
 */
public abstract class BaseController extends MultiActionController{

	/**
	 * @Description 创建ModelAndView实例
	 * @return
	 * @author caobin
	 */
	protected ModelAndView createMAV() {
		return new ModelAndView();
	}

	/**
	 * @Description 创建带有试图名称的ModelAndView实例
	 * @param viewName
	 * @return
	 * @author caobin
	 */
	protected ModelAndView createMAV(String viewName) {
		return new ModelAndView(viewName);
	}
	
	

	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		super.initBinder(request, binder);
		//扩展日期绑定
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
		    public void setAsText(String value) {
		        try {		        	
		            setValue(DateUtils.parseDate(value, candidateDatePatterns));
		        } catch(ParseException e) {
		        	log.error(e.getMessage());
		            setValue(null);
		        }
		    }

		    public String getAsText() {
		        return String.valueOf(getValue());
		    }        

		});
	}

	/**
	 * @Description  通过请求参数绑定Model
	 * @param request
	 * @param clazz 绑定类
	 * @return
	 * @throws Exception
	 * @author caobin
	 */
	protected <T> T bindModel(HttpServletRequest request, Class<T> clazz)
			throws Exception {
		T object = (T) newCommandObject(clazz);
		bind(request, object);
		return object;
	}


	/**
	 * @Description 获取分页信息
	 * @param request
	 * @return
	 * @author caobin
	 */
	protected Pageable findPage(HttpServletRequest request){
		return new PageRequest(
				findIntegerParameterValue(request, "start"), 
				findIntegerParameterValue(request, "limit")
		);
	}

	/**
	 * @Description 获取分页信息
	 * @param request
	 * @param startFieldName 起始页字段名称
	 * @param limitFieldName 单页总量字段名称
	 * @return
	 * @author caobin
	 */
	protected Pageable findPage(HttpServletRequest request, String startFieldName, String limitFieldName){
		Validate.notBlank(startFieldName, "start field name required");
		Validate.notBlank(limitFieldName, "limit field name required");
		return new PageRequest(
				findIntegerParameterValue(request, startFieldName), 
				findIntegerParameterValue(request, limitFieldName)
		);
	}
	

	/**
	 * @Description 从请求中获取Integer类型参数
	 * @param request
	 * @param name 参数名称
	 * @return
	 * @author caobin
	 */
	protected Integer findIntegerParameterValue(HttpServletRequest request,
			String name) {
		return Integer.parseInt(WebUtils.findParameterValue(request, name));
	}

	/**
	 * @Description 从请求中获取Long类型参数
	 * @param request
	 * @param name 参数名称
	 * @return
	 * @author caobin
	 */
	protected Long findLongParameterValue(HttpServletRequest request,
			String name) {
		return Long.parseLong(String.valueOf(request.getAttribute(name)));
	}

	/**
	 * @Description 从请求中获取String类型参数
	 * @param request
	 * @param name 参数名称
	 * @return
	 * @author caobin
	 */
	protected String findStringParameterValue(HttpServletRequest request,
			String name) {
		return WebUtils.findParameterValue(request, name);
	}

	/**
	 * @Description 从请求中获取Boolean类型参数
	 * @param request
	 * @param name 参数名称
	 * @return
	 * @author caobin
	 */
	protected Boolean findBooleanParameterValue(HttpServletRequest request,
			String name) {
		return Boolean.parseBoolean(WebUtils.findParameterValue(request, name));
	}

	/**
	 * @Description 从请求中获取Date类型参数
	 * @param request
	 * @param name 参数名称
	 * @param datePattern 日期模式
	 * @return
	 * @throws ParseException
	 * @author caobin
	 */
	protected Date findDateParameterValue(HttpServletRequest request,
			String name, String datePattern) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat(datePattern);
		return dateFormat.parse(WebUtils.findParameterValue(request, name));
	}

	/**
	 * @Description 提供文件下载方法
	 * @param request
	 * @param storeName 文件在服务器的名称
	 * @param realName  给客户端下载时显示的名称
	 * @return null
	 * @throws Exception
	 * @author caorong
	 */
	protected void download(HttpServletRequest request,  
            HttpServletResponse response, String realName,  
            String storeName) throws Exception {
//		response.setContentType("text/html;charset=UTF-8");  
		response.reset(); 
        request.setCharacterEncoding("UTF-8");  
		BufferedInputStream bis = null; 
		BufferedOutputStream bos = null;  
		//真实地址
		//getServletContext: C:\Documents and Settings\cr\workspace-sts\core-mmcs\web\
		String ctxPath = request.getSession().getServletContext().getRealPath("/");  
        String downLoadPath = ctxPath + storeName; 
        long fileLength = new File(downLoadPath).length();  
        //ie6 name encode
        realName = URLEncoder.encode(realName, "UTF-8");  //UTF-8
        response.setContentType("application/octet-stream;charset=UTF-8");  
        response.setHeader("Content-disposition", "attachment; filename=" + 
        		new String(realName.getBytes("UTF-8"), "ISO8859-1"));
        response.setHeader("Content-Length", String.valueOf(fileLength));  
        bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
        bos = new BufferedOutputStream(response.getOutputStream());
        byte[] buff = new byte[2048];  
        int bytesRead;  
        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
            bos.write(buff, 0, bytesRead);  
        }
        bos.flush();
        bis.close();  
        bos.close();
	}
	
	//候选日期模式
	private String[] candidateDatePatterns;
	
	public void setCandidateDatePatterns(String[] candidateDatePatterns) {
		this.candidateDatePatterns = candidateDatePatterns;
	}

	protected transient Logger log = LoggerFactory.getLogger(this.getClass());
	
}
