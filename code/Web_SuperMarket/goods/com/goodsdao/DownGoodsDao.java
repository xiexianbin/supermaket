package com.goodsdao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goodsbean.DownGoods;
import com.goodsbean.UpGoods1;
import com.mvc.connection.basic.ConnectionAware;

public class DownGoodsDao extends ConnectionAware{
	//查询
		public List<DownGoods> downgoodsList(){
			List<DownGoods> list=new ArrayList<DownGoods>();
				PreparedStatement ps;
				try {
					ps = conn.prepareStatement("select serialId, product_tab.productId as proId, " +
							"productName, employee_tab.employeeId as empId, " +
							"downCount, downgoods_tab.shelfId,downTime, downgoods_tab.remarks as marks " +
							"from downgoods_tab, employee_tab, product_tab, purch_tab " +
							"where downgoods_tab.employeeId=employee_tab.employeeId " +
							"and downgoods_tab.purchId=purch_tab.purchId and product_tab.productId=purch_tab.productId");
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
						DownGoods downgoods=new DownGoods();
						downgoods.setSerialId(rs.getInt("serialId"));
						downgoods.setProductId(rs.getInt("proId"));
						downgoods.setEmployeeId(rs.getInt("empId"));
						downgoods.setProductName(rs.getString("productName"));
						downgoods.setDownCount(rs.getInt("downCount"));
						downgoods.setShelfId(rs.getInt("shelfId"));
						downgoods.setDownTime(rs.getString("downtime"));
						downgoods.setRemarks(rs.getString("marks"));
						list.add(downgoods);
//                     	System.out.println(downgoods.getSerialId()+"-"+downgoods.getPurchId()+"-"+downgoods.getDownCount()+"-");
					}
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			return list;
		}
		
		//查看详情
		public  List<UpGoods1> downgoodsList1(String serialid){
			UpGoodsDao up1=new  UpGoodsDao();
			List<UpGoods1> list=up1.upgoodsList1(serialid);
			return list;
		}
		
		
		//插入新的下架记录
		public int downgoodsInsert(DownGoods downgoods){
			int row=0;
			try {
				PreparedStatement ps=conn.prepareStatement("insert into " +
						"downgoods_tab(purchId, employeeId, downCount, downTime, remarks)" +
						"values(?, ?, ?, ?, ?)");
				ps.setInt(1, downgoods.getPurchId());
				ps.setInt(2, downgoods.getEmployeeId());
				ps.setInt(3, downgoods.getDownCount());
//				ps.setInt(4, downgoods.getShelfId());
				ps.setString(4, downgoods.getDownTime());
				ps.setString(5, downgoods.getRemarks());
				row=ps.executeUpdate();
//				System.out.println(row);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return row;
		}
		
		//流水号自动添加
		public int selectMaxSerialId1(){
			int row = 0;
			PreparedStatement ps = null;
			String sql = "select max(serialId) as ID from downgoods_tab";		
			try {
				ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					row = rs.getInt("ID");
//					closeConn(conn, rs, ps);
					return row;
				}else{
//					closeConn(conn, rs, ps);
					return row;
				}
			} catch (SQLException e) {
				e.printStackTrace();
//				closeConn(conn, ps);
				return -1;
			}
		}
		
		public List<String> selectAllshelf1(){
			UpGoodsDao up=new UpGoodsDao();
			List<String> list=up.selectAllshelf();
			return list;
		}
		
		//更新：
		public int downgoodsUpdate(DownGoods downgoods){
			int row=0;
			try {
				PreparedStatement ps=conn.prepareStatement("update downgoods_tab set purchId=?, employeeId=?, downCount=?, downTime=?, remarks=? where serialId=?");
				ps.setInt(1, downgoods.getPurchId());
				ps.setInt(2, downgoods.getEmployeeId());
				ps.setInt(3, downgoods.getDownCount());
				ps.setString(4, downgoods.getDownTime());
				ps.setString(5, downgoods.getRemarks());
				ps.setInt(6, downgoods.getSerialId());
//				System.out.println("remark======"+downgoods.getRemarks());
				row=ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return row;
		}
		
		public DownGoods findsDowngoods(int id){
			DownGoods downgoods=new DownGoods();
			try {
				PreparedStatement ps=conn.prepareStatement("select * from downgoods_tab where serialId=?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					downgoods.setSerialId(id);
					downgoods.setPurchId(rs.getInt("purchId"));
					downgoods.setEmployeeId(rs.getInt("employeeId"));
					downgoods.setDownCount(rs.getInt("downCount"));
					downgoods.setDownTime(rs.getString("downTime"));
					downgoods.setRemarks(rs.getString("remarks"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return downgoods;
		}

		//商品上驾时，获取商品的基本信息
		public String getGoodsInfo(int purchId) {
			// TODO Auto-generated method stub
			String goodsInfo = "";
			try {
				PreparedStatement ps = conn.prepareStatement("select purch_tab.purchId as purId, purch_tab.productId as proId, " +
						"productName, productNorms, remainNum, productTime, expireTime, companyId " +
						"from (store_tab inner join purch_tab on store_tab.purchId=purch_tab.purchId) " +
						"inner join product_tab on product_tab.productId=purch_tab.productId " +
						"where purch_tab.purchId=?");
				ps.setInt(1, purchId);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					int productId = rs.getInt("proId");
					String productName = rs.getString("productName");
					int remainNum = rs.getInt("remainNum");
					String productTime = rs.getString("productTime");
					String expireTime = rs.getString("expireTime");
					int companyId = rs.getInt("companyId");
					
					String productNorms = rs.getString("productNorms");
					goodsInfo=productId+","+productName+","+productTime
							+","+expireTime+","+remainNum+","+companyId+","+productNorms;
					System.out.println(goodsInfo);
				}
				closeConn(conn, rs, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
			return goodsInfo;
		}

		//获在售商品的基本信息，用户商品下架时使用
		public String getOnsellGoodsInfo(int purchId) {
			String goodsInfo = "";
			try {
				PreparedStatement ps = conn.prepareStatement("select purch_tab.productId as proId, productName, " +
						"productTime, expireTime, count, companyId " +
						"from (onsell_tab inner join purch_tab on onsell_tab.purchId=purch_tab.purchId) " +
						"inner join product_tab on product_tab.productId=purch_tab.productId " +
						"where purch_tab.purchId=?");
				ps.setInt(1, purchId);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					int productId = rs.getInt("proId");
					String productName = rs.getString("productName");
					String productTime = rs.getString("productTime");
					String expireTime = rs.getString("expireTime");
					int count = rs.getInt("count");
					int companyId = rs.getInt("companyId");
					goodsInfo=productId+","+productName+","+productTime
							+","+expireTime+","+count+","+companyId;
				}
				closeConn(conn, rs, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
			return goodsInfo;
		}
}
