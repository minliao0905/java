package com.educoder.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
	private String orderId;

	private String userId;

	private Date orderTime;

	private String addressId;

	private String goodsId;

	private String goodsName;

	private String goodsImg;

	private BigDecimal goodsPrice;

	private String goodsCheck;

	/**
	 * @return the goodsName
	 */
	public String getGoodsName() {
		return goodsName;
	}

	/**
	 * @param goodsName the goodsName to set
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	/**
	 * @return the goodsImg
	 */
	public String getGoodsImg() {
		return goodsImg;
	}

	/**
	 * @param goodsImg the goodsImg to set
	 */
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}

	/**
	 * @return the goodsPrice
	 */
	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	/**
	 * @param goodsPrice the goodsPrice to set
	 */
	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	private String userName;
	private String address;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the goodsId
	 */
	public String getGoodsId() {
		return goodsId;
	}

	/**
	 * @param goodsId the goodsId to set
	 */
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	/**
	 * @return the buyNum
	 */
	public Integer getBuyNum() {
		return buyNum;
	}

	/**
	 * @param buyNum the buyNum to set
	 */
	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}

	private Integer buyNum;

	public Order() {
	}

	/**
	 * @param string
	 * @param userId2
	 * @param date
	 * @param addressId2
	 */
	public Order(String string, String userId2, Date date, String addressId2) {
		this.addressId = addressId2;
		this.orderId = string;
		this.userId = userId2;
		this.orderTime = date;
	}

	/**
	 * @return the addressId
	 */
	public String getAddressId() {
		return addressId;
	}

	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId == null ? null : orderId.trim();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userid=" + userId + ", orderTime=" + orderTime + ", addressId="
				+ addressId + ", goodsId=" + goodsId + ", goodsName=" + goodsName + ",goodsImg=" + goodsImg
				+ ",goodsPrice=" + goodsPrice + "]";
	}

	public String getGoodsCheck() {
		return goodsCheck;
	}

	public void setGoodsCheck(String goodsCheck) {
		this.goodsCheck = goodsCheck;
	}
}