package com.recordcheck;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.connection.basic.ConnectionAware;

public class RecordcheckDao extends ConnectionAware {



	// 查看某员工所有的打卡记录
	public List<checkMode> allcheck(int id) {
		List<checkMode> list = new ArrayList<checkMode>();
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from check_tab where employeeId=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				checkMode bean = new checkMode();

				bean.setEmployeeId(rs.getInt("employeeId"));
				bean.setDateTime(rs.getString("dateTime"));
				bean.setWeek(rs.getString("weeks"));

				
				bean.setTime1(rs.getString("time1"));
				bean.setTime2(rs.getString("time2"));
            StringBuffer sbf=new StringBuffer();
            sbf.append(rs.getString("remarks"));
            if(sbf.length()>5){
            	String sff=sbf.substring(0, 4)+"...";
            	bean.setRemarks(sff);
            }else{
            	bean.setRemarks(rs.getString("remarks"));
            }
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

	// 根据年月和用户编号查询某用户的考勤记录

	public List<checkMode> selectrec(int id, String ymonth) {
		List<checkMode> list = new ArrayList<checkMode>();
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from check_tab where employeeId=? and dateTime like '"
							+ ymonth + "%'");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				checkMode bean = new checkMode();

				bean.setEmployeeId(rs.getInt("employeeId"));
				bean.setDateTime(rs.getString("dateTime"));
				bean.setWeek(rs.getString("weeks"));

				//bean.setRemarks(rs.getString("remarks"));
				bean.setTime1(rs.getString("time1"));
				bean.setTime2(rs.getString("time2"));
				 
				StringBuffer sbf=new StringBuffer();
		            sbf.append(rs.getString("remarks"));
		            if(sbf.length()>5){
		            	String sff=sbf.substring(0, 4)+"...";
		            	bean.setRemarks(sff);
		            }else{
		            	bean.setRemarks(rs.getString("remarks"));
		            }
				
				
				list.add(bean);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/*public Mode oneMode(int id, String ymonth){
		Mode mode=new Mode();
	try {
		PreparedStatement ps=	conn.prepareStatement("select * from recordcheck_tab where employeeId=? and date like '"+ ymonth + "%'");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			mode.setLate(rs.getInt("late"));
			mode.setAdd(rs.getInt("overtime"));
			mode.setAbsence(rs.getInt("absenteeism"));
			mode.setEarly(rs.getInt("early"));
			 StringBuffer sbf=new StringBuffer();
	            sbf.append(rs.getString("remarks"));
	            if(sbf.length()>5){
	            	String sff=sbf.substring(0, 4)+"...";
	            	mode.setRemarks(sff);
	            }else{
	            	mode.setRemarks(rs.getString("remarks"));
	            }
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return mode;
	}*/

	public Mode oneMode(int id, String ymonth){
		
		Mode mm=new Mode();
		 List<checkMode> list=selectrec(id,ymonth);
		 if(list.size()!=0){
			 int late=0;
				int early=0;
				int absence=0;
				int add=0;
		 for(int i=0;i<list.size();i++){
			 checkMode check=list.get(i);
			 String time1=check.getTime1();
			 String time2=check.getTime2();
			 String t1=time1.replace(":", "");
			 String t2=time2.replace(":", "");
			 String time3 = "09:00";
			 String t3 = time3.replace(":", "");
			 String time6 = "17:00";
			 String t6 = time6.replace(":", "");
			 String time8 = "19:00";
			 String t8 = time8.replace(":", "");
			 if((Integer.parseInt(t1) - Integer.parseInt(t3) > 0)){
				 late++;
			 }else if((Integer.parseInt(t2) - Integer.parseInt(t6) < 0)){
				 early++;
			 }else if(time1.equals("") &&time2.equals("") &&check.getRemarks().equals("")){
				 absence++;
			 }else if(!time2.equals("")&&(Integer.parseInt(t2) - Integer.parseInt(t8) > 0)){
				 add++;
			 }
			
			 
		 }
		 
		 mm.setAbsence(absence);
		 mm.setAdd(add);
		 mm.setEarly(early);
		 mm.setLate(late);
		 return mm;
		 }
		return null;
	}

	// 将某月的迟到打卡的记录存到list集合中
	public List<checkMode> getLate(int id, String ymonth) {
		List<checkMode> list = selectrec(id, ymonth);
		List<checkMode> list2 = new ArrayList<checkMode>();
		for (int i = 0; i < list.size(); i++) {
			checkMode bean = list.get(i);
			String time1 = bean.getTime1();

			String t1 = time1.replace(":", "");// 去除时间中的：，例如将08:25变为0825

			String time3 = "09:00";
			

			String t3 = time3.replace(":", "");
			

			if ((Integer.parseInt(t1) - Integer.parseInt(t3) > 0))
					 {
				list2.add(bean);
			}

		}
		return list2;
	}

	// 将某月的早退打卡的记录存到list集合中
	public List<checkMode> getEarly(int id, String ymonth) {
		List<checkMode> list = selectrec(id, ymonth);
		List<checkMode> list3 =  new ArrayList<checkMode>();
		for (int i = 0; i < list.size(); i++) {
			checkMode bean = list.get(i);

			String time2 = bean.getTime2();
			// 去除时间中的：，例如将08:25变为0825
			String t2 = time2.replace(":", "");

			
			String time6 = "17:00";

			
			String t6 = time6.replace(":", "");

			if ((Integer.parseInt(t2) - Integer.parseInt(t6) < 0)) {
				list3.add(bean);
			}
		}
		return list3;
	}

	// 将某月的旷工打卡的记录存到list集合中
	public List<checkMode> getAbsence(int id, String ymonth) {
		List<checkMode> list = selectrec(id, ymonth);
		List<checkMode> list4 =  new ArrayList<checkMode>();
		for (int i = 0; i < list.size(); i++) {
			checkMode bean = list.get(i);
             String remarks=bean.getRemarks();
			String time1 = bean.getTime1();
			String time2 = bean.getTime2();

			if (time1.equals("") &&time2.equals("") &&remarks.equals("")) {
				list.add(bean);
			}
		}
		return list4;
	}

	// 将某月的加班打卡的记录存到list集合中
		public List<checkMode> getAdd(int id, String ymonth){
		List<checkMode> list = selectrec(id, ymonth);
		List<checkMode> list5 =  new ArrayList<checkMode>();
		for (int i = 0; i < list.size(); i++) {
			checkMode bean = list.get(i);
			
			String time2 = bean.getTime2();
			// 去除时间中的：，例如将08:25变为0825
			String t2 = time2.replace(":", "");

			
			String time8 = "19:00";
			
			String t8 = time8.replace(":", "");

			 if ((Integer.parseInt(t2) - Integer.parseInt(t8) > 0)) {
				list5.add(bean);
			} 
		}
		return list5;
	}
}