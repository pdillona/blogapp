package com.cos.blogapp.util;

public class Script {

	
	  public static String back(String msg) {
	      StringBuilder sb = new StringBuilder();
	      sb.append("<script>");
	      sb.append("alert('"+msg+"');"); //('  " +msg+ "  ') 세개로 보이는건 모조리 홑따옴표랑 쌍따옴표가 연속적으로 나온것이다.
	      sb.append("history.back();");
	      sb.append("</script>");
	      
	      return sb.toString();
	   }
	
	public static String href(String path) {
		StringBuilder sb = new StringBuilder();
		sb.append("<script>");
		sb.append("location.href='"+path+"';");
		sb.append("</script>");
		
		return sb.toString();
	}

	public static String href(String path, String msg) {
		StringBuilder sb = new StringBuilder();
		sb.append("<script>");
	    sb.append("alert('"+msg+"');");
		sb.append("location.href='"+path+"';");
		sb.append("</script>");
		
		return sb.toString();
	}
	
	
}
