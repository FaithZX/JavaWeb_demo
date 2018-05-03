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
			//��������������
			InputStream inputStream = new FileInputStream("E:/test.xls");
			// ��������������
			HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
			// ����user���϶������ڴ洢Excel�������Ϣ
			List<User> userList = new ArrayList<User>();
			
			
			//  �Ƿ����õ�excelҳǩ
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				
				HSSFSheet sheetAt = workbook.getSheetAt(i);
				//  �����ھͽ���ѭ��
				if(null == sheetAt) {
					continue;
				}
				
				//  �Ƿ����row
				for (int j = 0; j < sheetAt.getPhysicalNumberOfRows(); j++) {
					
					// �õ��� j+2 ��  ǰ�����Ǳ��� 
					HSSFRow row = sheetAt.getRow(2+j); 
					// ������row�ͽ���ѭ��
					if(null == row) {
						continue;
					}
					
					// �洢һ�е�ÿ����Ԫ���õ���ֵ
					User user = new User();
					
					// �õ���һ����Ԫ���ֵ   ��Ԫ���0��ʼ
					HSSFCell cell0 = row.getCell(0);
					Float f = Float.parseFloat(cell0.toString());
					user.setId(f.intValue());
					
					// �ڶ�����Ԫ���ֵ
					HSSFCell cell1 = row.getCell(1);
					user.setUsername(cell1.toString());
					
					//������
					HSSFCell cell2 = row.getCell(2);
					user.setPassword(cell2.toString());
					
					//���ĸ�
					HSSFCell cell3 = row.getCell(3);
					Float a = Float.parseFloat(cell3.toString());
					user.setAge(a.intValue());
					
					// �����
					HSSFCell cell4 = row.getCell(4);
					user.setSex(cell4.toString());
					
					//������
					HSSFCell cell5 = row.getCell(5);
					user.setBirth(new SimpleDateFormat("yyyy-MM-dd").parse(cell5.toString()));
					
					
					userList.add(user);
				}
			}
			//  �����Ϣ  �鿴�Ƿ���ȷ
			System.out.println(userList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
