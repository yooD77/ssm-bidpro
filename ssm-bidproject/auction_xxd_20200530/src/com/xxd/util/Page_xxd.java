package com.xxd.util;

public class Page_xxd {
	int start = 0;
	int count = 10;
	int curPage = 1;
	int maxPage = 0;
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
		start = (curPage - 1) * count;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	
	public void caculatemaxPage(int total){
		if(total % count == 0)
			maxPage = total / count;
		else
			maxPage = total / count + 1;
	}
	public void caculateStart(){
		start = (curPage - 1) * count;
	}

}
