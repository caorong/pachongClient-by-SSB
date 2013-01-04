package com.cr.support.exception;

/**
 * @Description 基础应用平台业务(运行时)异常
 * @author caobin
 * @date 2012-11-19
 * @version 1.0
 */
public class PSFPRuntimeBusinessException extends RuntimeException {

	private static final long serialVersionUID = -7800256979584174017L;

	public PSFPRuntimeBusinessException() {
		super();
	}

	public PSFPRuntimeBusinessException(String message) {
		super(message);
	}

	public PSFPRuntimeBusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public PSFPRuntimeBusinessException(Throwable cause) {
		super(cause);
	}
}
