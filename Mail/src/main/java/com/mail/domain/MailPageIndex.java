package com.mail.domain;

public class MailPageIndex {
	private long startIndex;
	
	private long endIndex;

	public MailPageIndex(long startIndex, long endIndex) {
		super();
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}
	
	
	public long getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(long startIndex) {
		this.startIndex = startIndex;
	}

	
	public long getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(long endIndex) {
		this.endIndex = endIndex;
	}
	
	public static MailPageIndex getPageIndex(long viewpagecount,int currentPage,long totalpage){
		long startpage=currentPage-(viewpagecount%2==0?viewpagecount/2-1:viewpagecount/2);
		long endpage=currentPage+viewpagecount/2;
		if(startpage<1){
			startpage=1;
			if(totalpage>=viewpagecount)
				endpage=viewpagecount;
			else
				endpage=totalpage;
		}
		if(endpage>totalpage){
			endpage=totalpage;
			if((endpage-viewpagecount)>0)
				startpage=endpage-viewpagecount+1;
			else
				startpage=1;
		}
		return new MailPageIndex(startpage,endpage);
	}
}
