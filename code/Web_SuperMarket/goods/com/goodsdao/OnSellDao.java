package com.goodsdao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goodsbean.OnSell;
import com.mvc.connection.basic.ConnectionAware;

public class OnSellDao extends ConnectionAware {
	// ≤È—Ø
	public List<OnSell> onsellList() {
		// System.out.println("onsellList();");
		List<OnSell> list = new ArrayList<OnSell>();
		PreparedStatement ps = null;
		try {
			ps = conn
					.prepareStatement("select serialId, onsell_tab.productId as proId, "
							+ "productName, barCode, count, loseCount, onsell_tab.remarks as remark "
							+ "from onsell_tab inner join product_tab on onsell_tab.productId=product_tab.productId");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OnSell onsell = new OnSell();
				onsell.setSerialId(rs.getInt("serialId"));
				onsell.setProductId(rs.getInt("proId"));
				onsell.setProductName(rs.getString("productName"));
				onsell.setBarCode(rs.getString("barCode"));
				onsell.setCount(rs.getInt("count"));
				onsell.setLoseCount(rs.getInt("loseCount"));
				onsell.setRemarks(rs.getString("remark"));
				list.add(onsell);
				// System.out.println(onsell.getShelfId()+"-"+onsell.getCount()+"-"+onsell.getRemarks()+"-");
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
