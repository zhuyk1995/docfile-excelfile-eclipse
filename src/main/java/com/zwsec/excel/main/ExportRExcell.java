package com.zwsec.excel.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zwsec.excel.utils.ExcelUtils;

public class ExportRExcell {

	public static void exportExcell(HttpServletRequest request, HttpServletResponse response) {
		
		ExcelUtils excelUtils = new ExcelUtils();
		
		List<Map<String, String>> data = new ArrayList<Map<String,String>>();
		
		for(int i=0;i<2;i++) {
			Map map = new HashMap();
			map.put("preAmount", "2.0");
			map.put("plusAmount", "2.0");
			map.put("reduceAmount", "2.0");
			map.put("afterAmount", "2.0");
			map.put("accountsType", "66");
			data.add(map);
		}
		File file = new File("D:\\test.xlsx");
		if(!file.exists()) {
			try {
				file.createNewFile();
				OutputStream outputStream = new FileOutputStream(file);
				excelUtils.createExcel(data, outputStream, request);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		exportExcell(null, null);
	}
}
