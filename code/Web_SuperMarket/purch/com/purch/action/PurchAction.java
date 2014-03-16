package com.purch.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import com.employee.EmployeeBean;
import com.goods.ProductBean;
import com.mvc.http.aware.HttpAware;
import com.purch.bean.PurchBean;
import com.purch.bean.ReturnBean;
import com.purch.dao.PurchDao;
import com.supplier.SupplierBean;

public class PurchAction extends HttpAware{
	
	PurchDao dao=new PurchDao();
	
	public String findProduct(){
		String id=request.getParameter("name");
		int ids=Integer.parseInt(id);
		ProductBean product=dao.selectProductName(ids);
		String productName=product.getProductName();
		request.setAttribute("allName", productName);
		if(productName!=null){
		return SUCCESS;
		}
		return ERROR;
	}
	
	public String findSupplier(){
		String id=request.getParameter("name");
		int ids=Integer.parseInt(id);
		SupplierBean supplier=dao.selectSupplierName(ids);
		String companyName=supplier.getCompanyName();
		request.setAttribute("allName", companyName);
		if(companyName!=null){
		return SUCCESS;
		}
		return ERROR;
	}
	
	public String findEmployee(){
		String id=request.getParameter("name");
		int ids=Integer.parseInt(id);
		EmployeeBean employee=dao.selectEmployeeName(ids);
		String employeeName=employee.getEmployeeName();
		request.setAttribute("allName", employeeName);
		return SUCCESS;
	}
	
	
	public String excel(){
		 
         try { 
        	 InputStream is = new FileInputStream("D:\\Book2.xls"); 
             Workbook wb = Workbook.getWorkbook(is); 
             int wbNum = wb.getNumberOfSheets(); 
             for(int i = 0;i<wbNum;i++){ 
                 Sheet sheet = wb.getSheet(i); 
                 //String sheetName = sheet.getName(); 
                 //System.out.println("sheetName="+sheetName); 
                 if(sheet!=null){ 
                     // 获取表格总列数 
                     int rsColumns = sheet.getColumns(); 
                     // 获取表格总行数 
                     int rsRows = sheet.getRows(); 
                     //循环文件里的数据 
                    
                     for(int j=1;j<rsRows;j++){ 
                         Cell[] cells = sheet.getRow(j); 
                         PurchBean purch=new PurchBean();
                         for(int k=0;k<rsColumns;k++){ 
                        	 purch.setProductId(Integer.parseInt(cells[0].getContents()));
                        	 purch.setInPrice(Float.parseFloat(cells[1].getContents()));
                        	 purch.setPurchCount(Integer.parseInt(cells[2].getContents()));
                        	 purch.setPurchTime(cells[3].getContents());
                        	 purch.setProductTime(cells[4].getContents());
                        	 purch.setExpireTime(cells[5].getContents());
                        	 purch.setEmployeeId(Integer.parseInt(cells[6].getContents()));
                        	 purch.setCompanyId(Integer.parseInt(cells[7].getContents()));
                        	 purch.setRemarks(cells[8].getContents());
                        	
                         } 
                         dao.insertPurch(purch);
                     } 
                 } 
             } 
              
     } catch (Exception e) { 
             e.printStackTrace(); 
         }
		return SUCCESS; 
     } 
  
	public String excelReturn(){
		 
        try { 
       	 InputStream is = new FileInputStream("D:\\Book1.xls"); 
            Workbook wb = Workbook.getWorkbook(is); 
            int wbNum = wb.getNumberOfSheets(); 
            for(int i = 0;i<wbNum;i++){ 
                Sheet sheet = wb.getSheet(i); 
                //String sheetName = sheet.getName(); 
                //System.out.println("sheetName="+sheetName); 
                if(sheet!=null){ 
                    // 获取表格总列数 
                    int rsColumns = sheet.getColumns(); 
                    // 获取表格总行数 
                    int rsRows = sheet.getRows(); 
                    //循环文件里的数据 
                   
                    for(int j=1;j<rsRows;j++){ 
                        Cell[] cells = sheet.getRow(j); 
                        ReturnBean returnn=new ReturnBean();
                        for(int k=0;k<rsColumns;k++){ 
                        	returnn.setPurchId(Integer.parseInt(cells[0].getContents()));
                        	returnn.setReturnPrice(Float.parseFloat(cells[1].getContents()));
                        	returnn.setReturnCount(Integer.parseInt(cells[2].getContents()));
                        	returnn.setReturnTime(cells[3].getContents());
                        	returnn.setEmployeeId(Integer.parseInt(cells[4].getContents()));
                        	returnn.setCompanyId(Integer.parseInt(cells[5].getContents()));
                        	returnn.setRemarks(cells[6].getContents());
                       	
                        } 
                        dao.insertReturn(returnn);
                    } 
                } 
            } 
             
    } catch (Exception e) { 
            e.printStackTrace(); 
        }
		return SUCCESS; 
    } 
 
	
	
	public String deletePurch(){
		String id=request.getParameter("id");
		//String mess=id.substring(0,id.length()-1);
		if(id.length()==1){
			int ids=Integer.parseInt(id);
			dao.deletePurch(ids);
		}else{
		String a[]=id.split(",");
		for(int i=0;i<a.length;i++){
			int ids=Integer.parseInt(a[i]);
			dao.deletePurch(ids);
		}
		}
		
		return SUCCESS;
		
		
	}
	
	public String deleteReturn(){
		String id=request.getParameter("id");
		if(id.length()==1){
			int ids=Integer.parseInt(id);
			dao.deleteReturn(ids);
		}else{
			String a[]=id.split(",");
			for(int i=0;i<a.length;i++){
				int ids=Integer.parseInt(a[i]);
				dao.deleteReturn(ids);
			}
		}
		return SUCCESS;
	}
	
	
	public String purchList(){
		List<PurchBean> purchList=dao.purchList();
		request.setAttribute("list",purchList);
		return SUCCESS;
	}
	
	public String insertPurch(){
		PurchBean purch=new PurchBean();
		purch.setProductId(Integer.parseInt(request.getParameter("productId")));
		purch.setInPrice(Float.parseFloat(request.getParameter("inPrice")));
		purch.setPurchCount(Integer.parseInt(request.getParameter("purchCount")));
		purch.setProductTime(request.getParameter("productTime"));
		purch.setPurchTime(request.getParameter("purchTime"));
		purch.setExpireTime(request.getParameter("expireTime"));
		purch.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
		purch.setCompanyId(Integer.parseInt(request.getParameter("companyId")));
		purch.setRemarks(request.getParameter("remarks"));
		int row=dao.insertPurch(purch);
		if(row!=0){
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String findPurch(){
		String id=request.getParameter("id");
		int ids=Integer.parseInt(id);
		PurchBean purch=dao.findPurch(ids);
		request.setAttribute("onePurch",purch);
		if(purch!=null){
			return SUCCESS;
		}
		return ERROR;
	}
	
	
	
	public String purchUpdate(){
		PurchBean purch=new PurchBean();
		purch.setPurchId(Integer.parseInt(request.getParameter("purchId")));
		purch.setProductId(Integer.parseInt(request.getParameter("productId")));
		purch.setInPrice(Float.parseFloat(request.getParameter("inPrice")));
		purch.setPurchCount(Integer.parseInt(request.getParameter("purchCount")));
		purch.setProductTime(request.getParameter("productTime"));
		purch.setPurchTime(request.getParameter("purchTime"));
		purch.setExpireTime(request.getParameter("expireTime"));
		purch.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
		purch.setCompanyId(Integer.parseInt(request.getParameter("companyId")));
		purch.setRemarks(request.getParameter("remarks"));
		int row=dao.updatePurch(purch);
			return SUCCESS;
	}
	
	
	
	//jkdfhurijgr
	
	
	public String returnList(){
		List<ReturnBean> returnList=dao.returnList();
		request.setAttribute("list",returnList);
		return SUCCESS;
	}
	
	public String insertReturn(){
		ReturnBean returnn=new ReturnBean();
		returnn.setPurchId(Integer.parseInt(request.getParameter("purchId")));
		returnn.setReturnPrice(Float.parseFloat(request.getParameter("returnPrice")));
		returnn.setReturnCount(Integer.parseInt(request.getParameter("returnCount")));
		returnn.setReturnTime(request.getParameter("returnTime"));
		returnn.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
		returnn.setCompanyId(Integer.parseInt(request.getParameter("companyId")));
		returnn.setRemarks(request.getParameter("remarks"));
		int row=dao.insertReturn(returnn);
		if(row!=0){
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String findReturn(){
		String id=request.getParameter("id");
		int ids=Integer.parseInt(id);
		ReturnBean returnn=dao.findReturn(ids);
		request.setAttribute("oneReturn",returnn);
		if(returnn!=null){
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String returnUpdate(){
		ReturnBean returnn=new ReturnBean();
		returnn.setReturnId(Integer.parseInt(request.getParameter("returnId")));
		returnn.setPurchId(Integer.parseInt(request.getParameter("purchId")));
		returnn.setReturnPrice(Float.parseFloat(request.getParameter("returnPrice")));
		returnn.setReturnCount(Integer.parseInt(request.getParameter("returnCount")));
		returnn.setReturnTime(request.getParameter("returnTime"));
		returnn.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
		returnn.setCompanyId(Integer.parseInt(request.getParameter("companyId")));
		returnn.setRemarks(request.getParameter("remarks"));
		int row=dao.updateReturn(returnn);
			return SUCCESS;
	}


}
