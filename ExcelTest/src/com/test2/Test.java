package com.test2;

import java.util.ArrayList;
import java.util.List;


/**

已知带有特殊标记的sql语句和前端传过来的参数集合，用参数替换sql的特殊标记，如果标记对应的参数存在，则直接替换，如果不存在，要把对应的一段条件去掉，最后得出一个能用于查询的sql语句。要求给出完整代码，代码加上必要的注释。
例如:已知 1）带有特殊标记的sql语句 select * from T1 where 1=1 and a = :aa  and (b =:bb or b =:cc) and e like :ee
       2）前端传过来的参数有 aa= "111" , bb= "222", cc= "333",dd = "444"
得到 select * from T1 where 1=1 and a = 111 and (b = 222 or b = 333)
用参数替换sql的特殊标记，如果标记对应的参数存在，则直接替换，如果不存在，要把对应的一段条件去掉，最后得出一个能用于查询的sql语句，返回能用于查询的sql语句。
@param labelSql 带有标记的sql语句, 如select * from T1 where 1=1 and a = :aa  and (b =:bb or b =:cc) and e like :ee
@param param 参数集合，如aa= "111" , bb= "222", cc= "333",dd = "444"
@return 能用于查询的sql,如select * from T1 where 1=1 and a = 111 and (b = 222 or b = 333)
也可大胆想像，如果参数中没有bb = 222,应该怎么处理？

如果只有标记AA没参数，去掉与AA相关的条件，得到结果；如果只有标记BB没参数，去掉与BB相关的条件，得到结果；……如果只有标记CC，DD没参数，去掉与CC，DD相关的条件，得到结果；……如果只有AA，DD，EE没参数，去掉与AA，DD，EE相关的条件，得到结果……对比参数与结果，找找规律。找出规律，再动手把你思路实现。

完成了，请用如下情况去测试 
1) sql: select * from T1 where 1=1 and (((a = :aa or B like :bb or c in (:cc)) and d in (:dd) ) or e = :ee) and f like :ff
2）参数：GG = "1223" , aa = "first"
最终得到 select * from T1 where 1=1  
也测一下：有些标记有参数，有些标记没有参数，看最终结果是否正确
 
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
	 * 主方法
	 * @param sql
	 * @param paramLIst
	 * @return
	 */
    public static String getSql(String sql,List<String> paramLIst) {
    	//  循环所有的参数  进行替换
    	for (String param : paramLIst) {
    		sql = replaceParam(sql,param);
    	}
    	//删除无用的参数段
    	sql = removeParam(sql,sql, "and");
    	
    	if(sql.indexOf(":") > -1) {
    		sql = removeParam(sql,sql, "and");
    	}
    	return sql;
    }
    
    /**
     * 替换sql中有用的条件
     * @param sql
     * @param param
     * @return
     */
	public static String replaceParam(String sql,String param) {
		return sql.replace((":"+param.substring(0,2)), param.substring((param.indexOf("=")+1)));
	}
    

	/**
	 * 取出无用的条件
	 * @param sql
	 * @param sqlCondition
	 * @return
	 */
	public static String removeParam(String sql,String splitSql,String sqlCondition) {
		//  传入的关键字  如and/or  拆分sql
		/**
		 select * from t1 where 1=1 
		 a = :aa 
		 (b = :bb or b = "333" or e = :ee) 
		 e like :ee
		 */
		String[] andStr = splitSql.split(sqlCondition);
		
		//循环数组
		for (String astr : andStr) {
			// 判断每隔拆分的sql中是否存在or关键字
			if(astr.indexOf("or") > -1) {
				// 存在or关键字就继续拆分  防止有多个or条件 如：b = :cc or e = :ee)
				/**
				 (b = :bb 
				 b = "333" 
				 e = :ee) 
				 */
				String[] orStr = astr.split("or");
				for (int i = 0; i < orStr.length; i++) {
					// 判断 使用or拆分的sql段中是否存在  ：  存在就需要删除掉这个条件
					if(orStr[i].indexOf(":") > 1) {
						if(i == 0) {// 如果是第一个条件(b = :bb  那么久需要去掉 "("  并且加上 or  然后去sql中将类似的条件替换成"" 
							String str = orStr[i].replace("(",""); // b = :bb or
							sql = sql.replace((str + "or").trim(),"");
						}else {//  同上   唯一的区别就是 or在前还是在后    还有括号的问题
							String str = orStr[i].replace(")","");
							sql = sql.replace(("or" + str).trim(), "");
							//sql = sql.replace(str.trim(), "");
						}
					}
					
				}
				
			}else {
				if(astr.indexOf(":") > -1) {
					//  删除所有带":"的条件
					sql = sql.replace(sqlCondition + astr,"");
				}
			}
		}
		return sql;
	}
	
	
	
	
	
}
