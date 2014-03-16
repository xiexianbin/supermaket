package com.notice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.connection.basic.ConnectionAware;

public class NoticeDao extends ConnectionAware{
	//gen ju bu men hao ,cha xun yong hu suo zai bu men ming
	public String getDeptName(int id){
		String deptName="";
	try {
		PreparedStatement ps=conn.prepareStatement("select deptName from dept_tab where deptId =?");
		ps.setInt(1, id);
	ResultSet rs=ps.executeQuery();
		if(rs.next()){
			deptName=rs.getString("deptName");
		}
		ps.close();
		rs.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return deptName;
		
	}
	//添加公告
       public int insertNotice(NoticeBean notice){
    	   int row=0;
    	   
    	 try {
			PreparedStatement ps=  conn.prepareStatement("insert into notice_tab(noticeTitle,deptId,noticeTime,noticeContent,lookCount,remarks)values(?,?,?,?,?,?)");
			ps.setString(1, notice.getNoticeTitle());
			ps.setInt(2, notice.getDeptId());
			ps.setString(3, notice.getNoticeTime());
			ps.setString(4, notice.getNoticeContent());
			ps.setInt(5,notice.getLookCount());
			ps.setString(6, notice.getRemarks());
			row=ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
       }
       
       //查看全部公告
       public List<NoticeBean> selectAll(){
    	   List<NoticeBean> list = new ArrayList<NoticeBean>();
    	   try {
    		   PreparedStatement ps = conn.prepareStatement("select notice_tab.noticeId, notice_tab.noticeTitle," +
    		   		" notice_tab.deptId, notice_tab.noticeTime, notice_tab.noticeContent, notice_tab.lookCount, " +
    		   		"notice_tab.remarks, dept_tab.deptName " +
    		   		"from notice_tab inner join dept_tab on notice_tab.deptId=dept_tab.deptId " +
    		   		"order by notice_tab.noticeId desc");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				NoticeBean notice =new NoticeBean();
				notice.setNoticeId(rs.getInt("noticeId"));
				notice.setNoticeTitle(rs.getString("noticeTitle"));
				notice.setDeptId(rs.getInt("deptId"));
				notice.setNoticeTime(rs.getString("noticeTime"));
				notice.setNoticeContent(rs.getString("noticeContent"));
				notice.setLookCount(rs.getInt("lookCount"));
				notice.setRemarks(rs.getString("remarks"));
				notice.setDeptName(rs.getString("deptName"));
				list.add(notice);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
    	   
       }
       //查看某一个公告的详细信息
       public NoticeBean noticeOne(int id){
    	   NoticeBean notice= new NoticeBean();
    	 try {
			PreparedStatement ps=  conn.prepareStatement("select notice_tab.noticeId," +
   		"notice_tab.noticeTitle,notice_tab.deptId," +
   		"notice_tab.noticeTime,notice_tab.noticeContent,notice_tab.lookCount,notice_tab.remarks,dept_tab.deptName from notice_tab join dept_tab on notice_tab.deptId=dept_tab.deptId where noticeId=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				notice.setNoticeId(rs.getInt("noticeId"));
				notice.setNoticeTitle(rs.getString("noticeTitle"));
				notice.setDeptId(rs.getInt("deptId"));
				notice.setDeptName(rs.getString("deptName"));
				notice.setNoticeTime(rs.getString("noticeTime"));
				notice.setNoticeContent(rs.getString("noticeContent"));
				notice.setLookCount(rs.getInt("lookCount"));
				notice.setRemarks(rs.getString("remarks"));
				
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   
		return notice;
    	   
       }
       
       
       
       //查看某一部门发布的所有公告
       public List<NoticeBean> selectDept(int id){
    	   List<NoticeBean> list =new  ArrayList<NoticeBean>();
    	  
    	   try {
			PreparedStatement ps= conn.prepareStatement("select notice_tab.noticeId," +
   		"notice_tab.noticeTitle,notice_tab.deptId," +
   		"notice_tab.noticeTime,notice_tab.noticeContent,notice_tab.lookCount," +
   		"notice_tab.remarks,dept_tab.deptName from notice_tab join dept_tab on notice_tab.deptId=dept_tab.deptId where dept_tab.deptId=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				 NoticeBean notice = new NoticeBean();
				notice.setNoticeId(rs.getInt("noticeId"));
				notice.setNoticeTitle(rs.getString("noticeTitle"));
				notice.setDeptId(id);
				notice.setNoticeTime(rs.getString("noticeTime"));
				notice.setNoticeContent(rs.getString("noticeContent"));
				notice.setLookCount(rs.getInt("lookCount"));
				notice.setRemarks(rs.getString("remarks"));
				notice.setDeptName(rs.getString("deptName"));
				list.add(notice);
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
       }
       
       
      //获得数据库中的部门
	public List<DeptBean> getAlldept(){
		List<DeptBean>list = new ArrayList<DeptBean>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from dept_tab");
		ResultSet rs=	ps.executeQuery();
		while(rs.next()){
			DeptBean bean=new DeptBean();
			bean.setDeptId(rs.getInt("deptId"));
			bean.setDeptName(rs.getString("deptName"));
			bean.setEmployeeId(rs.getInt("employeeId"));
			list.add(bean);
			
		}
		ps.close();
		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	//geng xin liu lan ci shu 
	public int updateNotice(NoticeBean bean){
		int row =0;
	try {
		PreparedStatement ps=conn.prepareStatement("update notice_tab" +
				" set noticeTitle=?,deptId=?,noticeTime=?," +
				"noticeContent=?,lookCount=?,remarks=?  where noticeId= ?");
		ps.setString(1, bean.getNoticeTitle());
		ps.setInt(2, bean.getDeptId());
		ps.setString(3, bean.getNoticeTime());
		ps.setString(4, bean.getNoticeContent());
		ps.setInt(5, bean.getLookCount());
		ps.setString(6, bean.getRemarks());
		ps.setInt(7, bean.getNoticeId());
		row=ps.executeUpdate();
		ps.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return row;
		
				
	}
       
}
