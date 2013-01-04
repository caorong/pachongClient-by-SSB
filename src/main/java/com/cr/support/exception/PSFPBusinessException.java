package com.cr.support.exception;

/**
 * @Description 基础应用平台业务异常 
 * @author caobin
 * @date 2012-11-19
 * @version 1.0
 */
public class PSFPBusinessException extends Exception {

	private static final long serialVersionUID = -1782696386017865795L;
	
	public PSFPBusinessException() {
		super();
	}

	public PSFPBusinessException(String message) {
		super(message);
	}

	public PSFPBusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public PSFPBusinessException(Throwable cause) {
		super(cause);
	}

}
