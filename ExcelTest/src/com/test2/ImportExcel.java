package com.test2;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 
 * @author zhangxiang
 *
 */
public class ImportExcel {

	public static void main(String[] args) {
		
		try {
			//创建输入流对象
			InputStream inputStream = new FileInputStream("E:/test.xls");
			// 创建工作波对象
			HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
			// 创建user集合对象用于存储Excel导入的信息
			List<User> userList = new ArrayList<User>();
			
			
			//  是否能拿到excel页签
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				
				HSSFSheet sheetAt = workbook.getSheetAt(i);
				//  不存在就结束循环
				if(null == sheetAt) {
					continue;
				}
				
				//  是否存在row
				for (int j = 0; j < sheetAt.getPhysicalNumberOfRows(); j++) {
					
					// 拿到第 j+2 行  前两行是标题 
					HSSFRow row = sheetAt.getRow(2+j); 
					// 不存在row就结束循环
					if(null == row) {
						continue;
					}
					
					// 存储一行的每个单元格拿到的值
					User user = new User();
					
					// 拿到第一个单元格的值   单元格从0开始
					HSSFCell cell0 = row.getCell(0);
					Float f = Float.parseFloat(cell0.toString());
					user.setId(f.intValue());
					
					// 第二个单元格的值
					HSSFCell cell1 = row.getCell(1);
					user.setUsername(cell1.toString());
					
					//第三个
					HSSFCell cell2 = row.getCell(2);
					user.setPassword(cell2.toString());
					
					//第四个
					HSSFCell cell3 = row.getCell(3);
					Float a = Float.parseFloat(cell3.toString());
					user.setAge(a.intValue());
					
					// 第五个
					HSSFCell cell4 = row.getCell(4);
					user.setSex(cell4.toString());
					
					//第六个
					HSSFCell cell5 = row.getCell(5);
					user.setBirth(new SimpleDateFormat("yyyy-MM-dd").parse(cell5.toString()));
					
					
					userList.add(user);
				}
			}
			//  输出信息  查看是否正确
			System.out.println(userList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
