package com.example.model;

import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FileData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fid;
	
	private String fname;
	
	private byte []fdata;
	
	private LocalDateTime uploadData;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public byte[] getFdata() {
		return fdata;
	}

	public void setFdata(byte[] fdata) {
		this.fdata = fdata;
	}

	public LocalDateTime getUploadData() {
		return uploadData;
	}

	public void setUploadData(LocalDateTime uploadData) {
		this.uploadData = uploadData;
	}

	@Override
	public String toString() {
		return "FileData [fid=" + fid + ", fname=" + fname + ", fdata=" + Arrays.toString(fdata) + ", uploadData="
				+ uploadData + "]";
	}
	
	
	
	
	
	
	
	

}
