package dto;

public class ManagementDTO {

	private int item_id;
	private String item_name;
	private int item_stock;
	private int item_price;
	private int farmer_id;
	private String farmer_name;

	public int getItem_id() {
		return item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public int getItem_stock() {
		return item_stock;
	}

	public int getItem_price() {
		return item_price;
	}

	public int getFarmer_id() {
		return farmer_id;
	}

	public String getFarmer_name() {
		return farmer_name;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public void setItem_stock(int item_stock) {
		this.item_stock = item_stock;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public void setFarmer_id(int farmer_id) {
		this.farmer_id = farmer_id;
	}

	public void setFarmer_name(String farmer_name) {
		this.farmer_name = farmer_name;
	}
}
