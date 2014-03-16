package com.purch.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employee.EmployeeBean;
import com.goods.ProductBean;
import com.mvc.connection.basic.ConnectionAware;
import com.purch.bean.PurchBean;
import com.purch.bean.ReturnBean;
import com.supplier.SupplierBean;

public class PurchDao extends ConnectionAware{
	
	public ProductBean selectProductName(int id){
		ProductBean product=new ProductBean();
		try {
			PreparedStatement ps=conn.prepareStatement("select productName from product_tab where productId=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				
				product.setProductName(rs.getString("productName"));
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
		
	}
	public SupplierBean selectSupplierName(int id){
		SupplierBean supplier=new SupplierBean();
		try {
			PreparedStatement ps=conn.prepareStatement("select companyName from supplier_tab where companyId=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				supplier.setCompanyName(rs.getString("companyName"));
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return supplier;
		 
		
	}
	public EmployeeBean selectEmployeeName(int id){
		EmployeeBean employee=new EmployeeBean();
		try {
			PreparedStatement ps=conn.prepareStatement("select employeeName from employee_tab where employeeId=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				employee.setEmployeeName(rs.getString("employeeName"));
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
		
	}
	
	public void deletePurch(int ids){
		try {
			PreparedStatement ps=conn.prepareStatement("delete from purch_tab where purchId=?");
			ps.setInt(1,ids);
		    ps.executeUpdate();
		   // conn.close();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteReturn(int ids){
		try {
			PreparedStatement ps=conn.prepareStatement("delete from return_tab where returnId=?");
			ps.setInt(1,ids);
		    ps.executeUpdate();
		    //conn.close();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<PurchBean> purchList(){
		List<PurchBean> list=new ArrayList<PurchBean>();
	    try {
			PreparedStatement ps=conn.prepareStatement("select purch_tab.purchId,purch_tab.productId,product_tab.productName,purch_tab.companyId,supplier_tab.companyName," +
					"purch_tab.employeeId, employee_tab.employeeName, purch_tab.inPrice,purch_tab.purchCount,purch_tab.purchTime," +
					"purch_tab.productTime,purch_tab.expireTime,purch_tab.remarks from ((purch_tab inner join product_tab on purch_tab.productId=product_tab.productId)" +
					"inner join employee_tab on purch_tab.employeeId=employee_tab.employeeId) inner join supplier_tab on purch_tab.companyId=supplier_tab.companyId order by purchId desc");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				PurchBean purch=new PurchBean();
				purch.setPurchId(rs.getInt("purchId"));
				purch.setProductId(rs.getInt("productId"));
				purch.setProductName(rs.getString("productName"));
				purch.setEmployeeId(rs.getInt("employeeId"));
				purch.setEmployeeName(rs.getString("employeeName"));
				purch.setCompanyId(rs.getInt("companyId"));
				purch.setCompanyName(rs.getString("companyName"));
				purch.setInPrice(rs.getFloat("inPrice"));
				purch.setPurchCount(rs.getInt("purchCount"));
				purch.setProductTime(rs.getString("productTime"));
				purch.setPurchTime(rs.getString("purchTime"));
				purch.setExpireTime(rs.getString("expireTime"));
				purch.setRemarks(rs.getString("remarks"));
				list.add(purch);
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public int insertPurch(PurchBean purch){
		
		
	  int row=0;
		try {
			PreparedStatement ps = conn.prepareStatement("insert into purch_tab (productId,inPrice,purchCount,purchTime,productTime,expireTime,employeeId,companyId,remarks)values(?,?,?,?,?,?,?,?,?)");
			//ps.setInt(1,purch.getPurchId());
			ps.setInt(1,purch.getProductId());
			ps.setFloat(2,purch.getInPrice());
			ps.setInt(3,purch.getPurchCount());
			ps.setString(4,purch.getPurchTime());
			ps.setString(5,purch.getProductTime());
			ps.setString(6,purch.getExpireTime());
			ps.setInt(7,purch.getEmployeeId());
			ps.setInt(8,purch.getCompanyId());
			ps.setString(9,purch.getRemarks());
			row=ps.executeUpdate();
			//closeConn(conn, ps);
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
		
	}
	
	public PurchBean findPurch(int id){
		PurchBean purch=new PurchBean();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from purch_tab where purchId=?");
		    ps.setInt(1,id);
		    ResultSet rs=ps.executeQuery();
		    if(rs.next()){
		    	purch.setPurchId(id);
		    	purch.setProductId(rs.getInt("purchId"));
		    	purch.setProductId(rs.getInt("productId"));
				purch.setInPrice(rs.getFloat("inPrice"));
				purch.setPurchCount(rs.getInt("purchCount"));
				purch.setProductTime(rs.getString("productTime"));
				purch.setPurchTime(rs.getString("purchTime"));
				purch.setExpireTime(rs.getString("expireTime"));
				purch.setEmployeeId(rs.getInt("employeeId"));
				purch.setCompanyId(rs.getInt("companyId"));
				purch.setRemarks(rs.getString("remarks"));
		    }
		    closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return purch;
		
		
	}
	
       public int updatePurch(PurchBean purch){
    	   int row=0;
		try {
			PreparedStatement ps = conn.prepareStatement("update purch_tab set productId=?,inPrice=?,purchCount=?,purchTime=?,productTime=?,expireTime=?,employeeId=?,companyId=?,remarks=? where purchId=?");
			ps.setInt(10,purch.getPurchId());
			ps.setInt(1,purch.getProductId());
			ps.setFloat(2,purch.getInPrice());
			ps.setInt(3,purch.getPurchCount());
			ps.setString(4,purch.getPurchTime());
			ps.setString(5,purch.getProductTime());
			ps.setString(6,purch.getExpireTime());
			ps.setInt(7,purch.getEmployeeId());
			ps.setInt(8,purch.getCompanyId());
			ps.setString(9,purch.getRemarks());
			//ps.setInt(10,purch.getPurchId());
			row=ps.executeUpdate();
			closeConn(conn, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
		
	
	}
	//jfhdkjhfudf
       
       public List<ReturnBean> returnList(){
   		List<ReturnBean> list=new ArrayList<ReturnBean>();
   	    try {
   			PreparedStatement ps=conn.prepareStatement("select return_tab.returnId,return_tab.purchId,return_tab.returnPrice,return_tab.returnCount,return_tab.returnTime,return_tab.employeeId,return_tab.companyId," +
   					" employee_tab.employeeName,supplier_tab.companyName,return_tab.remarks  from (return_tab inner join employee_tab on return_tab.employeeId=employee_tab.employeeId)inner join supplier_tab on return_tab.companyId=supplier_tab.companyId order by returnId desc");
   			ResultSet rs=ps.executeQuery();
   			while(rs.next()){
   				ReturnBean returnn=new ReturnBean();
   				returnn.setReturnId(rs.getInt("returnId"));
   				returnn.setPurchId(rs.getInt("purchId"));
   				returnn.setReturnPrice(rs.getFloat("returnPrice"));
   				returnn.setReturnCount(rs.getInt("returnCount"));
   				returnn.setReturnTime(rs.getString("returnTime"));
   				returnn.setEmployeeId(rs.getInt("employeeId"));
   				returnn.setCompanyId(rs.getInt("companyId"));
   				returnn.setEmployeeName(rs.getString("employeeName"));
   				returnn.setCompanyName(rs.getString("companyName"));
   				returnn.setRemarks(rs.getString("remarks"));
   				list.add(returnn);
   			}
   			closeConn(conn, rs, ps);
   		} catch (SQLException e) {
   			e.printStackTrace();
   		}
   		return list;
   	}
   	
   	
   	public int insertReturn(ReturnBean returnn){
   	  int row=0;
   		try {
   			PreparedStatement ps = conn.prepareStatement("insert into return_tab (purchId,returnPrice,returnCount,returnTime,employeeId,companyId,remarks)values(?,?,?,?,?,?,?)");
   			ps.setInt(1,returnn.getPurchId());
   			ps.setFloat(2,returnn.getReturnPrice());
   			ps.setInt(3,returnn.getReturnCount());
   			ps.setString(4,returnn.getReturnTime());
   			ps.setInt(5,returnn.getEmployeeId());
   			ps.setInt(6,returnn.getCompanyId());
   			ps.setString(7,returnn.getRemarks());
   			row=ps.executeUpdate();
   			//closeConn(conn, ps);
   		} 
   		
   		catch (SQLException e) {
   			e.printStackTrace();
   		}
   		return row;
   		
   	}
   	
   	public ReturnBean findReturn(int id){
   		ReturnBean returnn=new ReturnBean();
   		try {
   			PreparedStatement ps=conn.prepareStatement("select * from return_tab where returnId=?");
   		    ps.setInt(1,id);
   		    ResultSet rs=ps.executeQuery();
   		    if(rs.next()){
   		    	returnn.setReturnId(id);
   		    	returnn.setPurchId(rs.getInt("purchId"));
   		    	returnn.setReturnPrice(rs.getFloat("returnPrice"));
   		    	returnn.setReturnCount(rs.getInt("returnCount"));
   		    	returnn.setReturnTime(rs.getString("returnTime"));
   		    	returnn.setEmployeeId(rs.getInt("employeeId"));
   				returnn.setCompanyId(rs.getInt("companyId"));
   				returnn.setRemarks(rs.getString("remarks"));
   		    }
   		    closeConn(conn, rs, ps);
   		} catch (SQLException e) {
   			e.printStackTrace();
   		}
   		return returnn;
   		
   		
   	}
   	
          public int updateReturn(ReturnBean returnn){
       	   int row=0;
   		try {
   			PreparedStatement ps = conn.prepareStatement("update return_tab set purchId=?,returnPrice=?,returnCount=?,returnTime=?,employeeId=?,companyId=?,remarks=? where returnId=?");
   			ps.setInt(8,returnn.getReturnId());
   			ps.setInt(1,returnn.getPurchId());
   			ps.setFloat(2,returnn.getReturnPrice());
   			ps.setInt(3,returnn.getReturnCount());
   			ps.setString(4,returnn.getReturnTime());
   			ps.setInt(5,returnn.getEmployeeId());
   			ps.setInt(6,returnn.getCompanyId());
   			ps.setString(7,returnn.getRemarks());
   			row=ps.executeUpdate();
   			closeConn(conn, ps);
   		} catch (SQLException e) {
   			e.printStackTrace();
   		}
   		return row;
   		
   	
   	}
   	

}
