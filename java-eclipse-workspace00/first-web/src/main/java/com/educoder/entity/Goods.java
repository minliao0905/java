package com.educoder.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Goods {

	private String goodsId; // 商品guid

	private String goodsName; // 商品名

	private String goodsImg; // 展示于主页的图

	private BigDecimal goodsPrice; // 价格

	private Integer goodsNum; // 库存数量

	private Integer salesNum; // 销售数

	private String goodsSize; // 商品规格

	private String goodsFrom; // 商品产地

	private String goodsTime; // 保质期

	private String goodsSaveCondition; // 存储条件

	private String goodsDescribe; // 商品描述介绍

	private String goodsExplain; // 对商品简短说明

	private String goodsClass; // 所属类别

	private BigDecimal goodsDiscount; // 折扣

	private Date discountStartTime; // 优惠起始时间

	private Date discountEndTime; // 优惠截止时间

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

	public String getGoodsImg() {
		return goodsImg;
	}

	/**
	 * @param goodsName the goodsName to set
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

	/**
	 * @return the goodsNum
	 */
	public Integer getGoodsNum() {
		return goodsNum;
	}

	/**
	 * @param goodsNum the goodsNum to set
	 */
	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	/**
	 * @return the salesNum
	 */
	public Integer getSalesNum() {
		return salesNum;
	}

	/**
	 * @param salesNum the salesNum to set
	 */
	public void setSalesNum(Integer salesNum) {
		this.salesNum = salesNum;
	}

	/**
	 * @return the goodsSize
	 */
	public String getGoodsSize() {
		return goodsSize;
	}

	/**
	 * @param goodsSize the goodsSize to set
	 */
	public void setGoodsSize(String goodsSize) {
		this.goodsSize = goodsSize;
	}

	/**
	 * @return the goodsFrom
	 */
	public String getGoodsFrom() {
		return goodsFrom;
	}

	/**
	 * @param goodsFrom the goodsFrom to set
	 */
	public void setGoodsFrom(String goodsFrom) {
		this.goodsFrom = goodsFrom;
	}

	/**
	 * @return the goodsTime
	 */
	public String getGoodsTime() {
		return goodsTime;
	}

	/**
	 * @param goodsTime the goodsTime to set
	 */
	public void setGoodsTime(String goodsTime) {
		this.goodsTime = goodsTime;
	}

	/**
	 * @return the goodsSaveCondition
	 */
	public String getGoodsSaveCondition() {
		return goodsSaveCondition;
	}

	/**
	 * @param goodsSaveCondition the goodsSaveCondition to set
	 */
	public void setGoodsSaveCondition(String goodsSaveCondition) {
		this.goodsSaveCondition = goodsSaveCondition;
	}

	/**
	 * @return the goodsDescribe
	 */
	public String getGoodsDescribe() {
		return goodsDescribe;
	}

	/**
	 * @param goodsDescribe the goodsDescribe to set
	 */
	public void setGoodsDescribe(String goodsDescribe) {
		this.goodsDescribe = goodsDescribe;
	}

	/**
	 * @return the goodsExplain
	 */
	public String getGoodsExplain() {
		return goodsExplain;
	}

	/**
	 * @param goodsExplain the goodsExplain to set
	 */
	public void setGoodsExplain(String goodsExplain) {
		this.goodsExplain = goodsExplain;
	}

	/**
	 * @return the goodsClass
	 */
	public String getGoodsClass() {
		return goodsClass;
	}

	/**
	 * @param goodsClass the goodsClass to set
	 */
	public void setGoodsClass(String goodsClass) {
		this.goodsClass = goodsClass;
	}

	/**
	 * @return the goodsDiscount
	 */
	public BigDecimal getGoodsDiscount() {
		return goodsDiscount;
	}

	/**
	 * @param goodsDiscount the goodsDiscount to set
	 */
	public void setGoodsDiscount(BigDecimal goodsDiscount) {
		this.goodsDiscount = goodsDiscount;
	}

	/**
	 * @return the discountStartTime
	 */
	public Date getDiscountStartTime() {
		return discountStartTime;
	}

	/**
	 * @param discountStartTime the discountStartTime to set
	 */
	public void setDiscountStartTime(Date discountStartTime) {
		this.discountStartTime = discountStartTime;
	}

	/**
	 * @return the discountEndTime
	 */
	public Date getDiscountEndTime() {
		return discountEndTime;
	}

	/**
	 * @param discountEndTime the discountEndTime to set
	 */
	public void setDiscountEndTime(Date discountEndTime) {
		this.discountEndTime = discountEndTime;
	}

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice + ", goodsNum="
				+ goodsNum + ", salesNum=" + salesNum + ", goodsSize=" + goodsSize + ", goodsFrom=" + goodsFrom
				+ ", goodsTime=" + goodsTime + ", goodsSaveCondition=" + goodsSaveCondition + ", goodsDescribe="
				+ goodsDescribe + ", goodsExplain=" + goodsExplain + ", goodsClass=" + goodsClass + ", goodsDiscount="
				+ goodsDiscount + ", discountStartTime=" + discountStartTime + ", discountEndTime=" + discountEndTime
				+ "]";
	}

}