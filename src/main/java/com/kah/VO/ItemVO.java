package com.kah.VO;

public class ItemVO {

	int idx = 0;
	String category = null;
	String title = null;
	String image = null;
	int price = 0;
	String detail = null;
	int discount = 0;
	int stock_count = 0;
	int hit = 0;

	// 페이징 관련

	private String pageNum = "1";
	/** 검색 항목 */
	private String searchType = "";
	/** 검색어 */
	private String searchText = "";
	/** 목록 페이지 게시물 노출 수 */
	private int listCount = 9;
	/** 목록 페이지 네비게이터 블록 수 */
	private int pagePerBlock = 10;
	
	
	
	
	
	public ItemVO() {

	} // 기본생성자 END
	
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

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
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


	@Override
	public String toString() {
		return "Item [idx=" + idx + ", category=" + category + ", title=" + title + ", price=" + price + ", detail="
				+ detail + ", discount=" + discount + ", stock_count=" + stock_count + ", hit=" + hit + "]";
	}
}