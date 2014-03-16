package com.record;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mvc.http.aware.HttpAware;
import com.part.PartDao;

public class CheckAction extends HttpAware{
	
	CheckDao dao=new CheckDao();
	/**
	 * 添加编辑员工
	 * @return
	 */
	public String listEmployee(){
		List<String> deptList = dao.selectAllemdept();
		List<String> employeeList = dao.selectAllemployee();
		if(deptList!=null ||employeeList!=null){
			request.setAttribute("deptList", deptList);
			request.setAttribute("EmployList", employeeList);
			return SUCCESS;	
		}else{
			return ERROR;
		}
	}
	
//	更新与员工考勤信息
	public String updateCheck(){
		int row=0;
		Check ck=new Check();
		ck.setSalaryId(Integer.parseInt(request.getParameter("salaryId")));
		ck.setDeptId(Integer.parseInt(request.getParameter("deptId")));
		ck.setEmployeeName(request.getParameter("employeeName"));
		ck.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
		ck.setDateTime(request.getParameter("dateTime"));
		ck.setWeeks(request.getParameter("weeks"));
		ck.setTime1(request.getParameter("Time1"));
		ck.setTime2(request.getParameter("time2"));
		ck.setRemarks(request.getParameter("remarks"));
	row=dao.updateCheck(ck);
		if(row!=0){
			return SUCCESS;
		}
		return ERROR;
	}
	//按流水号查找员工考勤信息
	public String findCheck(){
		int id=Integer.parseInt(request.getParameter("id"));
		Check ck=dao.findUser(id);
		if(ck!=null){
			request.setAttribute("check", ck);
			return SUCCESS;
		}
		return ERROR;
	}
//	插卡看考勤信息
	public String listcheck(){
		List<Check> list=dao.selectAll();
		if(list!=null){
		request.setAttribute("list", list);
		return SUCCESS;
		}
		return ERROR;
	}
//	插入考勤信息
	public String CheckInsert(){
		Check ck=new Check();
		String ids=request.getParameter("deptId");
		String id=ids.split("-")[0];
		String ei=request.getParameter("employeeId");
		ck.setDeptId(Integer.parseInt(id));
		ck.setEmployeeName(ei.split("-")[1]);
		ck.setEmployeeId(Integer.parseInt(ei.split("-")[0]));
		ck.setDateTime(request.getParameter("dateTime"));
		ck.setWeeks(request.getParameter("weeks"));
		ck.setTime1(request.getParameter("Time1"));
		ck.setTime2(request.getParameter("time2"));
		ck.setRemarks(request.getParameter("remarks"));
		int row=dao.insertCheck(ck);
		
		if(row!=0){
			
			return SUCCESS;
		}
		return ERROR;
	}
	
	
	
	public String UploadFile() {
		// 判断请求的方式是否可作为上传
//		boolean b = ServletFileUpload.isMultipartContent(request);
//		if (b) {
			// 获取当前工程的发布目录
//			String path = CheckAction.class.getResource("/").toString();
//			System.out.println(path);
			int row=0;
			String path=request.getRealPath("Upload");
//            String path = "D://Upload/Check";			
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
			// 设置临时存储空间
			DiskFileItemFactory disc = new DiskFileItemFactory();
			disc.setRepository(file);
			ServletFileUpload suf = new ServletFileUpload(disc);
			suf.setSizeMax(1024 * 1024 * 10);
			// 在请求中获取上传的文件
			try {
				List<DiskFileItem> list=suf.parseRequest(request);
				
				for(int i=0;i<list.size();i++){
					DiskFileItem disk=list.get(i);
					
					//获取上传文件的路劲
					String filePath=disk.getName();
					if(filePath.endsWith(".xls")){
					//获取文件的名字，依他的名字来命名文件
					File uploadFile=new File(filePath);
					String upName=uploadFile.getName();
					
					File files=new File(file,upName);
//					System.out.println(files);
					
					FileOutputStream fos=new FileOutputStream(files);
					InputStream is=disk.getInputStream();
					int k=0;
					while((k=is.read())!=-1){
						fos.write(k);
					}
					is.close();
					fos.flush();
					fos.close();
					row=jiexiexcel(files);
				}
					break;
				}
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			response.sendRedirect("ListUpload");
//		}
			
			if(row>0){
				return SUCCESS;
				
			}
			
			return ERROR;
	}
	
	public int jiexiexcel(File fileName){
		int row=0;
		FileInputStream in;
		try {
			in = new FileInputStream(fileName);
			Workbook wb;
			wb = Workbook.getWorkbook(in);
//			System.out.println("11111");
			List<Check> list = new ArrayList<Check>();
			// 得到excel表格的数量
			int num = wb.getNumberOfSheets();
			for (int i = 0; i < num; i++) {
				// 得到每张表
				Sheet sheet = wb.getSheet(i);
				String sheetName = sheet.getName();
				if (sheet != null) {
					// 获取表格总列数
					int cols = sheet.getColumns();
					// 获取表格总行数
					int rows = sheet.getRows();
					// 循环文件里的数据
					for (int t = 1; t < rows; t++) {
						// 得到一行的数据数组
						Cell[] cells = sheet.getRow(t);
						Check ck = null;
						for (int k = 0; k < cols; k++) {
							ck = new Check();
							ck.setDeptId(Integer.parseInt(cells[1]
									.getContents()));
							ck.setEmployeeName(cells[2].getContents());
							ck.setEmployeeId(Integer.parseInt(cells[3]
									.getContents()));
							ck.setDateTime(cells[4].getContents());
//							System.out.println(ck.getDateTime());
							ck.setWeeks(cells[5].getContents());
							ck.setTime1(cells[6].getContents());
							ck.setTime2(cells[7].getContents());
							ck.setRemarks(cells[8].getContents());
						}
						list.add(ck);
					}
				}
			}
			CheckDao dao = new CheckDao();
			row=dao.insertCheck(list);
//			文件是否存在
//			if (row > 0) {
////				System.out.println("已经解析到数据库了");
//			
//			}
			wb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		fileName.delete();
		return row;
		
	}
	public String exportToxls(){
		String path=request.getRealPath("Save");
		CheckDao dao = new CheckDao();
		Vector<String> columnName = new Vector<String>(); // 列名	
		columnName.add("序号");
		columnName.add("部门");
		columnName.add("姓名");
		columnName.add("工号");
		columnName.add("刷卡日期");
		columnName.add("星期");
		columnName.add("打卡1");
		columnName.add("打卡2");
		columnName.add("备注");
		ResultSet rs = dao.selectBean();
		if(rs == null){
			return ERROR;
		}else{
			WriteExcel(rs, path, "考勤信息", columnName,request,response);	
			return SUCCESS;
		}
	}
	public void WriteExcel(ResultSet rs, String filePath, String sheetName, Vector<String> columnName,HttpServletRequest req, HttpServletResponse resp) {
		String name = null;
		WritableWorkbook workbook = null;
		WritableSheet sheet = null;	
		int rowNum = 1; // 从第一行开始写入
		try {
			File f = new File(filePath);
			if(!f.exists()){
				f.mkdirs();
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			Date date = new Date();
			name = sdf.format(date)+".xls";
			File file = new File(f,name);
			workbook = Workbook.createWorkbook(file); // 创建Excel文件
			sheet = workbook.createSheet(sheetName, 0); // 创建名为 sheetName 的工作簿	
			
			this.writeCol(sheet, columnName, 0); // 首先将列名写入
			// 将结果集写入
			while(rs.next()) {
				Vector<String> col = new Vector<String>(); // 用以保存一行数据
				
				for(int i = 1; i <= columnName.size(); i++) { // 将一行内容保存在col中
					col.add(rs.getString(i));
				}
				// 写入Excel
				this.writeCol(sheet, col, rowNum++);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				// 关闭
				workbook.write();
				workbook.close();
				rs.close();//FileName
				export(name,req,resp);
			}catch(Exception e) {
//				e.printStackTrace();
			}
		}
	}
	/***	
	 * @param sheet 
	 * @param col 
	 * @param rowNum 
	 * @throws WriteException 
	 * @throws RowsExceededException 
	 */
	public void writeCol(WritableSheet sheet, Vector<String> col, int rowNum) throws RowsExceededException, WriteException {
		int size = col.size(); // 获取集合大小
		
		for(int i = 0; i < size; i++) { // 写入每一列
			Label label = new Label(i, rowNum, col.get(i)); 
			sheet.addCell(label);
		}
	}
	public String export(String name,HttpServletRequest req, HttpServletResponse resp){
		
		try {
			req.setCharacterEncoding("GBK");
			resp.setCharacterEncoding("GBK");

			String path=req.getRealPath("Save");
			File file = new File(path+"/"+name);
			//相应文件的下载的大小
			resp.setContentLength((int)file.length());
			//设置response的编码方式 application/x-msdownload 响应给浏览器是一个文件类型  
			resp.setContentType("application/x-msdownload");
			//代码里面使用Content-Disposition来确保浏览器弹出下载对话框的时候来显示文件信息
			resp.setHeader("Content-Disposition","attachment;filename="+new String
				(name.getBytes("gbk"),"iso-8859-1")); 
			FileInputStream fis = new FileInputStream(file);
			OutputStream out = resp.getOutputStream();
			int i = 0;
			while((i=fis.read())!=-1){
				out.write(i);
			}
			fis.close();
			out.flush();
			out.close();
			file.delete();
			return SUCCESS;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		
	}
		
}

