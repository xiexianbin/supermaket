package com.goodsType;

public class GoodsTypeBean {

//	商品类别表（productType_tab)					
//	字段	字段类型	长度	是否为空	是否主键	说明
//	productTypeId	int		否	是	商品类别编号
//	productTypeName	varchar	50	否		商品类别名称
//	remarks	Text				备注

	
	
	private int productTypeId;
	private String productTypeName;
	private String remarks;
	public int getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}
	public String getProductTypeName() {
		return productTypeName;
	}
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
