package com.sales.action;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.employee.EmployeeBean;
import com.employee.EmployeeDao;
import com.goods.ProductBean;
import com.mvc.http.aware.HttpAware;
import com.sales.bean.OnSaleProductBean;
import com.sales.bean.SalesBean;
import com.sales.dao.SalesDao;

public class SalesAction extends HttpAware {

	SalesDao dao = new SalesDao();
	
	
	
	
	//输入条形码，获取商品信息
	public String inquireProductData(){
		String barcode=request.getParameter("barcode");
		ProductBean bean=dao.selectOneProduct(barcode);
		
		
		String vipId=request.getParameter("vipId");//获取页面的会员卡号码
		System.out.println("页面传递过来的vipId："+vipId);
		HttpSession session=request.getSession();
		int seVipid = 0;
		if(session.getAttribute("seVipId")!=null){//预判session防止报错
			seVipid=(Integer) session.getAttribute("seVipId");//获取session的会员卡号码
			System.out.println("session里面获取的vipId："+seVipid);
			
		}

		
		if(vipId.equals("")&&seVipid==0){//页面会员卡号为空并且session为0，表示没有使用会员卡
			session.setAttribute("seVipId", 0);
			
		}
		if(!vipId.equals("")){//页面获取的不为空，session里面置为该会员Id
			session.setAttribute("seVipId", Integer.parseInt(vipId));
			
		}
		if(vipId.equals("")&&seVipid!=0){//页面为空，session里面有值,说明不是该顾客的第一次商品查询
			//不作处理
			
		}
		
		
		
		if(bean!=null){
			request.setAttribute("productData", bean);
			return SUCCESS;
		}
		return ERROR;
	}
	
	
	public String addToBuyList(){
		//每查询到一个商品信息，就把商品放到session里面
		HttpSession session=request.getSession();
		
		OnSaleProductBean salebean=new OnSaleProductBean();//结账过程中用到的bean
		
		
		String barcode=request.getParameter("barcode");
		ProductBean pbean=dao.selectOneProduct(barcode);//查询商品信息
		salebean.setProductId(pbean.getProductId());
		salebean.setProductName(pbean.getProductName());
		salebean.setProductPrice(pbean.getProductPrice());
		salebean.setProducer(pbean.getProducer());
		
		String count=request.getParameter("count");//获取购物数量
		salebean.setCount(Integer.parseInt(count));
		
		if(session.getAttribute("seVipId")!=null){
			int vipId=(Integer) session.getAttribute("seVipId");//获取会员卡号码
			salebean.setVipId(vipId);//添加到清单的时候一律以session为准
			System.out.println("添加到清单的VIPId："+vipId);
		}else{
			
			salebean.setVipId(0);//添加到清单的时候一律以session为准,session获取不到的时候置为默认的0
			System.out.println("添加到清单的VIPId："+0);
		}
		
		
//		System.out.println(request.getSession().getAttribute("loginId"));
		String employeeId=String.valueOf(request.getSession().getAttribute("loginId"));//获取收银员的信息
//		System.out.println(employeeId);
		EmployeeDao  edao=new EmployeeDao();
		EmployeeBean ebean=edao.findEmployee(Integer.parseInt(employeeId));
//		System.out.println(ebean);
		salebean.setEmployeeId(Integer.parseInt(employeeId));
		salebean.setEmployeeName(ebean.getEmployeeName());
		
		salebean.setSoloprice(pbean.getProductPrice()*Integer.parseInt(count));//某种商品的价钱
		
		salebean.setPayType("");
		salebean.setReMarks("");
	
				
//四舍五入的格式化方法				
//				double   f   =   111231.5585; 
//				BigDecimal   b   =   new   BigDecimal(f); 
//				double   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
				
			
			if(session.getAttribute("buyList")==null){
				float addPrice=0;
				List<OnSaleProductBean> buyList=new ArrayList<OnSaleProductBean>();
				buyList.add(salebean);
				addPrice=addPrice+pbean.getProductPrice()*Integer.parseInt(count);//应付金额
				
				BigDecimal   b   =   new   BigDecimal(addPrice); 
				float f2=b.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();
				
				session.setAttribute("addPrice", f2);
				session.setAttribute("buyList", buyList);
			}else{
				List<OnSaleProductBean> buyList=(List<OnSaleProductBean>) session.getAttribute("buyList");
				buyList.add(salebean);
				float  addPrice=(Float) session.getAttribute("addPrice");
				addPrice=addPrice+pbean.getProductPrice()*Integer.parseInt(count);//应付金额
				
				BigDecimal   b   =   new   BigDecimal(addPrice); 
				float f2=b.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();
				
				session.setAttribute("addPrice", f2);
				session.setAttribute("buyList", buyList);
				
//				session.setMaxInactiveInterval(20);
				
			}
					
					return SUCCESS;
		
	}
	
	
	public String clearList(){//清空购买清单
		
		HttpSession session=request.getSession();
		
		session.removeAttribute("seVipId");
		session.removeAttribute("buyList");
		session.removeAttribute("addPrice");
//		session.setAttribute("seVipId", 0);
		
		return SUCCESS;
		
	}
	
	
	public String deletePro(){
		
//		System.out.println("action-dele");
		String proid=request.getParameter("proid");
//		System.out.println(proid);
		
		HttpSession session=request.getSession();
		List<OnSaleProductBean> buyList=(List<OnSaleProductBean>) session.getAttribute("buyList");
		float  addPrice=(Float) session.getAttribute("addPrice");
		for(int i=0;i<buyList.size();i++){
			
			
			
			OnSaleProductBean osb=buyList.get(i);
			if((osb.getProductId()+"").equals(proid)){
//				System.out.println(i);
				addPrice=addPrice-osb.getProductPrice()*osb.getCount();
				buyList.remove(i);
				break;
			}
		}
		
		BigDecimal   b   =   new   BigDecimal(addPrice); 
		float f2=b.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();
		
		session.setAttribute("addPrice", f2);
		
		session.setAttribute("buyList", buyList);

		
		
		
		
		return SUCCESS;
		
	}
	public String finishOneDeal(){
		
		HttpSession session=request.getSession();
		List<OnSaleProductBean> buyList=null;
		
		
		if(session.getAttribute("buyList")!=null){
			buyList=(List<OnSaleProductBean>) session.getAttribute("buyList");
			
		}else{
			
			return ERROR;
		}
		
		
		String paytype=request.getParameter("PayType");
		
		
		for(int i=0;i<buyList.size();i++){
			
			OnSaleProductBean osb=buyList.get(i);
			SalesBean sb=new SalesBean();
			
//			private int salesId;//主键
//			private int productId;//商品Id--商品表
//			private float productPrice;//商品售价
//			private int count;//顾客购买的数量
//			private int employeeId;//收银员的员工编号
//			private String salesTime;//时间
//			private String salesWaterNo;//交易流水号（收银员工编号+交易时间）
//			private int vipId;//会员Id
//			private String payType;//付款方式(现金或刷卡或者网银)
//			private String remarks;//备注
			sb.setProductId(osb.getProductId());
			sb.setProductPrice(osb.getProductPrice());
			sb.setCount(osb.getCount());
			sb.setEmployeeId(osb.getEmployeeId());
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String s=sdf.format(date);
			String s1=s.replace("-", "");
			String s2=s1.replace(" ", "");
			String s3=s2.replace(":", "");
//			System.out.println(s3);
			sb.setSalesTime(s3);
			sb.setSalesWaterNo(osb.getEmployeeId()+s3);
			
			sb.setVipId(osb.getVipId());
			
//			String vipId=(String) session.getAttribute("vipId");
//			if(vipId.equals("")){
//				sb.setVipId(0000);
//			}else{
//				sb.setVipId(Integer.parseInt(vipId));
//			}
			
			sb.setPayType(paytype);
			sb.setRemarks("");
			
			dao.insertSales(sb);//保存交易记录到销售表
			
			
			if(osb.getVipId()!=0){	//增加会员积分
				System.out.println(osb.getVipId());
				int jifen=dao.getJifen(osb.getVipId());
				System.out.println("原有积分："+jifen);
				jifen=(int) (jifen+osb.getProductPrice()*osb.getCount());
				System.out.println("增加之后的积分："+jifen);
				dao.upJifen(osb.getVipId(),jifen);
				
			}
		
			
			
		}
		session.removeAttribute("seVipId");
		session.removeAttribute("buyList");
		session.removeAttribute("addPrice");
//		session.setAttribute("seVipId", 0);
		
//		session.invalidate();
		
		
		return SUCCESS;
		
	}

	public String getSalesList() {
		
		
		
		List<SalesBean> list = dao.getSalesList();


		if (list != null) {
			request.setAttribute("salesList", list);
			return SUCCESS;

		} else {
			return ERROR;

		}

	}
	

	

	public String findSalesData(){
		int id=Integer.parseInt(request.getParameter("id"));
		SalesBean sb=dao.findSalesData(id);
		if(sb!=null){
			request.setAttribute("salesData", sb);
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String salesDetails(){
		int id=Integer.parseInt(request.getParameter("id"));
		SalesBean sb=dao.findSalesData(id);
		if(sb!=null){
			request.setAttribute("salesData", sb);
			return SUCCESS;
		}
		return ERROR;
	}
	
}
