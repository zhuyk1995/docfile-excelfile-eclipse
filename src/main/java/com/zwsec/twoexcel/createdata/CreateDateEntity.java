package com.zwsec.twoexcel.createdata;

import java.util.ArrayList;
import java.util.List;

import com.zwsec.twoexcel.pojo.DatEntity;

/**
 * 造数据功能类
 * 
 * @author ZUOSHICHAO
 *
 */
public class CreateDateEntity {

	private static String fileName = "org.src.zwsecode.mapper.userController.java";
	private static String shortName = "parms";

	public List<DatEntity> createDate(int i) {
		List<DatEntity> datEntities = new ArrayList<DatEntity>();
		for ( ; i < 10; i++) {
			DatEntity datEntity = new DatEntity(i, fileName + i, (i + 5) * 2, shortName + i);
			datEntities.add(datEntity);
		}
		return datEntities;
	}
}
