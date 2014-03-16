package com.supplier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.connection.basic.ConnectionAware;

public class SupplierDao extends ConnectionAware{
	
	/**
	 * 查找所有供货商信息
	 * @return
	 */
	public List<SupplierBean> selectAllSupplierInfo(){
		List<SupplierBean> list = new ArrayList<SupplierBean>();
		PreparedStatement ps = null;
		String sql = "select * from supplier_tab";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				SupplierBean sb = new SupplierBean();
				sb.setCompanyId(rs.getInt("companyId"));
				sb.setCompanyName(rs.getString("companyName"));
				sb.setCompanyAddress(rs.getString("companyAddress"));
				sb.setManager(rs.getString("manager"));
				sb.setCompanyTel(rs.getString("companyTel"));
				list.add(sb);
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
			closeConn(conn, ps);
			return null;
		}
		return list;
	}
	/**
	 * 查询目前供应商的编号最大的编号
	 * @return
	 */
	public int selectMaxSupplierId(){
		int ans = 0;
		PreparedStatement ps = null;
		String sql = "select max(companyId) as ID from supplier_tab";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				ans = rs.getInt("ID");
				closeConn(conn, rs, ps);
			}else{
				closeConn(conn, rs, ps);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			closeConn(conn, ps);
			return -1;
		}
		return ans;
	}
	/**
	 * 
	 * 添加供应商信息
	 * @param sb
	 * @return
	 */
	public boolean insertNewSupplierInfo(SupplierBean sb){
		PreparedStatement ps = null;
		String sql = "insert into supplier_tab(companyName,companyShort,companyAddress,manager,companyTel,email,postalCode,fax,bankName,bankAccounts,addTime,remarks) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, sb.getCompanyName());
			ps.setString(2, sb.getCompanyShort());
			ps.setString(3, sb.getCompanyAddress());
			ps.setString(4, sb.getManager());
			ps.setString(5, sb.getCompanyTel());
			ps.setString(6, sb.getEmail());
			ps.setString(7, sb.getPostalCode());
			ps.setString(8, sb.getFax());
			ps.setString(9, sb.getBankName());
			ps.setString(10, sb.getBankAccounts());
			ps.setString(11, sb.getAddTime());
			ps.setString(12, sb.getRemarks());
			int ans = ps.executeUpdate();
			if(ans!=0){
				closeConn(conn, ps);
				return true;
			}else{
				closeConn(conn, ps);
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			closeConn(conn, ps);
			return false;
		}
	}
	/**
	 * 查询单个供应商信息
	 * @param companyId
	 * @return
	 */
	public SupplierBean selectOneSupplierInfo(int companyId){
		SupplierBean sb = new SupplierBean();
		PreparedStatement ps = null;
		String sql = "select * from supplier_tab where companyId=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, companyId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){			
				sb.setAddTime(rs.getString("addTime"));
				sb.setBankAccounts(rs.getString("bankAccounts"));
				sb.setBankName(rs.getString("bankName"));
				sb.setCompanyId(rs.getInt("companyId"));
				sb.setCompanyName(rs.getString("companyName"));
				sb.setCompanyAddress(rs.getString("companyAddress"));
				sb.setCompanyShort(rs.getString("companyShort"));
				sb.setCompanyTel(rs.getString("companyTel"));
				sb.setEmail(rs.getString("email"));
				sb.setFax(rs.getString("fax"));
				sb.setPostalCode(rs.getString("postalCode"));
				sb.setManager(rs.getString("manager"));
				sb.setCompanyTel(rs.getString("companyTel"));
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
			closeConn(conn, ps);
			return null;
		}
		return sb;
	}
	public boolean updateSupplier(SupplierBean sb){
		PreparedStatement ps = null;
		String sql = "update supplier_tab set companyName=?,companyShort=?,companyAddress=?,manager=?,companyTel=?,email=?,postalCode=?,fax=?,bankName=?,bankAccounts=?,addTime=?,remarks=? where companyId=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, sb.getCompanyName());
			ps.setString(2, sb.getCompanyShort());
			ps.setString(3, sb.getCompanyAddress());
			ps.setString(4, sb.getManager());
			ps.setString(5, sb.getCompanyTel());
			ps.setString(6, sb.getEmail());
			ps.setString(7, sb.getPostalCode());
			ps.setString(8, sb.getFax());
			ps.setString(9, sb.getBankName());
			ps.setString(10, sb.getBankAccounts());
			ps.setString(11, sb.getAddTime());
			ps.setString(12, sb.getRemarks());
			ps.setInt(13, sb.getCompanyId());
			int ans = ps.executeUpdate();
			if(ans!=0){
				closeConn(conn, ps);
				return true;
			}else{
				closeConn(conn, ps);
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			closeConn(conn, ps);
			return false;
		}
	}

	
}
