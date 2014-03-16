package com.goods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.goodsType.GoodsTypeBean;
import com.mvc.http.aware.HttpAware;



public class ProductAction extends HttpAware{

	ProductDao dao=new ProductDao();
	//获取商品表
	public String productList(){
		List<ProductBean> productList=dao.productList();
		request.setAttribute("productList", productList);
		return SUCCESS;
	}
	
	

	//添加商品信息
	public String insertProduct(){
		ProductBean product=new ProductBean();
		product.setProductName(request.getParameter("productName"));
		String typeId=request.getParameter("productTypeId");
        typeId=typeId.substring(0, 4);		
		product.setProductTypeId(Integer.parseInt(typeId));
		product.setProductNorms(request.getParameter("productNorms"));
		product.setProductPrice(Float.parseFloat(request.getParameter("productPrice")));
		product.setProducer(request.getParameter("producer"));
		
		product.setBarCode(request.getParameter("barCode"));
		product.setRemarks(request.getParameter("remarks"));
		int row=dao.insertProduct(product);
		if(row!=0){
			return SUCCESS;
		}
		return ERROR;
	}
	
	//删除商品信息
	public String deleteProduct(){
		int row=dao.deleteProduct(Integer.parseInt(request.getParameter("productId")));
		if(row!=0){
			return SUCCESS;
		}
		return ERROR;
	}
	
	//查找一个商品
	public String selectOneProduct(){
		ProductBean product=dao.selectOneProduct(Integer.parseInt(request.getParameter("productId")));
		List<GoodsTypeBean> productTypeList=dao.getProductType();
		if(product!=null){
			request.setAttribute("product", product);
			request.setAttribute("productTypeList", productTypeList);
			return SUCCESS;
		}
		return ERROR;
	}
	
	//更新商品信息
	public String updateProduct(){
		ProductBean product=new ProductBean();
		product.setProductId(Integer.parseInt(request.getParameter("productId")));
		product.setProductName(request.getParameter("productName"));
		String typeId=request.getParameter("productTypeId");
		typeId=typeId.substring(0, 4);
		product.setProductTypeId(Integer.parseInt(typeId));
		product.setProductNorms(request.getParameter("productNorms"));
		product.setProductPrice(Float.parseFloat(request.getParameter("productPrice")));
		product.setProducer(request.getParameter("producer"));
		
		product.setBarCode(request.getParameter("barCode"));
		product.setRemarks(request.getParameter("remarks"));
		int row=dao.updateProduct(product);
		if(row!=0){
			return SUCCESS;
		}
		return ERROR;
	}
	
	//删除所选的商品信息
	public String deleteSelect(){
		String a=request.getParameter("a");
		System.out.println(a);
		String b[]=a.split(",");
		int row=0;
		for(int i=0;i<b.length;i++){
			String mess=b[i];
			System.out.println(mess);
			int mess1=Integer.parseInt(mess);
			row=dao.deleteProduct(mess1);
		}
		if(row!=0){
			return SUCCESS;
		}
		return ERROR;
	}
	
	
	public String productInsert1(){
		List<GoodsTypeBean> productTypeList=dao.getProductType();
		
		if(productTypeList!=null){
			request.setAttribute("productTypeList", productTypeList);
			return SUCCESS;
		}
		return ERROR;
	}
	
	//上传文件
	public String UploadFile() {

		int row=0;
            String path = "D://Upload/Check";			
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
	//解析excel表
	public int jiexiexcel(File fileName){
		int row=0;
		FileInputStream in;
		try {
			in = new FileInputStream(fileName);
			Workbook wb;
			wb = Workbook.getWorkbook(in);
//			System.out.println("11111");
			List<ProductBean> list = new ArrayList<ProductBean>();
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
						ProductBean product = null;
						for (int k = 0; k < cols; k++) {
							product= new ProductBean();
							
							product.setProductName(cells[1].getContents());
							product.setProductTypeId(Integer.parseInt(cells[2].getContents()));
							product.setProductNorms(cells[3].getContents());
							product.setProductPrice(Float.parseFloat(cells[4].getContents()));
							product.setProducer(cells[5].getContents());
							product.setBarCode(cells[6].getContents());
							product.setRemarks(cells[7].getContents());
						}
						ProductDao dao = new ProductDao();
						row=dao.insertProduct(product);
					}
				}
			}
			
			wb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return row;
		
	}
		
}
