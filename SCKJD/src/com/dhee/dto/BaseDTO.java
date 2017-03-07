package com.dhee.dto;
/**
 * ���ر�BASE�����ݴ������
 * @author wuzhihui
 */
public class BaseDTO {
	//���ر���������ر��
	private int bid;
	//��������
	private String bname;
	//���س�������
	private String bdate;
	//���ؼ��
	private String bintroduction;
	//�����������
	private int tid;
	//����ͼƬ·��
	private String bimagepath;
	//����ͼƬ1
	private String bimage1;
	//����ͼƬ2
	private String bimage2;
/**
 * �޲ι��췽��
 */
	public BaseDTO(){
		super();
	}
/**
 * �вι��췽��
 */
	public BaseDTO(int bid , String bname , String bdate , String bintroduction , int tid , 
			String bimagepath , String bimage1 , String bimage2){
		this.bid = bid;
		this.bname = bname;
		this.bdate = bdate;
		this.bintroduction = bintroduction;
		this.tid = tid;
		this.bimagepath = bimagepath;
		this.bimage1 = bimage1;
		this.bimage2 = bimage2;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getBintroduction() {
		return bintroduction;
	}
	public void setBintroduction(String bintroduction) {
		this.bintroduction = bintroduction;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getBimagepath() {
		return bimagepath;
	}
	public void setBimagepath(String bimagepath) {
		this.bimagepath = bimagepath;
	}
	public String getBimage1() {
		return bimage1;
	}
	public void setBimage1(String bimage1) {
		this.bimage1 = bimage1;
	}
	public String getBimage2() {
		return bimage2;
	}
	public void setBimage2(String bimage2) {
		this.bimage2 = bimage2;
	}
}