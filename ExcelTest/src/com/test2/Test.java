package com.test2;

import java.util.ArrayList;
import java.util.List;


/**

��֪���������ǵ�sql����ǰ�˴������Ĳ������ϣ��ò����滻sql�������ǣ������Ƕ�Ӧ�Ĳ������ڣ���ֱ���滻����������ڣ�Ҫ�Ѷ�Ӧ��һ������ȥ�������ó�һ�������ڲ�ѯ��sql��䡣Ҫ������������룬������ϱ�Ҫ��ע�͡�
����:��֪ 1�����������ǵ�sql��� select * from T1 where 1=1 and a = :aa  and (b =:bb or b =:cc) and e like :ee
       2��ǰ�˴������Ĳ����� aa= "111" , bb= "222", cc= "333",dd = "444"
�õ� select * from T1 where 1=1 and a = 111 and (b = 222 or b = 333)
�ò����滻sql�������ǣ������Ƕ�Ӧ�Ĳ������ڣ���ֱ���滻����������ڣ�Ҫ�Ѷ�Ӧ��һ������ȥ�������ó�һ�������ڲ�ѯ��sql��䣬���������ڲ�ѯ��sql��䡣
@param labelSql ���б�ǵ�sql���, ��select * from T1 where 1=1 and a = :aa  and (b =:bb or b =:cc) and e like :ee
@param param �������ϣ���aa= "111" , bb= "222", cc= "333",dd = "444"
@return �����ڲ�ѯ��sql,��select * from T1 where 1=1 and a = 111 and (b = 222 or b = 333)
Ҳ�ɴ��������������û��bb = 222,Ӧ����ô����

���ֻ�б��AAû������ȥ����AA��ص��������õ���������ֻ�б��BBû������ȥ����BB��ص��������õ�������������ֻ�б��CC��DDû������ȥ����CC��DD��ص��������õ�������������ֻ��AA��DD��EEû������ȥ����AA��DD��EE��ص��������õ���������ԱȲ������������ҹ��ɡ��ҳ����ɣ��ٶ��ְ���˼·ʵ�֡�

����ˣ������������ȥ���� 
1) sql: select * from T1 where 1=1 and (((a = :aa or B like :bb or c in (:cc)) and d in (:dd) ) or e = :ee) and f like :ff
2��������GG = "1223" , aa = "first"
���յõ� select * from T1 where 1=1  
Ҳ��һ�£���Щ����в�������Щ���û�в����������ս���Ƿ���ȷ
 
@author Administrator

 */
public class Test {
	
	public static void main(String[] args) {
		//String sql = "select * from T1 where 1=1 and a = :aa and (b = :bb or b = :cc) and e like :ee";
		//String sql = "select * from t1 where 1=1 and a = :aa and (b = :bb or b = :cc or e = :ee) and e like :ee";
		
		String sql = "select * from T1 where 1=1 and (((a = :aa or B like :bb or c in (:cc)) and d in (:dd) ) or e = :ee) and f like :ff";
		
		List<String> paramLIst = new ArrayList<String>();
		paramLIst.add("aa=\"111\"");
		//paramLIst.add("bb=\"222\"");
		//paramLIst.add("cc=\"333\"");
		paramLIst.add("dd=\"444\"");
		String sql2 = getSql(sql,paramLIst);
		
		System.out.println(sql2);
	}
	
	/**
	 * ������
	 * @param sql
	 * @param paramLIst
	 * @return
	 */
    public static String getSql(String sql,List<String> paramLIst) {
    	//  ѭ�����еĲ���  �����滻
    	for (String param : paramLIst) {
    		sql = replaceParam(sql,param);
    	}
    	//ɾ�����õĲ�����
    	sql = removeParam(sql,sql, "and");
    	
    	if(sql.indexOf(":") > -1) {
    		sql = removeParam(sql,sql, "and");
    	}
    	return sql;
    }
    
    /**
     * �滻sql�����õ�����
     * @param sql
     * @param param
     * @return
     */
	public static String replaceParam(String sql,String param) {
		return sql.replace((":"+param.substring(0,2)), param.substring((param.indexOf("=")+1)));
	}
    

	/**
	 * ȡ�����õ�����
	 * @param sql
	 * @param sqlCondition
	 * @return
	 */
	public static String removeParam(String sql,String splitSql,String sqlCondition) {
		//  ����Ĺؼ���  ��and/or  ���sql
		/**
		 select * from t1 where 1=1 
		 a = :aa 
		 (b = :bb or b = "333" or e = :ee) 
		 e like :ee
		 */
		String[] andStr = splitSql.split(sqlCondition);
		
		//ѭ������
		for (String astr : andStr) {
			// �ж�ÿ����ֵ�sql���Ƿ����or�ؼ���
			if(astr.indexOf("or") > -1) {
				// ����or�ؼ��־ͼ������  ��ֹ�ж��or���� �磺b = :cc or e = :ee)
				/**
				 (b = :bb 
				 b = "333" 
				 e = :ee) 
				 */
				String[] orStr = astr.split("or");
				for (int i = 0; i < orStr.length; i++) {
					// �ж� ʹ��or��ֵ�sql�����Ƿ����  ��  ���ھ���Ҫɾ�����������
					if(orStr[i].indexOf(":") > 1) {
						if(i == 0) {// ����ǵ�һ������(b = :bb  ��ô����Ҫȥ�� "("  ���Ҽ��� or  Ȼ��ȥsql�н����Ƶ������滻��"" 
							String str = orStr[i].replace("(",""); // b = :bb or
							sql = sql.replace((str + "or").trim(),"");
						}else {//  ͬ��   Ψһ��������� or��ǰ�����ں�    �������ŵ�����
							String str = orStr[i].replace(")","");
							sql = sql.replace(("or" + str).trim(), "");
							//sql = sql.replace(str.trim(), "");
						}
					}
					
				}
				
			}else {
				if(astr.indexOf(":") > -1) {
					//  ɾ�����д�":"������
					sql = sql.replace(sqlCondition + astr,"");
				}
			}
		}
		return sql;
	}
	
	
	
	
	
}
