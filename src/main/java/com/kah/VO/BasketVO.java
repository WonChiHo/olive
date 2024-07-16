package com.kah.VO;

public class BasketVO {
	int idx = 0;
	int user_idx = 0; 
	String category= "";
	int item_idx  = 0;
	int count=0;
	int price = 0;
	int sale = 0;
	int ApplySalePrice = 0;
	
	int stock_count = 0;

	public BasketVO() {
	
	}
	
	//여기서 부터 새로 추가함
	public int getStock_count() {
		return stock_count;
	}

	public void setStock_count(int stock_count) {
		this.stock_count = stock_count;
	}
	//여기까지
	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getUser_idx() {
		return user_idx;
	}

	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	

	public int getItem_idx() {
		return item_idx;
	}

	public void setItem_idx(int item_idx) {
		this.item_idx = item_idx;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public int getApplySalePrice() {
		return ApplySalePrice;
	}

	public void setApplySalePrice(int applySalePrice) {
		ApplySalePrice = applySalePrice;
	}

	@Override
	public String toString() {
		return "BasketVO [idx=" + idx + ", user_idx=" + user_idx + ", category=" + category + ", item_idx ="
				+ item_idx  + ", count=" + count + ", price=" + price + ", sale=" + sale + ", ApplySalePrice="
				+ ApplySalePrice + "]";
	}
	
	

}
