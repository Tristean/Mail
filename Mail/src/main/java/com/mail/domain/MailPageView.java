package com.mail.domain;

import java.util.List;

import com.mail.service.mail.MailConstant;

public class MailPageView<T> {
	private List<T>records;
	private MailPageIndex pageIndex;
	private long totalpage=1;
	private long totalrecord;
	private int maxresult=10;
	private int currentpage=1;
	private int pagecount=MailConstant.PAGE_COUNT;
	private int newMailTotal;
	private int unreadMailTotal;
	
	public int getFirstResult(){
		return (this.currentpage-1)*this.maxresult;
	}
	
	public int getPageCount(){
		return pagecount;
	}
	
	public MailPageView(int maxresult,int currentpage){
		this.maxresult=maxresult;
		this.currentpage=currentpage;
	}
	
	public void setResult(QueryResult<T>qr){
		setTotalrecord(qr.getTotalRecord());
		setRecords(qr.getResultList());
	}
	public void setResult(List<T>list,long totalRecord){
		setTotalrecord(totalRecord);
		setRecords(list);
	}
	
	public long getTotalrecord(){
		return totalrecord;
	}
	public void setTotalrecord(long totalrecord){
		this.totalrecord=totalrecord;
		setTotalPage(this.totalrecord%this.maxresult==0?this.totalrecord/this.maxresult:
					this.totalrecord/this.maxresult+1);
	}
	public List<T> getRecords(){
		return records;
	}
	public void setRecords(List<T>records){
		this.records=records;
	}
	
	public MailPageIndex getPageIndex(){
		return pageIndex;
	}
	
	public long getTotalPage(){
		return totalpage;
	}
	public void setTotalPage(long totalpage){
		this.totalpage=totalpage;
		this.pageIndex=MailPageIndex.getPageIndex(pagecount, currentpage, totalpage);
	}
	public int getMaxresult(){
		return maxresult;
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public int getNewMailTotal() {
		return newMailTotal;
	}
	public void setNewMailTotal(int newMailTotal) {
		this.newMailTotal = newMailTotal;
	}

	public int getUnreadMailTotal() {
		return unreadMailTotal;
	}
	public void setUnreadMailTotal(int unreadMailTotal) {
		this.unreadMailTotal = unreadMailTotal;
	}
	
	public void setNewAndUnreadMail(int newMailTotal,int unreadMailTotal){
		setNewMailTotal(newMailTotal);
		setUnreadMailTotal(unreadMailTotal);
	}
	
}
