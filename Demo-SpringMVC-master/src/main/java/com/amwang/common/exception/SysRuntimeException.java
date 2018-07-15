package com.amwang.common.exception;
/**
 * @Description 系统(运行时)异常
 * @author caobin
 * @date 2012-11-19
 * @version 1.0
 */
public class SysRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9190714154628086731L;

	public SysRuntimeException() {
		super();
	}

	public SysRuntimeException(String message) {
		super(message);
	}

	public SysRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public SysRuntimeException(Throwable cause) {
		super(cause);
	}
}
