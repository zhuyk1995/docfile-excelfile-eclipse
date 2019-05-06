package com.zwsec.twoexcel.createdata;

import java.util.ArrayList;
import java.util.List;

import com.zwsec.twoexcel.pojo.DatEntity;

public class CreateDateEntity {
	
	private static String fileName = "org.src.zwsecode.mapper.userController.java";
	private static String shortName = "parms";

	public List<DatEntity> createDate() {
		List<DatEntity> datEntities = new ArrayList<DatEntity>();
		for (int i = 0; i < 10; i++) {
			DatEntity datEntity = new DatEntity(i, fileName + i, (i + 5) * 2, shortName + i);
			datEntities.add(datEntity);
		}
		return datEntities;
	}
}
