�ٷ�����ԭ��j-hi-20110703

��Ӵ�j-hi.jar��ƽ̨hi4springJDBC-20110823�汾������ȡ��xml�����ļ�

�޸�bug
1���û�����sa���ڽ�ɫ��ѯ��Ȩ��Ϊ�û������п����˲����������Ľ�ɫ 
RoleListAction��û�е���getSecurityRoleList()�����ǵ��õ�getRoleList()����������ResourceBindleMethodSecurityInterceptor 
���������j-hi-20110703��j-hi-20110823�ж�δ��� 
2����ɫ�༭���û�����sa�������Ա༭�Լ������Ľ�ɫ 
RoleAction.viewRole()���ж����� 
���������j-hi-20110703��δ�õ����������j-hi-20110823���ѽ�� 
3��dao���ֹ���ʵ��ʱ��������ݹ��ڣ�׷���׳�BusinessException�������ǽ���ӡ��־
org.hi.framework.dao.ibatis.BaseDAOIbatis
org.hi.framework.dao.ibatis3.BaseDAOIbatis
4��Ȩ�޷�Χ�Ĵ���û�������ԣ������û�a������ĳ����ѯ�Ĳ��ż���Χ��������ȴ���Է�����û�bĳ����ѯ�����з�Χ
SelectTag