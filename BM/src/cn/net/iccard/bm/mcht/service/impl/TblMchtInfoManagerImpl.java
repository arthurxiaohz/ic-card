package cn.net.iccard.bm.mcht.service.impl;

import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.impl.ManagerImpl;

import cn.net.iccard.accounting.account.impl.AccountService;
import cn.net.iccard.accounting.account.impl.SimpleAccountOpenRequest;
import cn.net.iccard.bm.accounting.model.AccountCatalog;
import cn.net.iccard.bm.accounting.model.AccountPartyType;
import cn.net.iccard.bm.mcht.model.TblMchtInfo;
import cn.net.iccard.bm.mcht.service.TblMchtInfoManager;

public class TblMchtInfoManagerImpl extends ManagerImpl implements
		TblMchtInfoManager {

	protected void preSaveObject(Object obj) {
		super.preSaveObject(obj);

	}

	protected void postSaveObject(Object obj) {
		super.postSaveObject(obj);

	}

	protected void preRemoveObject(Object obj) {
		super.preRemoveObject(obj);

	}

	protected void postRemoveObject(Object obj) {
		super.postRemoveObject(obj);

	}

	public void saveTblMchtInfo(TblMchtInfo tblMchtInfo) {
		saveObject(tblMchtInfo);
		// ¿ª»§
		AccountService accountService = (AccountService) SpringContextHolder
				.getBean(AccountService.class);
		SimpleAccountOpenRequest simpleAccountOpenRequest = new SimpleAccountOpenRequest();
		simpleAccountOpenRequest
				.setAccountCatalog(AccountCatalog.ACCOUNTCATALOG_VIRTUALACCOUNT);
		simpleAccountOpenRequest
				.setAccountPartyType(AccountPartyType.ACCOUNTPARTYTYPE_MCHT);
		simpleAccountOpenRequest.setAccountParty(tblMchtInfo.getMchtNo());
		simpleAccountOpenRequest.setAccountName(tblMchtInfo.getMchtName());
		// simpleAccountOpenRequest.setAvailableBalance(0);
		// simpleAccountOpenRequest.setRemark();
		accountService.openAccount(simpleAccountOpenRequest);
	}

	public void removeTblMchtInfoById(Integer id) {
		removeObjectById(id);

	}

	public TblMchtInfo getTblMchtInfoById(Integer id) {
		return (TblMchtInfo) getObjectById(id);
	}

	public List<TblMchtInfo> getTblMchtInfoList(PageInfo pageInfo) {
		return super.getList(pageInfo);
	}

	public void saveSecurityTblMchtInfo(TblMchtInfo tblMchtInfo) {
		saveObject(tblMchtInfo);

	}

	public void removeSecurityTblMchtInfoById(Integer id) {
		removeObjectById(id);

	}

	public TblMchtInfo getSecurityTblMchtInfoById(Integer id) {
		return (TblMchtInfo) getObjectById(id);
	}

	public List<TblMchtInfo> getSecurityTblMchtInfoList(PageInfo pageInfo) {
		return super.getList(pageInfo);
	}
}
