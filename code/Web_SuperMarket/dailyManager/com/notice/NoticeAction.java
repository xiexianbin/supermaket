package com.notice;

import java.util.List;

import com.mvc.http.aware.HttpAware;

public class NoticeAction extends HttpAware{
    NoticeDao dao =new NoticeDao();
    
    //获得登陆用户所在的部门
    public String getdeptName(){
    	String dname=request.getSession().getAttribute("loginDept").toString();
    	System.out.println(dname);
    	request.setAttribute("dename", dname);
    	return SUCCESS;
    }
    //添加公告
	public  String insertNotice(){
		
	String title=	request.getParameter("title");
	//String deptName = request.getParameter("deptName");
	String time = request.getParameter("time");
	String content = request.getParameter("content");
	String remark= request.getParameter("remarks");
	int deptId=Integer.parseInt(request.getSession().getAttribute("loginDeptId").toString());
	//String deptName=dao.getDeptName(deptId);
		NoticeBean notice = new NoticeBean();
		notice.setDeptId(deptId);
		notice.setNoticeTitle(title);
		notice.setNoticeTime(time);
		notice.setNoticeContent(content);
		notice.setRemarks(remark);
		notice.setLookCount(0);
	int row=	dao.insertNotice(notice);
	if(row!=0){
		//request.setAttribute("deptName", deptName);
		return SUCCESS;
	}
		
	return ERROR;	
		
		
		
		
	}
	
	//查看所有公告
	public String noticeList(){
//		System.out.println("noticeList();");
		List<NoticeBean> list=dao.selectAll();
	List<DeptBean> deptbean=dao.getAlldept();
		request.setAttribute("noticeAll", list);
		request.setAttribute("dept", deptbean);
//		System.out.println(list.size());
		return SUCCESS;
	}
	
	//根据公告编号，查看某一详细公告
	
	public String noticeOne(){
	
		String ids=request.getParameter("id");
		
	NoticeBean nobean=dao.noticeOne(Integer.parseInt(ids));
	
	NoticeBean nnbean = new NoticeBean ();
	
	nnbean.setDeptId(nobean.getDeptId());
	nnbean.setNoticeId(nobean.getNoticeId());
	nnbean.setNoticeTitle(nobean.getNoticeTitle());
	nnbean.setNoticeContent(nobean.getNoticeContent());
	nnbean.setNoticeTime(nobean.getNoticeTime());
	nnbean.setRemarks(nobean.getRemarks());
	nnbean.setLookCount(nobean.getLookCount()+1);
	
	int row= dao.updateNotice(nnbean);
	if(row!=0){
		NoticeBean notbean=dao.noticeOne(Integer.parseInt(ids));
	request.setAttribute("notbean", notbean);
	return SUCCESS;
	}
	
	return ERROR;

		
	}
	
	//查看某一部门的发布的公告
	public String selectDept(){
		
	String id=	request.getParameter("ids");
	System.out.println(id);
	List<NoticeBean> nbean = dao.selectDept(Integer.parseInt(id));
	request.setAttribute("deptNotice", nbean);
	
	return SUCCESS;
	}
	
	
	
	
}

	
	

