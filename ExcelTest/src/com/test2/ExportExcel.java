package com.test2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

public class ExportExcel {
	
	public static void main(String[] args) {
		try {
			// 创建一个工作簿
			HSSFWorkbook workbook = new HSSFWorkbook();
			CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, 5);
			HSSFCellStyle headStyle = getStyle(workbook,(short) 15);
			HSSFCellStyle colStyle = getStyle(workbook,(short) 12);
			
			//新建一个excel页签
			HSSFSheet createSheet = workbook.createSheet("用户信息列表");
			// 将合并表格的对象添加页签中
			createSheet.addMergedRegion(cellRangeAddress);
			// 设置单元格的默认宽度
			createSheet.setDefaultColumnWidth(25);
			
			// 创建一行
			HSSFRow row0 = createSheet.createRow(0);
			HSSFCell cell0 = row0.createCell(0);
			// 添加标题样式
			cell0.setCellStyle(headStyle);
			// 添加标题
			cell0.setCellValue("用户信息列表");
			
			//设置列的标题
			String [] titles = {"id","用户名","密码","年龄","性别","生日"};
			HSSFRow row1 = createSheet.createRow(1);
			//  循环往excel中添加列标题
			for (int i = 0; i < titles.length; i++) {
				HSSFCell cell1 = row1.createCell(i);
				cell1.setCellStyle(colStyle);
				cell1.setCellValue(titles[i]);
			}
			
			List<User> userList = new ArrayList<User>();
			
			userList.add(new User(1,"zhangsan1","123","男",21,new Date()));
			userList.add(new User(2,"zhangsan2","456","男",21,new Date()));
			userList.add(new User(3,"zhangsan3","789","女",21,new Date()));
			userList.add(new User(4,"zhangsan4","000","男",21,new Date()));
			
			for (int i = 0; i < userList.size(); i++) {
				//创建第三行
				HSSFRow row2 = createSheet.createRow(i + 2);
				
				HSSFCell cell_0 = row2.createCell(0);
				cell_0.setCellValue(userList.get(i).getId());
				
				
				HSSFCell cell_1 = row2.createCell(1);
				cell_1.setCellValue(userList.get(i).getUsername());
				
				
				HSSFCell cell_2 = row2.createCell(2);
				cell_2.setCellValue(userList.get(i).getPassword());
				
				HSSFCell cell_3 = row2.createCell(3);
				cell_3.setCellValue(userList.get(i).getAge());
				
				HSSFCell cell_4 = row2.createCell(4);
				cell_4.setCellValue(userList.get(i).getSex());
				
				
				HSSFCell cell_5 = row2.createCell(5);
				cell_5.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(userList.get(i).getBirth()));
				
			}
			
			OutputStream os = new FileOutputStream("E:/test.xls");
			workbook.write(os);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static HSSFCellStyle getStyle(HSSFWorkbook workbook,short fontSize) {
		// 创建样式对象
		HSSFCellStyle createCellStyle = workbook.createCellStyle();
		//水平居中
		createCellStyle.setAlignment(HorizontalAlignment.CENTER);
		//垂直居中
		createCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		// 设置边框
		createCellStyle.setBorderBottom(BorderStyle.THIN);
		createCellStyle.setBorderLeft(BorderStyle.THIN);
		createCellStyle.setBorderRight(BorderStyle.THIN);
		createCellStyle.setBorderTop(BorderStyle.THIN);
		
		//  创建一个字体对象
		HSSFFont createFont = workbook.createFont();
		// 设置字体的大小
		createFont.setFontHeightInPoints(fontSize);
		// 设置字体类型
		createFont.setFontName("微软雅黑");
		// 设置字体的颜色
		createFont.setColor(HSSFColor.RED.index);
		
		//将字体放置到样式中
		createCellStyle.setFont(createFont);
		return createCellStyle;
	}
	
}
