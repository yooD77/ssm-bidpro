package com.xxd.serviceimpl;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.xxd.mapper.GoodsMapper_xxd;
import com.xxd.pojo.Goods_xxd;
import com.xxd.service.GoodsService_xxd;
import com.xxd.util.Page_xxd;

/**
 * 
 *@author xiaoxiaodan 
 *@Description 拍品业务逻辑层实现
 *
 */
@Service
public class GoodsServiceImpl_xxd implements GoodsService_xxd{
	@Autowired
	GoodsMapper_xxd goodsmapper_xxd;
	
	public List<Goods_xxd> getGoodsByOnePage(Page_xxd page_xxd) {
		return goodsmapper_xxd.getGoodsByOnePage(page_xxd);
	}

	
	public List<Goods_xxd> getGoods() {
		return goodsmapper_xxd.getAllGoods();
	}
	

	public List<Goods_xxd> getGoodsByUserId(int UserId_xxd) {
		// TODO Auto-generated method stub
		return goodsmapper_xxd.getGoodsByUserId(UserId_xxd);
	}

	
	public Goods_xxd getGoodsById(int GoodsId_xxd) {
		return goodsmapper_xxd.getGoodsByGoodsId(GoodsId_xxd);
	}

	
	public void insert(Goods_xxd goods_xxd) {
		goodsmapper_xxd.insert(goods_xxd);
	}

	
	public void delete(int GoodsId_xxd) {
		goodsmapper_xxd.delete(GoodsId_xxd);
	}

	
	public void update(Goods_xxd goods_xxd) {
		goodsmapper_xxd.update(goods_xxd);
	}

	
	public int total() {
		return goodsmapper_xxd.total();
	}

	public HSSFWorkbook export(List<Goods_xxd> list) {
		String[] excelHeader = { "商品编号", "商品名称", "商品起拍价","商品竞拍开始时间","商品竞拍结束时间","商品图片地址","商品描述"};
		 HSSFWorkbook wb = new HSSFWorkbook();
		 HSSFSheet sheet = wb.createSheet("Auction");  
	     HSSFRow row = sheet.createRow((int) 0);  
	     HSSFCellStyle style = wb.createCellStyle();  
	     //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
	  
	     for (int i = 0; i < excelHeader.length; i++) {
	    	 HSSFCell cell = row.createCell(i);  
	         cell.setCellValue(excelHeader[i]);  
	         cell.setCellStyle(style);  
	         sheet.autoSizeColumn(i);  
	         //sheet.SetColumnWidth(i, 100 * 256);  
	     }  
	  
	     for (int i = 0; i < list.size(); i++) {
	    	 row = sheet.createRow(i + 1);  
	         Goods_xxd goods_xxd = list.get(i);  
	         row.createCell(0).setCellValue(goods_xxd.getGoodsId_xxd());  
	         row.createCell(1).setCellValue(goods_xxd.getGoodsName_xxd());  
	         row.createCell(2).setCellValue(goods_xxd.getGoodsPrice_xxd());
	         row.createCell(3).setCellValue(goods_xxd.getGoodsStartTime_xxd());  
	         row.createCell(4).setCellValue(goods_xxd.getGoodsEndTime_xxd());  
	         row.createCell(5).setCellValue(goods_xxd.getGoodsPic_xxd());
	         row.createCell(6).setCellValue(goods_xxd.getGoodsDesc_xxd());
	     }  
	     return wb;  
	}


	@Override
	public List<Goods_xxd> getGoodsByInput(String GoodsName_xxd) {
		return goodsmapper_xxd.getGoodsByInput(GoodsName_xxd);
	}


	


	

}
