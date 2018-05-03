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
			// ����һ��������
			HSSFWorkbook workbook = new HSSFWorkbook();
			CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, 5);
			HSSFCellStyle headStyle = getStyle(workbook,(short) 15);
			HSSFCellStyle colStyle = getStyle(workbook,(short) 12);
			
			//�½�һ��excelҳǩ
			HSSFSheet createSheet = workbook.createSheet("�û���Ϣ�б�");
			// ���ϲ����Ķ������ҳǩ��
			createSheet.addMergedRegion(cellRangeAddress);
			// ���õ�Ԫ���Ĭ�Ͽ��
			createSheet.setDefaultColumnWidth(25);
			
			// ����һ��
			HSSFRow row0 = createSheet.createRow(0);
			HSSFCell cell0 = row0.createCell(0);
			// ��ӱ�����ʽ
			cell0.setCellStyle(headStyle);
			// ��ӱ���
			cell0.setCellValue("�û���Ϣ�б�");
			
			//�����еı���
			String [] titles = {"id","�û���","����","����","�Ա�","����"};
			HSSFRow row1 = createSheet.createRow(1);
			//  ѭ����excel������б���
			for (int i = 0; i < titles.length; i++) {
				HSSFCell cell1 = row1.createCell(i);
				cell1.setCellStyle(colStyle);
				cell1.setCellValue(titles[i]);
			}
			
			List<User> userList = new ArrayList<User>();
			
			userList.add(new User(1,"zhangsan1","123","��",21,new Date()));
			userList.add(new User(2,"zhangsan2","456","��",21,new Date()));
			userList.add(new User(3,"zhangsan3","789","Ů",21,new Date()));
			userList.add(new User(4,"zhangsan4","000","��",21,new Date()));
			
			for (int i = 0; i < userList.size(); i++) {
				//����������
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
		// ������ʽ����
		HSSFCellStyle createCellStyle = workbook.createCellStyle();
		//ˮƽ����
		createCellStyle.setAlignment(HorizontalAlignment.CENTER);
		//��ֱ����
		createCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		// ���ñ߿�
		createCellStyle.setBorderBottom(BorderStyle.THIN);
		createCellStyle.setBorderLeft(BorderStyle.THIN);
		createCellStyle.setBorderRight(BorderStyle.THIN);
		createCellStyle.setBorderTop(BorderStyle.THIN);
		
		//  ����һ���������
		HSSFFont createFont = workbook.createFont();
		// ��������Ĵ�С
		createFont.setFontHeightInPoints(fontSize);
		// ������������
		createFont.setFontName("΢���ź�");
		// �����������ɫ
		createFont.setColor(HSSFColor.RED.index);
		
		//��������õ���ʽ��
		createCellStyle.setFont(createFont);
		return createCellStyle;
	}
	
}
