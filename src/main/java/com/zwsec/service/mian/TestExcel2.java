//package com.zwsec.service.mian;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//
//import com.zwsec.service.entity.TestData;
//import com.zwsec.service.util.ExcelUtils;
//import com.zwsec.service.util.SheetData;
//
//public class TestExcel2 {
//
//	public static void main(String[] args) {
//		
//		// 获取模板
//		String model = "test.xls";
//		File f = new File("e:/test.xls");
//
//		SheetData[] sds = new SheetData[5];
//
//		// 创建5个数据sheet
//		for (int i = 0; i < 5; i++) {
//			SheetData sd = new SheetData("测试" + i);
//			sd.put("name", "张三" + i);
//			sd.put("age", 13);
//
//			// 每个sheet页加入100条测试数据
//			// 注意这里可以加入pojo也可以直接使用map,理论上map在这里效率更高一些
//			for (int j = 0; j < 100; j++) {
//				TestData td = new TestData(j, j * -1, "t" + j);
//				sd.addData(td);
//				;
//			}
//			sds[i] = sd;
//		}
//		try {
//			ExcelUtils.writeData(model, new FileOutputStream(f), sds);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//
//	}
//}
