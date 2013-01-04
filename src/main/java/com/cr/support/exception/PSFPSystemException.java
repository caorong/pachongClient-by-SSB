package com.cr.support.exception;

/**
 * @Description 基础应用平台系统异常
 * @author caobin
 * @date 2012-11-19
 * @version 1.0
 */
public class PSFPSystemException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5582771999787282608L;
	
	public PSFPSystemException() {
		super();
	}

	public PSFPSystemException(String message) {
		super(message);
	}

	public PSFPSystemException(String message, Throwable cause) {
		super(message, cause);
	}

	public PSFPSystemException(Throwable cause) {
		super(cause);
	}

}
