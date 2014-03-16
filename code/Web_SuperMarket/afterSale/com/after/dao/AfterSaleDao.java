package com.after.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.afterSale.bean.AfterSale;
import com.afterSale.bean.GiftRecord;
import com.gift.GiftBean;
import com.mvc.connection.basic.ConnectionAware;
import com.sales.bean.VipBean;
import com.storage.bean.InStorageBean;
import com.storage.bean.OutStorageBean;

public class AfterSaleDao extends ConnectionAware{

	public List<GiftBean> selectAll(){
		List<GiftBean> list=new ArrayList<GiftBean>();
		try {
			PreparedStatement ps=conn.prepareStatement("select giftId,gift_tab.productId,productName,score,productPrice,productTypeName from productType_tab inner join(gift_tab inner join product_tab on gift_tab.productId=product_tab.productId) on product_tab.productTypeId=productType_tab.productTypeId");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				GiftBean gift=new GiftBean();
				gift.setGiftId(rs.getInt("giftId"));
				gift.setProductId(rs.getInt("productId"));
				gift.setScore(rs.getInt("score"));
				gift.setProductName(rs.getString("productName"));
				gift.setProductTypeName(rs.getString("productTypeName"));
				gift.setProductPrice(rs.getFloat("productPrice"));
				list.add(gift);
			}conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<GiftBean> selectVipGiftList(int vipId){
		List<GiftBean> list=new ArrayList<GiftBean>();
		try {
			PreparedStatement ps=conn.prepareStatement("select giftId,gift_tab.productId,productName,score,productPrice,productTypeName from productType_tab inner join(gift_tab inner join product_tab on gift_tab.productId=product_tab.productId) on product_tab.productTypeId=productType_tab.productTypeId where (select vipScore from vip_tab where vipId=?) >= score");
			ps.setInt(1, vipId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				GiftBean gift=new GiftBean();
				gift.setGiftId(rs.getInt("giftId"));
				gift.setProductId(rs.getInt("productId"));
				gift.setScore(rs.getInt("score"));
				gift.setProductName(rs.getString("productName"));
				gift.setProductTypeName(rs.getString("productTypeName"));
				gift.setProductPrice(rs.getFloat("productPrice"));
				list.add(gift);
			}conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<GiftBean> productId(){
		List<GiftBean> productIdList=new ArrayList<GiftBean>();
		try {
			PreparedStatement ps=conn.prepareStatement("select productId from product_tab");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				GiftBean productId=new GiftBean();
				productId.setProductId(rs.getInt("productId"));
				productIdList.add(productId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productIdList;
		
	}
	
	public int selecRecordtMax(){
		int a=0;
		try {
			PreparedStatement ps=conn.prepareStatement("select max(afterSaleId) as ID from afterSale_tab");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				a=rs.getInt("ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	
	public int selectMax(){
		int a=0;
		try {
			PreparedStatement ps=conn.prepareStatement("select max(giftId) as ID from gift_tab");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				a=rs.getInt("ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	
	public float getPrice(int id){
		float a=0;
		try {
			PreparedStatement ps=conn.prepareStatement("select productPrice from product_tab where productId="+id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				a=rs.getFloat("productPrice");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
		
	}
	
	
	
//	public int getProductId(String name){
//		System.out.println(name+"---------");
//		int a=0;
//		try {
//			PreparedStatement ps=conn.prepareStatement("select productId from product_tab where productName=?");
//			ps.setString(1, name);
//			ResultSet rs=ps.executeQuery();
//		   System.out.println(rs.next());
//		   if(rs.next()){
//			  System.out.println("00000000000000");
//			  a=rs.getInt("productId");
//			  System.out.println(a+"11111111");
//		   }closeConn(conn, rs, ps);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return a;
//	}
	
	//添加退货记录
	public void insertAfterSaleRecord(AfterSale afterSale){
		AfterSaleDao dao = new AfterSaleDao();
		try {
			PreparedStatement ps=conn.prepareStatement("insert into afterSale_tab (afterSaleId,purchId,money,employeeId,date,reason,remarks) values(?,?,?,?,?,?,?)");
//			int productId=dao.getProductId(afterSale.getProductName());
//			ps.setInt(1, productId);
			ps.setInt(1, afterSale.getAfterSaleId());
			ps.setInt(2, afterSale.getPurchId());
			float price=dao.getPrice(afterSale.getPurchId());
			ps.setFloat(3, price);
			ps.setInt(4, afterSale.getEmployeeId());
			ps.setString(5, afterSale.getDate());
			ps.setString(6, afterSale.getReason());
			ps.setString(7, afterSale.getRemarks());
			ps.executeUpdate();
	//		conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public List<AfterSale> selectAll1(){
		List<AfterSale> afterSaleList=new ArrayList<AfterSale>();
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement("select afterSaleId,purchId,productName,employeeId,money,date,reason,afterSale_tab.remarks from afterSale_tab inner join product_tab on afterSale_tab.purchId=product_tab.productId");
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			String a=null;
			AfterSale after=new AfterSale();
			after.setAfterSaleId(rs.getInt("afterSaleId"));
			after.setPurchId(rs.getInt("purchId"));
			after.setProductName(rs.getString("productName"));
			after.setEmployeeId(rs.getInt("employeeId"));
			after.setMoney(rs.getFloat("money"));
			after.setDate(rs.getString("date"));
			StringBuffer sbf=new StringBuffer();
			sbf.append(rs.getString("reason"));
	//		System.out.println(sbf.length());
			if(sbf.length()>6){
				a=sbf.substring(0,3);
				after.setReason(a+"......");
	//			System.out.println(a.length());
			}else{
				after.setReason(rs.getString("reason"));
			}
			StringBuffer sbf1=new StringBuffer();
			sbf1.append(rs.getString("remarks"));
			if(sbf1.length()>6){
				 a=sbf.substring(0,3);
				
				after.setRemarks(a+".....");
			}else{
				after.setRemarks(rs.getString("remarks"));
			}
			afterSaleList.add(after);
		}conn.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return afterSaleList;
	}
	
	
	
//	public List<AfterSale> selectAll1(){
//		List<AfterSale> afterSaleList=new ArrayList<AfterSale>();
//		PreparedStatement ps;
//		try {
//			ps = conn.prepareStatement("select afterSaleId,purchId,productName,employeeId,money,date,reason,afterSale_tab.remarks from afterSale_tab inner join product_tab on afterSale_tab.purchId=product_tab.productId");
//		
//		ResultSet rs=ps.executeQuery();
//		while(rs.next()){
//			AfterSale after=new AfterSale();
//			after.setAfterSaleId(rs.getInt("afterSaleId"));
//			after.setPurchId(rs.getInt("purchId"));
//			after.setProductName(rs.getString("productName"));
//			after.setEmployeeId(rs.getInt("employeeId"));
//			after.setMoney(rs.getFloat("money"));
//			after.setDate(rs.getString("date"));
////			StringBuffer sbf=new StringBuffer();
////			sbf.append(rs.getString("reason"));
////			String s=sbf.substring(0, 4);
////			String s1=s+"........";
//			after.setReason(rs.getString("reason"));
//			after.setRemarks(rs.getString("remarks"));
//			afterSaleList.add(after);
//		}conn.close();
//		
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return afterSaleList;
//	}
//	
	
	public AfterSale selectDetailsReturn(int id){
		AfterSale after = new AfterSale();
		try {
			PreparedStatement ps=conn.prepareStatement("select afterSaleId,purchId,productName,employeeId,money,date,reason,afterSale_tab.remarks from afterSale_tab inner join product_tab on afterSale_tab.purchId=product_tab.productId where afterSaleId="+id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				after.setAfterSaleId(rs.getInt("afterSaleId"));
				after.setPurchId(rs.getInt("purchId"));
				after.setProductName(rs.getString("productName"));
				after.setEmployeeId(rs.getInt("employeeId"));
				after.setMoney(rs.getFloat("money"));
				after.setDate(rs.getString("date"));
				after.setReason(rs.getString("reason"));
				after.setRemarks(rs.getString("remarks"));
			}closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return after;
		
	}
	
	public List<GiftRecord> selectAllGiftRecord(){
		List<GiftRecord> giftRecord = new ArrayList<GiftRecord>();
		String a=null;
		try {
			PreparedStatement ps=conn.prepareStatement("select giftRecord_tab.giftId,giftRecord_tab.purchId,productName,giftRecord_tab.giftCount,giftRecord_tab.vipId,giftRecord_tab.employeeId,giftRecord_tab.gifttime,giftRecord_tab.remarks from giftRecord_tab inner join"+
					"(purch_tab inner join product_tab on purch_tab.productId=product_tab.productId) on purch_tab.purchId=giftRecord_tab.purchId");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				GiftRecord record = new GiftRecord();
				record.setGiftId(rs.getInt("giftId"));
				record.setPurchId(rs.getInt("purchId"));
				record.setProductName(rs.getString("productName"));
				record.setGiftCount(rs.getInt("giftCount"));
				record.setVipId(rs.getInt("vipId"));
				record.setEmployeeId(rs.getInt("employeeId"));
				record.setGifttime(rs.getString("gifttime"));
				
				StringBuffer sbf1=new StringBuffer();
				sbf1.append(rs.getString("remarks"));
				if(sbf1.length()>6){
					
					 a=sbf1.substring(0,3);
					
					 record.setRemarks(a+".....");
				}else{
					record.setRemarks(rs.getString("remarks"));
				}
				
				
				record.setRemarks(rs.getString("remarks"));
				giftRecord.add(record);
			}closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return giftRecord;
	}
	
	public GiftRecord selectOneGiftRecord(int id){
		GiftRecord gift=new GiftRecord();
		try {
			PreparedStatement ps=conn.prepareStatement("select giftRecord_tab.giftId,giftRecord_tab.purchId,productName,giftRecord_tab.giftCount,giftRecord_tab.vipId,giftRecord_tab.employeeId,giftRecord_tab.gifttime,giftRecord_tab.remarks from giftRecord_tab inner join"+
					"(purch_tab inner join product_tab on purch_tab.productId=product_tab.productId) on purch_tab.purchId=giftRecord_tab.purchId where giftRecord_tab.giftId=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				gift.setGiftId(rs.getInt("giftId"));
				gift.setPurchId(rs.getInt("purchId"));
				gift.setProductName(rs.getString("productName"));
				gift.setGiftCount(rs.getInt("giftCount"));
				gift.setVipId(rs.getInt("vipId"));
				gift.setEmployeeId(rs.getInt("employeeId"));
				gift.setGifttime(rs.getString("gifttime"));
				gift.setRemarks(rs.getString("remarks"));
			}closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gift;
	}
	
	//查询商品对应的采购流水号purchId
	public int selectPurchId(int productId){
		int a=0;
		try {
			PreparedStatement ps=conn.prepareStatement("select purchId from purch_tab where productId=?");
			ps.setInt(1, productId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				a=rs.getInt("purchId");
			}//closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
		
	}
	
	//根据采购流水号查出仓库里现有的数量
	
	public int selectRemainNum(int purchId){
		int a=0;
		try {
			PreparedStatement ps=conn.prepareStatement("select remainNum from store_tab where purchId=?");
			ps.setInt(1, purchId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				a=rs.getInt("remainNum");
			}//closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
		
	}
	
	//根据商品编号查出仓库里现有的数量
//	public int selectRemainNum(int productId){
//		int a=0;
//		PreparedStatement ps=conn.prepareStatement("select remainNum from ");
//		
//	}
	
	//更新库存数据----------退货商品数量应加一
	public void updateStore(int productId){
		AfterSaleDao dao = new AfterSaleDao();
		try {
			PreparedStatement ps=conn.prepareStatement("update store_tab set remainNum = ? where purchId=?");
			int purchId=dao.selectPurchId(productId);
			int remainNum=dao.selectRemainNum(purchId);
//			System.out.println(purchId+"------------"+remainNum);
			ps.setInt(1, remainNum+1);
			ps.setInt(2, purchId);
			ps.executeUpdate();
//			closeConn(conn, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//查询出仓库编号和流水号
//	public InStorageBean selectStorageId(int productId){
//		InStorageBean in=new InStorageBean();
//		try {
//			PreparedStatement ps=conn.prepareStatement("select purchId,storageId from store_tab where purchId=?");
//			AfterSaleDao dao = new AfterSaleDao();
//			int purchId = dao.selectPurchId(productId);
//		//	System.out.println(purchId);
//			ps.setInt(1, purchId);
//			ResultSet rs=ps.executeQuery();
//			System.out.println(rs.next());
//			if(rs.next()){
//				in.setPurchId(purchId);
//				in.setStorageId(rs.getInt("storageId"));
//				System.out.println(purchId+"------------"+rs.getInt("storageId"));
//			}//closeConn(conn, rs, ps);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return in;
//	}
//	
	
	public InStorageBean selectStorageId(int productId){
		InStorageBean in=new InStorageBean();
		AfterSaleDao dao = new AfterSaleDao();
		int purchId = dao.selectPurchId(productId); 
		try {
			PreparedStatement ps=conn.prepareStatement("select purchId,storageId from store_tab where purchId=?");
			ps.setInt(1, purchId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
//				System.out.println("0000000000000000000");
				in.setPurchId(purchId);
				in.setStorageId(rs.getInt("storageId"));
//				System.out.println(rs.getInt("storageId"));
			}//closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return in;
	}
	
	
	
	
	
	public void insertIntoInStorage(InStorageBean in){
		try {
			PreparedStatement ps=conn.prepareStatement("insert into inStorage_tab (storageId,purchId,employeeId,inNum,inTime,inReason,remarks) values (?,?,?,?,?,?,?)");
			ps.setInt(1, in.getStorageId());
			ps.setInt(2, in.getPurchId());
			ps.setInt(3, in.getEmployeeId());
			ps.setInt(4, in.getInNum());
			ps.setString(5, in.getInTime());
			ps.setString(6, in.getInReason());
			ps.setString(7, in.getRemarks());
			ps.executeUpdate();
	//		closeConn(conn, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public List<GiftRecord> selectGiftRecordById(int id){
		List<GiftRecord> giftRecord = new ArrayList<GiftRecord>();
		String a=null;
		try {
			PreparedStatement ps=conn.prepareStatement("select giftRecord_tab.giftId,giftRecord_tab.purchId,productName,giftRecord_tab.giftCount,giftRecord_tab.vipId,giftRecord_tab.employeeId,giftRecord_tab.gifttime,giftRecord_tab.remarks from giftRecord_tab inner join"+
					"(purch_tab inner join product_tab on purch_tab.productId=product_tab.productId) on purch_tab.purchId=giftRecord_tab.purchId where giftRecord_tab.purchId=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				GiftRecord record = new GiftRecord();
				record.setGiftId(rs.getInt("giftId"));
				record.setPurchId(rs.getInt("purchId"));
				record.setProductName(rs.getString("productName"));
				record.setGiftCount(rs.getInt("giftCount"));
				record.setVipId(rs.getInt("vipId"));
				record.setEmployeeId(rs.getInt("employeeId"));
				record.setGifttime(rs.getString("gifttime"));
				
				StringBuffer sbf1=new StringBuffer();
				sbf1.append(rs.getString("remarks"));
				if(sbf1.length()>6){
					
					 a=sbf1.substring(0,3);
					
					 record.setRemarks(a+".....");
				}else{
					record.setRemarks(rs.getString("remarks"));
				}
				
				
				record.setRemarks(rs.getString("remarks"));
				giftRecord.add(record);
			}closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return giftRecord;
	}
	
	public List<GiftRecord> selectGiftRecordByTime(String time){
		List<GiftRecord> giftRecord = new ArrayList<GiftRecord>();
		String a=null;
		try {
			PreparedStatement ps=conn.prepareStatement("select giftRecord_tab.giftId,giftRecord_tab.purchId,productName,giftRecord_tab.giftCount,giftRecord_tab.vipId,giftRecord_tab.employeeId,giftRecord_tab.gifttime,giftRecord_tab.remarks from giftRecord_tab inner join"+
					"(purch_tab inner join product_tab on purch_tab.productId=product_tab.productId) on purch_tab.purchId=giftRecord_tab.purchId where giftRecord_tab.gifttime = ?");
			ps.setString(1, time);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				GiftRecord record = new GiftRecord();
				record.setGiftId(rs.getInt("giftId"));
				record.setPurchId(rs.getInt("purchId"));
				record.setProductName(rs.getString("productName"));
				record.setGiftCount(rs.getInt("giftCount"));
				record.setVipId(rs.getInt("vipId"));
				record.setEmployeeId(rs.getInt("employeeId"));
				record.setGifttime(rs.getString("gifttime"));
				
				StringBuffer sbf1=new StringBuffer();
				sbf1.append(rs.getString("remarks"));
				if(sbf1.length()>6){
					
					 a=sbf1.substring(0,3);
					
					 record.setRemarks(a+".....");
				}else{
					record.setRemarks(rs.getString("remarks"));
				}
				
				
				record.setRemarks(rs.getString("remarks"));
				giftRecord.add(record);
			}closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return giftRecord;
	}
	
	public List<AfterSale> selectAll1(int id){
		List<AfterSale> afterSaleList=new ArrayList<AfterSale>();
		PreparedStatement ps;
//		System.out.println("22222222222222222222222222222");
		try {
			ps = conn.prepareStatement("select afterSaleId,purchId,productName,employeeId,money,date,reason,afterSale_tab.remarks from afterSale_tab inner join product_tab on afterSale_tab.purchId=product_tab.productId where purchId=?");
		    ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			String a=null;
			AfterSale after=new AfterSale();
			after.setAfterSaleId(rs.getInt("afterSaleId"));
			after.setPurchId(rs.getInt("purchId"));
			after.setProductName(rs.getString("productName"));
			after.setEmployeeId(rs.getInt("employeeId"));
			after.setMoney(rs.getFloat("money"));
			after.setDate(rs.getString("date"));
			StringBuffer sbf=new StringBuffer();
			sbf.append(rs.getString("reason"));
	//		System.out.println(sbf.length());
			if(sbf.length()>6){
				a=sbf.substring(0,3);
				after.setReason(a+"......");
	//			System.out.println(a.length());
			}else{
				after.setReason(rs.getString("reason"));
			}
			StringBuffer sbf1=new StringBuffer();
			sbf1.append(rs.getString("remarks"));
			if(sbf1.length()>6){
				 a=sbf.substring(0,3);
				
				after.setRemarks(a+".....");
			}else{
				after.setRemarks(rs.getString("remarks"));
			}
			afterSaleList.add(after);
		}conn.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return afterSaleList;
	}
	
	
	
	public List<AfterSale> selectAll1(String time){
		List<AfterSale> afterSaleList=new ArrayList<AfterSale>();
		PreparedStatement ps;
//		System.out.println("22222222222222222222222222222");
		try {
			ps = conn.prepareStatement("select afterSaleId,purchId,productName,employeeId,money,date,reason,afterSale_tab.remarks from afterSale_tab inner join product_tab on afterSale_tab.purchId=product_tab.productId where date=?");
		    ps.setString(1, time);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			String a=null;
			AfterSale after=new AfterSale();
			after.setAfterSaleId(rs.getInt("afterSaleId"));
			after.setPurchId(rs.getInt("purchId"));
			after.setProductName(rs.getString("productName"));
			after.setEmployeeId(rs.getInt("employeeId"));
			after.setMoney(rs.getFloat("money"));
			after.setDate(rs.getString("date"));
			StringBuffer sbf=new StringBuffer();
			sbf.append(rs.getString("reason"));
	//		System.out.println(sbf.length());
			if(sbf.length()>6){
				a=sbf.substring(0,3);
				after.setReason(a+"......");
	//			System.out.println(a.length());
			}else{
				after.setReason(rs.getString("reason"));
			}
			StringBuffer sbf1=new StringBuffer();
			sbf1.append(rs.getString("remarks"));
			if(sbf1.length()>6){
				 a=sbf.substring(0,3);
				after.setRemarks(a+".....");
			}else{
				after.setRemarks(rs.getString("remarks"));
			}
			afterSaleList.add(after);
		}conn.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return afterSaleList;
	}
	
	//通过商品编号查找采购流水号
	
		public List<Integer> getPurchId(int productId){
			List<Integer> list=new ArrayList<Integer>();
			try {
				PreparedStatement ps=conn.prepareStatement("select purchId from purch_tab where productId=?");
				ps.setInt(1, productId);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					list.add(rs.getInt("purchId"));
				}
				//closeConn(conn, rs, ps);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		//通过采购流水号查找仓库编号
		
		public OutStorageBean getStorageId(List<Integer> list){
			OutStorageBean out=new OutStorageBean();
			int storageId=0;
			String mess="";
			for(int i=0;i<list.size();i++){
				
				mess=list.get(i).toString()+","+mess;
				
				
			}
			//System.out.println(mess+"*********");
			
			mess=mess.substring(0, mess.length()-1);
			//System.out.println(mess);
			mess="select * from store_tab where purchId in("+mess+")";
			//System.out.println(mess);
			
			try {
				PreparedStatement ps=conn.prepareStatement(mess);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					int remainNum=rs.getInt("remainNum");
					storageId=rs.getInt("storageId");
					if(remainNum!=0){
						out.setPurchId(rs.getInt("purchId"));
						out.setStorageId(storageId);
						//System.out.println(rs.getInt("purchId"));
						//System.out.println(storageId);
						//closeConn(conn, rs, ps);
						return out;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return out;
		}
		
		public VipBean getVipScore(int id){
	        VipBean vip=new VipBean();
			
			try {
				PreparedStatement ps = conn.prepareStatement("select * from vip_tab where vipId=?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					vip.setVipScore(rs.getInt("vipScore"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return vip;
		}
		public int updateVipScore(VipBean vip) {
			int row = 0;
			try {
				PreparedStatement ps=conn.prepareStatement("update vip_tab set vipScore=? where vipId=?");
				ps.setInt(1, vip.getVipScore());
				ps.setInt(2, vip.getVipId());
				row=ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return row;
		}

		public int addGiftRecord(GiftRecord gr){
			int row=0;
			try {
				PreparedStatement ps=conn.prepareStatement("insert into giftRecord_tab (purchId,giftCount,employeeId,vipId,gifttime,remarks) values(?,?,?,?,?,?)");
				ps.setInt(1, gr.getPurchId());
				ps.setInt(2, gr.getGiftCount());
				ps.setInt(3, gr.getEmployeeId());
				ps.setInt(4, gr.getVipId());
				ps.setString(5, gr.getGifttime());
				ps.setString(6, gr.getRemarks());
				row=ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return row;
		}
		
		
		
		
		
		public void deleteOne(int id){
			try {
				PreparedStatement ps=conn.prepareStatement("delete from afterSale_tab where afterSaleId="+id);
				ps.executeUpdate();
		//		conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		public void deleteOne1(int id){
			try {
				PreparedStatement ps=conn.prepareStatement("delete from giftRecord_tab where giftId="+id);
				ps.executeUpdate();
		//		conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	
}
