package com.ljy;

public class ItemVO {

	private int idx;
	private String category;
	private String title;
	private String image;
	private int price;
	private String detail;
	private int discount;
	private int stock_count;
	private int hit;
	
	private String pageNum = "1";
	private int listCount = 10;
	private int pagePerBlock = 10;
	

	public ItemVO(int idx, String category, String title, String image, int price, String detail, int discount, int stock_count, int hit) {
		this.idx = idx;
		this.category = category;
		this.title = title;
		this.image = image;
		this.price = price;
		this.detail = detail;
		this.discount = discount;
		this.stock_count = stock_count;
		this.hit = hit;
	}
	public ItemVO() {
		// TODO Auto-generated constructor stub
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getStock_count() {
		return stock_count;
	}

	public void setStock_count(int stock_count) {
		this.stock_count = stock_count;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
	
	public String getPageNum() {
		return pageNum;
	}
	
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	
	public int getListCount() {
		return listCount;
	}
	
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	
	public int getPagePerBlock() {
		return pagePerBlock;
	}
	
	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}
	
}


