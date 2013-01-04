package com.cr.support.exception;
/**
 * @Description 基础应用平台系统(运行时)异常
 * @author caobin
 * @date 2012-11-19
 * @version 1.0
 */
public class PSFPRuntimeSystemException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9190714154628086731L;

	public PSFPRuntimeSystemException() {
		super();
	}

	public PSFPRuntimeSystemException(String message) {
		super(message);
	}

	public PSFPRuntimeSystemException(String message, Throwable cause) {
		super(message, cause);
	}

	public PSFPRuntimeSystemException(Throwable cause) {
		super(cause);
	}
}
