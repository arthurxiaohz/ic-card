package org.hi.base.menu.strutsmenu;

import java.util.Map;

import org.hi.framework.dao.Filter;

/**
 * �ýӿ��ǲ˵����Ĺ��˽ӿڣ����ڵ�ǰ�ڵ��ռ��¼��ڵ������֮ǰ,���øýӿڷ���<code>MenuFilterProcessor</code>��
 * ����һ�����������ù��������Զ��Ĳ��뵽���¼��ڵ�������ռ���ȥ����ʵ����������.
 * 
 * <p>�ýӿ���<code>MenuCollectionProcessor</code>�������ڸýӿ������ռ�����֮ǰ���ã�����һ��������
 * @author ���
 * @since 2011-0218
 *
 */
public interface MenuFilterProcessor {
	/**
	 * �÷��������ռ�����֮ǰ����,��һ���ص��ӿڣ����ݷ��صĹ����������ռ�ʱ�Ὣ�ù����Զ������ѯ����֮��ȥ
	 * @param parameters �ò�����һ��Map,��request�����еĲ���ת�������ģ���˿��ܹ�url��̬�Ĵ������ݣ��Ӷ��ڸ÷�����ʹ��
	 * @return ����һ��������
	 */
	public Filter getFilter(Map<String, String> parameters);
}
