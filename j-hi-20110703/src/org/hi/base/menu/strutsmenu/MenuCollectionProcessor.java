package org.hi.base.menu.strutsmenu;

import java.util.Collection;
import java.util.Map;

/**
 * �ڲ˵����ļ��ϴ���������Ϊ���ͽṹÿһ��Ľڵ㶼���ռ���һ���ڵ�ļ��ϣ�����ͨ���ýӿڶ��ռ��ļ���
 * ���й��˻���ӡ��򵥵�˵�ýӿ���һ���ص��ӿڣ�ÿ���ռ��¼��ڵ������ʱ������øýӿڵķ������Ӷ���
 * �����ݸ��пɿ���
 * <p>�ýӿ���<code>MenuFilterProcessor</code>�������ڸýӿ������ռ�����֮����ã�����һ������
 * @author ���
 * @since 2011-0218
 * @see org.hi.base.menu.strutsmenu.MenuFilterProcessor
 *
 */
public interface MenuCollectionProcessor {
	/**
	 * ���ռ����¼��ڵ������֮�󣬻���ø÷�����ʵ�ֶ��ռ�������ݵ��ٴ���
	 * @param coll ��ǰ�ڵ���һ���ڵ�����ݼ���
	 * @param parameters �ò�����һ��Map,��request�����еĲ���ת�������ģ���˿��ܹ�url��̬�Ĵ������ݣ��Ӷ��ڸ÷�����ʹ��
	 * @return ���ش������һ�����϶���
	 */
	public Collection getCollection(Collection coll, Map<String, String> parameters);
}
