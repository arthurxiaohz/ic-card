package org.hi.framework.web.struts;

/**
 * 不做任何操作只用于页面导航的<code>Action</code>,该action的<code>execute()</code>
 * 方法永远返回success成功,不会产生任何异常
 * @author 张昊
 * @since 2007-7-25
 *
 */
public class RedirectNothingAction extends BaseAction {

	public String execute() throws Exception {
		return returnCommand();	
	}

}
