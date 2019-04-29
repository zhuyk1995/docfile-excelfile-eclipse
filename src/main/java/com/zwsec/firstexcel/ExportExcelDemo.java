package com.zwsec.firstexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportExcelDemo {

	private HSSFWorkbook workbook = null;

	/**
	 * 显示出导出表的标题
	 */
	private String title;
	/**
	 * 导出表的列名
	 */
	private String[] rowName;

	private List<Object[]> dataList = new ArrayList<Object[]>();

	/**
	 * 构造方法，传入要导出的数据
	 *
	 * @param title
	 * @param rowName
	 * @param dataList
	 */
	public ExportExcelDemo(String title, String[] rowName, List<Object[]> dataList) {
		this.title = title;
		this.rowName = rowName;
		this.dataList = dataList;
	}

	/**
	 * 判断文件的sheet是否存在
	 * 
	 * @param filePath  文件路径
	 * @param sheetName 表格索引名
	 * @return
	 */
	public boolean sheetExist(String filePath, String sheetName) {
		boolean flag = false;
		File file = new File(filePath);
		if (file.exists()) { // 文件存在
			// 创建workbook
			try {
				workbook = new HSSFWorkbook(new FileInputStream(file)); // 添加Worksheet（不添加sheet时生成的xls文件打开时会报错)
				HSSFSheet sheet = workbook.getSheet(sheetName);
				if (sheet != null)
					flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// 文件不存在
			flag = false;
		}
		return flag;
	}

	/**
	 *
	 * (2003 xls后缀 导出)
	 * 
	 * @param TODO
	 * @return void 返回类型
	 * @author xsw
	 * @2016-12-7上午10:44:00
	 */
	public static void createXLS(String importFilePath, String exportFilePath) throws IOException {
		try { // excel模板路径
			File fi = new File(importFilePath);
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fi));// 读取excel模板
			HSSFWorkbook wb = new HSSFWorkbook(fs); // 读取了模板内所有sheet内容
			HSSFSheet sheet = wb.getSheetAt(0); // 如果这行没有了，整个公式都不会有自动计算的效果的
			sheet.setForceFormulaRecalculation(true); // 在相应的单元格进行赋值
			HSSFCell cell = sheet.getRow(11).getCell(6);// 第11行 第6列
			cell.setCellValue(1);
			HSSFCell cell2 = sheet.getRow(11).getCell(7);
			cell2.setCellValue(2);
			sheet.getRow(12).getCell(6).setCellValue(12);
			sheet.getRow(12).getCell(7).setCellValue(12); // 修改模板内容导出新模板
			FileOutputStream out = new FileOutputStream(exportFilePath);
			wb.write(out);
			out.close();
		} catch (Exception e) {
			System.out.println("文件读取错误!");
		}
	}
	/**
    *
    *(2007 xlsx后缀 导出)
    * @param
    * @return void 返回类型
    * @author xsw
    * @2016-12-7上午10:44:30
    */
	public static void createXLSX(String importFilePath, String exportFilePath) throws IOException {
		// excel模板路径
		File fi = new File(importFilePath);
		InputStream in = new FileInputStream(fi); // 读取excel模板
		XSSFWorkbook wb = new XSSFWorkbook(in); // 读取了模板内所有sheet内容
		XSSFSheet sheet = wb.getSheetAt(0); // 如果这行没有了，整个公式都不会有自动计算的效果的
		sheet.setForceFormulaRecalculation(true); // 在相应的单元格进行赋值
		XSSFCell cell = sheet.getRow(11).getCell(6);// 第12行 第7列
		cell.setCellValue(1);
		XSSFCell cell2 = sheet.getRow(11).getCell(7);
		cell2.setCellValue(2);
		sheet.getRow(12).getCell(6).setCellValue(3);
		sheet.getRow(12).getCell(7).setCellValue(4); // 修改模板内容导出新模板
		FileOutputStream out = new FileOutputStream(exportFilePath);
		wb.write(out);
		out.close();
	}
	/**
	 * @param @param file 
	 * @param @return 
	 * @param @throws IOException 
	 * @return
	 * List<String> (excel每行拼接成List中的String) 
	 * @throws 
	 * @Title: readExcel
	 * @Description: TODO(对外提供读取excel 的方法)
	 */
	 public static synchronized void readExcel(String importFilePath,String exportFilePath) throws IOException {
		 File file=new File(importFilePath); 
		 String fileName = file.getName(); //List<String> list = new ArrayList<String>(); //根据其名称获取后缀 
		 String extension = fileName.lastIndexOf(".") == -1 ? "" : fileName .substring(fileName.lastIndexOf(".") + 1);
		 if ("xls".equals(extension)) {
			// read2003Excel(new FileInputStream(file),exportFilePath); 
			 } else if ("xlsx".equals(extension) || "xlsm".equals(extension)) { 
				// read2007Excel(new FileInputStream(file),exportFilePath); 
				 } else if ("tmp".equals(extension)) { 
				//	 read2007Excel(new FileInputStream(file),exportFilePath); 
					 } else { 
						 throw new IOException("不支持的文件类型"); 
						 } 
		 }
	 public static void main(String[] args) throws IOException{ //excle 2007 
		 String importFilePath= "/Users/dataDemo.xlsx"; 
		 String exportFilePath= "/Users/test2.xlsx"; 
		 createXLSX(importFilePath,exportFilePath); 
		// readExcel(importFilePath,exportFilePath); 
		 }
	 }
	 
