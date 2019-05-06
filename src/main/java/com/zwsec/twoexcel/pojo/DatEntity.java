package com.zwsec.twoexcel.pojo;

import java.io.Serializable;

/**
 * Êý¾ÝÀà
 * @author ZUOSHICHAO
 *
 */
public class DatEntity implements Serializable{
	
	private static final long serialVersionUID = -1089433947800888843L;

	private Integer rowNum;
	
	private String fileName;
	
	private String line;
	
	private String shortName;

	public Integer getRowNum() {
		return rowNum;
	}

	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public DatEntity(Integer rowNum, String fileName, int line, String shortName) {
		super();
		this.rowNum = rowNum;
		this.fileName = fileName;
		this.line = String.valueOf(line);
		this.shortName = shortName;
	}
	
	
}
