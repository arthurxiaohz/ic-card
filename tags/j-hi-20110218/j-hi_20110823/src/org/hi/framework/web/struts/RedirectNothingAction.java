package org.hi.framework.web.struts;

/**
 * �����κβ���ֻ����ҳ�浼����<code>Action</code>,��action��<code>execute()</code>
 * ������Զ����success�ɹ�,��������κ��쳣
 * @author ���
 * @since 2007-7-25
 *
 */
public class RedirectNothingAction extends BaseAction {

	public String execute() throws Exception {
		return returnCommand();	
	}

}
