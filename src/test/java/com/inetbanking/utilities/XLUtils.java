package com.inetbanking.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
		
		FileInputStream fi = new FileInputStream(xlfile);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
	          XSSFSheet ws = wb.getSheet(xlsheet);
	          
		int rowcount = ws.getLastRowNum();
			
		wb.close();
		fi.close();
		
		return rowcount;	
		
	}
	
	
public static int getCellCount(String xlfile, String xlsheet) throws IOException {
		
		FileInputStream fi = new FileInputStream(xlfile);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
	          XSSFSheet ws = wb.getSheet(xlsheet);
	          
		int cellcount = ws.getLastRowNum();
			
		wb.close();
		fi.close();
		
		return cellcount;	
		
	}
	
	
	
public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
	
	FileInputStream fi = new FileInputStream(xlfile);
	XSSFWorkbook wb = new XSSFWorkbook(fi);
          XSSFSheet ws = wb.getSheet(xlsheet);
          
          XSSFRow row = ws.getRow(rownum);
          XSSFCell cell = row.getCell(colnum);
          String data;
          
          try {
        	DataFormatter formatter = new DataFormatter();
        	String cellData = formatter.formatCellValue(cell);
        	return cellData;	  
        	 }
          catch (Exception e) {
        	  
        	  data="";	  
          }
          wb.close();
          fi.close();
          return data;
          
      	
}

public static String setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data) throws IOException {
	
	FileInputStream fi = new FileInputStream(xlfile);
	XSSFWorkbook wb = new XSSFWorkbook(fi);
          XSSFSheet ws = wb.getSheet(xlsheet);
          
          XSSFRow row = ws.getRow(rownum);
           XSSFCell cell = row.createCell(colnum);
           cell.setCellValue(data);
         FileInputStream fo = new FileInputStream(xlfile);
           
           
          wb.write(fo);
          wb.close();
          fi.close();
          fo.close();
          return data;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
