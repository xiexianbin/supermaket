package com.goodsdao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goodsbean.UpGoods;
import com.goodsbean.UpGoods1;
import com.mvc.connection.basic.ConnectionAware;

public class UpGoodsDao extends ConnectionAware {
	// upgoods查询
	public List<UpGoods> upgoodsList() {
		List<UpGoods> list = new ArrayList<UpGoods>();
		PreparedStatement ps;
		try {
			ps = conn
					.prepareStatement("select serialId, purch_tab.purchId, product_tab.productId as prodId, "
							+ "productName, upgoods_tab.employeeId as empId, employeeName, shelf_tab.shelfId shId,"
							+ " shelfLocation, upCount, upTime, upgoods_tab.remarks as marks "
							+ "from upgoods_tab, purch_tab, product_tab, employee_tab, shelf_tab "
							+ "where upgoods_tab.purchId=purch_tab.purchId "
							+ "and purch_tab.productId=product_tab.productId "
							+ "and employee_tab.employeeId=upgoods_tab.employeeId "
							+ "and shelf_tab.shelfId=upgoods_tab.shelfId "
							+ "order by serialId desc");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UpGoods upgoods = new UpGoods();
				upgoods.setSerialId(rs.getInt("serialId"));
				upgoods.setPurchId(rs.getInt("purchId"));
				int proId = rs.getInt("prodId");
				upgoods.setProductId(proId);
				upgoods.setProductName(rs.getString("productName"));
				upgoods.setEmployeeId(rs.getInt("empId"));
				upgoods.setEmployeeName(rs.getString("employeeName"));
				upgoods.setShelfId(rs.getInt("shId"));
				upgoods.setShelfLocation(rs.getString("shelfLocation"));
				upgoods.setUpCount(rs.getInt("upcount"));
				upgoods.setUpTime(rs.getString("uptime"));
				upgoods.setRemarks(rs.getString("marks"));
				list.add(upgoods);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// upgoods查看详情
	public List<UpGoods1> upgoodsList1(String serialid) {
		List<UpGoods1> list = new ArrayList<UpGoods1>();
		PreparedStatement ps;
		try {
			ps = conn
					.prepareStatement("select product_tab.productId,productName,producer,inPrice,purchCount,purch_tab.productTime,shelfId,upCount "
							+ "from product_tab,purch_tab,upgoods_tab "
							+ "where product_tab.productId=purch_tab.productId and upgoods_tab.purchId=purch_tab.purchId and upgoods_tab.serialid=?");

			ps.setInt(1, Integer.parseInt(serialid));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UpGoods1 upgoods1 = new UpGoods1();

				upgoods1.setProductId(rs.getInt("productId"));
				upgoods1.setProductName(rs.getString("productName"));
				upgoods1.setProducer(rs.getString("producer"));
				upgoods1.setInPrice(rs.getFloat("inPrice"));
				upgoods1.setPurchCount(rs.getInt("purchCount"));
				upgoods1.setProductTime(rs.getString("productTime"));
				upgoods1.setShelfId(rs.getInt("shelfId"));
				upgoods1.setUpCount(rs.getInt("upcount"));
				list.add(upgoods1);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// ugoods插入：
	public int upgoodsInsert(UpGoods upgoods) {
		int row = 0;
		try {
			PreparedStatement ps = conn
					.prepareStatement("insert into "
							+ "upgoods_tab(purchId, employeeId,shelfId,upCount,upTime,remarks)"
							+ "values(?,?,?,?,?,?)");
			ps.setInt(1, upgoods.getPurchId());
			// ps.setInt(2, -1);
			ps.setInt(2, upgoods.getEmployeeId());
			ps.setInt(3, upgoods.getShelfId());
			ps.setInt(4, upgoods.getUpCount());
			ps.setString(5, upgoods.getUpTime());
			ps.setString(6, upgoods.getRemarks());
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	// 流水号自动添加
	public int selectMaxSerialId() {
		int row = 0;
		PreparedStatement ps = null;
		String sql = "select max(serialId) as ID from upgoods_tab";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				row = rs.getInt("ID");
				return row;
			} else {
				// closeConn(conn, rs, ps);
				return row;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// closeConn(conn, ps);
			return -1;
		}
	}

	// 下拉框（負責人编号）
	public List<String> selectAllemployee() {
		List<String> list = new ArrayList<String>();
		PreparedStatement ps = null;
		String sql = "select employeeId,employeeName from employee_tab";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id = String.valueOf(rs.getInt("employeeId"));
				String name = rs.getString("employeeName");
				String mess = id + "-" + name;
				list.add(mess);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

	//
	public List<String> selectAllshelf() {
		List<String> list = new ArrayList<String>();
		PreparedStatement ps = null;
		String sql = "select shelfId, shelfLocation from shelf_tab";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id = String.valueOf(rs.getInt("shelfId"));
				String location = rs.getString("shelfLocation");
				String mess = id + "-" + location;
				list.add(mess);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

	// 商品上架时的商品信息：主要为商品基本信息、如保质期等
	public List<String> selectAllpurch() {

		List<String> list = new ArrayList<String>();
		PreparedStatement ps = null;
		String sql = "select purch_tab.purchId as purId, purch_tab.productId as proId, "
				+ "productName, remainNum, productTime, expireTime, companyId "
				+ "from (store_tab inner join purch_tab on store_tab.purchId=purch_tab.purchId) "
				+ "inner join product_tab on product_tab.productId=purch_tab.productId";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int purId = rs.getInt("purId");
				String proId = rs.getString("proId");
				String productName = rs.getString("productName");
				String mess = purId + "-" + productName;
				list.add(mess);
				// System.out.println(mess);100015-巧克力
			}
			// closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
			// closeConn(conn, ps);
			return null;
		}
		return list;
	}

	// up更新：
	public int upgoodsUpdate(UpGoods upgoods) {
		int row = 0;
		try {
			PreparedStatement ps = conn
					.prepareStatement("update upgoods_tab set purchId=?, employeeId=?,shelfId=?,upCount=?, upTime=?, remarks=? where serialId=?");
			ps.setInt(1, upgoods.getPurchId());
			ps.setInt(2, upgoods.getEmployeeId());
			ps.setInt(3, upgoods.getShelfId());
			ps.setInt(4, upgoods.getUpCount());
			ps.setString(5, upgoods.getUpTime());
			ps.setString(6, upgoods.getRemarks());
			ps.setInt(7, upgoods.getSerialId());
			// System.out.println("remark======"+upgoods.getRemarks());
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	public UpGoods findUpgoods(int id) {
		UpGoods upgoods = new UpGoods();
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from upgoods_tab where serialId=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				upgoods.setSerialId(id);
				upgoods.setPurchId(rs.getInt("purchId"));
				upgoods.setEmployeeId(rs.getInt("employeeId"));
				upgoods.setShelfId(rs.getInt("shelfId"));
				upgoods.setUpCount(rs.getInt("upCount"));
				upgoods.setUpTime(rs.getString("upTime"));
				upgoods.setRemarks(rs.getString("remarks"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return upgoods;

	}

	// 获取在售商品信息（采购流水号-商品编号）
	public List<String> selectAllOnsell() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		PreparedStatement ps = null;
		String sql = "select purch_tab.purchId as purId, productName from purch_tab, product_tab, onsell_tab "
				+ "where purch_tab.productId=product_tab.productId "
				+ "and onsell_tab.purchId=purch_tab.purchId";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id = String.valueOf(rs.getInt("purId"));
				String name = rs.getString("productName");
				String mess = id + "-" + name;
				// System.out.println(mess);
				list.add(mess);
			}
			// closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
			// closeConn(conn, ps);
			return null;
		}
		return list;
	}

}
