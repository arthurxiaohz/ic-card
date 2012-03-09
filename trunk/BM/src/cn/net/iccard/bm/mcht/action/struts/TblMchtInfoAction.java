package cn.net.iccard.bm.mcht.action.struts;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.bm.mcht.action.TblMchtInfoPageInfo;
import cn.net.iccard.bm.mcht.model.TblMchtInfo;
import cn.net.iccard.bm.mcht.service.TblMchtInfoManager;

public class TblMchtInfoAction extends BaseAction {
	private TblMchtInfo tblMchtInfo;
	private TblMchtInfoPageInfo pageInfo;
	private List<TblMchtInfo> tblMchtInfos;
	private String orderIndexs;

	/**
	 * ����/�޸ı����̻�
	 */
	public String saveTblMchtInfo() throws Exception {
		TblMchtInfoManager tblMchtInfoMgr = (TblMchtInfoManager) SpringContextHolder
				.getBean(TblMchtInfo.class);
		if (super.perExecute(tblMchtInfo) != null)
			return returnCommand();

		// �½��̻�ʱ��У���̻����Ƿ��Ѿ�����
		if (null == tblMchtInfo.getId()) {
			List list = tblMchtInfoMgr.getObjects(FilterFactory
					.getSimpleFilter("mchtNo", tblMchtInfo.getMchtNo()));
			if (list != null && list.size() > 0) {
				return returnCommand("ָ���̻����Ѿ�����");
			}
		}

		tblMchtInfoMgr.saveTblMchtInfo(tblMchtInfo);
		super.postExecute(tblMchtInfo);
		return returnCommand();
	}

	/**
	 * ɾ���̻�
	 */
	public String removeTblMchtInfo() throws Exception {
		TblMchtInfoManager tblMchtInfoMgr = (TblMchtInfoManager) SpringContextHolder
				.getBean(TblMchtInfo.class);
		tblMchtInfoMgr.removeTblMchtInfoById(tblMchtInfo.getId());
		return returnCommand();
	}

	/**
	 * ɾ��ָ����ĳЩ�̻�
	 */
	public String removeAllTblMchtInfo() throws Exception {
		TblMchtInfoManager tblMchtInfoMgr = (TblMchtInfoManager) SpringContextHolder
				.getBean(TblMchtInfo.class);
		if (orderIndexs != null && orderIndexs.length() > 0) {
			String[] ids = orderIndexs.split(",");
			for (int i = 0; i < ids.length; i++) {
				if (ids[i].length() > 0) {
					Integer tblMchtInfoid = new Integer(ids[i]);
					tblMchtInfoMgr.removeTblMchtInfoById(tblMchtInfoid);
				}
			}
		}

		return returnCommand();
	}

	/**
	 *�鿴�̻�
	 */
	public String viewTblMchtInfo() throws Exception {
		TblMchtInfoManager tblMchtInfoMgr = (TblMchtInfoManager) SpringContextHolder
				.getBean(TblMchtInfo.class);
		tblMchtInfo = tblMchtInfoMgr.getTblMchtInfoById(tblMchtInfo.getId());
		return returnCommand();
	}

	/**
	 * �̻��б�
	 */
	public String tblMchtInfoList() throws Exception {
		TblMchtInfoManager tblMchtInfoMgr = (TblMchtInfoManager) SpringContextHolder
				.getBean(TblMchtInfo.class);
		pageInfo = pageInfo == null ? new TblMchtInfoPageInfo() : pageInfo;
		PageInfo sarchPageInfo = PageInfoUtil.populate(pageInfo, this);

		tblMchtInfos = tblMchtInfoMgr.getSecurityTblMchtInfoList(sarchPageInfo);

		return returnCommand();
	}

	public TblMchtInfo getTblMchtInfo() {
		return tblMchtInfo;
	}

	public void setTblMchtInfo(TblMchtInfo tblMchtInfo) {
		this.tblMchtInfo = tblMchtInfo;
	}

	public List<TblMchtInfo> getTblMchtInfos() {
		return tblMchtInfos;
	}

	public void setTblMchtInfos(List<TblMchtInfo> tblMchtInfos) {
		this.tblMchtInfos = tblMchtInfos;
	}

	public TblMchtInfoPageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TblMchtInfoPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getOrderIndexs() {
		return orderIndexs;
	}

	public void setOrderIndexs(String orderIndexs) {
		this.orderIndexs = orderIndexs;
	}

}
