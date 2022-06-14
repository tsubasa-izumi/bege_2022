package dto;

public class BuyHistoryDTO {

	private int buy_id;
	private int item_id;
	private String item_name;
	private int quantity;
	private int item_stock;
	private int item_price;
	private int total_price;
	private int farmer_id;
	private String farmer_name;
	private int buy_date;
	private int user_id;
	private String user_name;

	public int getBuy_id() {
		return buy_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getItem_stock() {
		return item_stock;
	}

	public int getItem_price() {
		return item_price;
	}

	public int getTotal_price() {
		return total_price;
	}

	public int getFarmer_id() {
		return farmer_id;
	}

	public String getFarmer_name() {
		return farmer_name;
	}

	public int getBuy_date() {
		return buy_date;
	}

	public int getUser_id() {
		return user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setBuy_id(int buy_id) {
		this.buy_id = buy_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setItem_stock(int item_stock) {
		this.item_stock = item_stock;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public void setFarmer_id(int farmer_id) {
		this.farmer_id = farmer_id;
	}

	public void setFarmer_name(String farmer_name) {
		this.farmer_name = farmer_name;
	}

	public void setBuy_date(int buy_date) {
		this.buy_date = buy_date;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

}
