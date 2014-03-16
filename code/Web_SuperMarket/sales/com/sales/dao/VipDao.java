package com.sales.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.connection.basic.ConnectionAware;
import com.sales.bean.VipBean;
import com.tools.Utils;

public class VipDao extends ConnectionAware{
	public int addVip(VipBean vip){
		int row = 0;
		try {
			//System.out.println(conn);
			PreparedStatement ps=conn.prepareStatement("insert into vip_tab (vipName,vipPass,vipSex,vipBirthday,vipIdNum,vipTel,vipAddress,vipEmail,vipQuestion,vipQQ,vipAnswer,vipRemarks,vipTime) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, vip.getVipName());
			ps.setString(2, vip.getVipPass());
			ps.setString(3, vip.getVipSex());
			ps.setString(4, vip.getVipBirthday());
			ps.setString(5, vip.getVipIdNum());
			ps.setString(6, vip.getVipTel());
			ps.setString(7, vip.getVipAddress());
			ps.setString(8, vip.getVipEmail());
			ps.setString(9, vip.getVipQuestion());
			ps.setString(10, vip.getVipQQ());
			ps.setString(11, vip.getVipAnswer());
			ps.setString(12, vip.getVipRemarks());
			ps.setString(13, Utils.getDateTime());
			row=ps.executeUpdate();
			closeConn(conn, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	
	
	public List<VipBean> selsetAll(){
		List<VipBean> viplist=new ArrayList<VipBean>();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from vip_tab");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				VipBean vip=new VipBean();
				vip.setVipName(rs.getString("vipName"));
				vip.setVipId(rs.getInt("vipId"));
				vip.setVipSex(rs.getString("vipSex"));
				vip.setVipTel(rs.getString("vipTel"));
				vip.setVipAddress(rs.getString("vipAddress"));
				vip.setVipRemarks(rs.getString("vipRemarks"));
				viplist.add(vip);
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return viplist;
	}


	public VipBean selsetOne(int id) {
		VipBean vip=new VipBean();
		
		try {
			PreparedStatement ps = conn.prepareStatement("select * from vip_tab where vipId=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				vip.setVipName(rs.getString("vipName"));
				vip.setVipId(rs.getInt("vipId"));
				vip.setVipSex(rs.getString("vipSex"));
				vip.setVipTel(rs.getString("vipTel"));
				vip.setVipAddress(rs.getString("vipAddress"));
				vip.setVipRemarks(rs.getString("vipRemarks"));
				vip.setVipPass(rs.getString("vipPass"));
				vip.setVipBirthday(rs.getString("vipBirthday"));
				vip.setVipIdNum(rs.getString("vipIdNum"));
				vip.setVipEmail(rs.getString("vipEmail"));
				vip.setVipQQ(rs.getString("vipQQ"));
				vip.setVipQuestion(rs.getString("vipQuestion"));
				vip.setVipAnswer(rs.getString("vipAnswer"));
				vip.setVipTime(rs.getString("vipTime"));
				vip.setVipMoney(rs.getInt("vipMoney"));
				vip.setVipScore(rs.getInt("vipScore"));
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vip;
	}


	public int updateVip(VipBean vip) {
		int row = 0;
		try {
			PreparedStatement ps=conn.prepareStatement("update vip_tab set vipName=?,vipPass=?,vipBirthday=?,vipIdNum=?,vipTel=?,vipAddress=?,vipEmail=?,vipQQ=?,vipAnswer=?,vipRemarks=? where vipId=?");
			ps.setString(1, vip.getVipName());
			ps.setString(2, vip.getVipPass());
			ps.setString(3, vip.getVipBirthday());
			ps.setString(4, vip.getVipIdNum());
			ps.setString(5, vip.getVipTel());
			ps.setString(6, vip.getVipAddress());
			ps.setString(7, vip.getVipEmail());
			ps.setString(8, vip.getVipQQ());
			ps.setString(9, vip.getVipAnswer());
			ps.setString(10, vip.getVipRemarks());
			ps.setInt(11, vip.getVipId());
			row=ps.executeUpdate();
			closeConn(conn, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

}
