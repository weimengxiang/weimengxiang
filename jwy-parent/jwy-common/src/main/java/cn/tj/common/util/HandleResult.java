package cn.tj.common.util;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
/*
 * weimengxiang
 * 后台返回结果模板类
 */
public class HandleResult {
  
	public static <T> String ResultData(String code,String msg,PageInfo<T> pageinfo){
		JSONObject json = new JSONObject();
		json.put("Code",code);
		json.put("Msg", msg);
		json.put("Page", pageinfo.getPageNum());
		json.put("PageSize", pageinfo.getPageSize());
		json.put("Size", pageinfo.getSize());
		json.put("Total", pageinfo.getTotal());
		json.put("StartRow", pageinfo.getStartRow());
		json.put("EndRow", pageinfo.getEndRow());
		json.put("Data",pageinfo.getList());
		
		return json.toString();
	}

}
