package com.zwsec.excel.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public void createExcel(List<Map<String, String>> list, OutputStream output, HttpServletRequest request) {
		Workbook tempWorkbook = null;
		Sheet tempSheet = null;
		int rowIndex = 5;
		Row tempRow = null;
		Cell tempCell = null;
		InputStream inputStream = null;

		try {
			inputStream=ExcelUtils.class.getResourceAsStream("/templates/test.xlsx");
			String path = ExcelUtils.class.getResource("/").getPath() + "/text.xlsx";
			File file = new File(path);
			boolean exists = file.exists();
			System.out.println(exists);
			FileInputStream fileInputStream = new FileInputStream(file);
			inputStream = fileInputStream;

			tempWorkbook = new XSSFWorkbook(inputStream);

			tempSheet = tempWorkbook.getSheetAt(0);

			// 用于统计的变量
			double preAmount = 0;
			double plusAmount = 0;
			double reduceAmount = 0;
			double afterAmount = 0;

			for (int i = 0; i < list.size(); i++) {
				int cellNo = 0;
				tempRow = tempSheet.getRow(0);

				int currentLastRowIndex = tempSheet.getLastRowNum();
				int newRowIndex = currentLastRowIndex + 1;
				XSSFRow newRow = (XSSFRow) tempSheet.createRow(newRowIndex);
				// 开始创建并设置该行每一单元格的信息，该行单元格的索引从 0 开始
				int cellIndex = 0;

				XSSFCell newNameCell = newRow.createCell(cellIndex++, Cell.CELL_TYPE_STRING);
				newNameCell.setCellValue(list.get(i).get("accountsType"));
				XSSFCell newGenderCell = newRow.createCell(cellIndex++, Cell.CELL_TYPE_STRING);
				newNameCell.setCellValue(list.get(i).get("preAmount"));
				XSSFCell newAgeCell = newRow.createCell(cellIndex++, Cell.CELL_TYPE_NUMERIC);
				newAgeCell.setCellValue(list.get(i).get("curpreAmount"));
				XSSFCell newAddressCell = newRow.createCell(cellIndex++, Cell.CELL_TYPE_NUMERIC);
				newAddressCell.setCellValue(list.get(i).get("reduceAmount"));
			}

			// 将内容写入Excel
			tempWorkbook.write(output);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}