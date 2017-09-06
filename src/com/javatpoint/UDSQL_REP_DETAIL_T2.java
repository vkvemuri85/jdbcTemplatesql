package com.javatpoint;

public class UDSQL_REP_DETAIL_T2 {
	private String unid;
	private String sql_text;
	public UDSQL_REP_DETAIL_T2() {
		
	}
	public UDSQL_REP_DETAIL_T2(String unid, String sql_text) {
		super();
		this.unid = unid;
		this.sql_text = sql_text;
	}
	public String getUnid() {
		return unid;
	}
	public void setUnid(String unid) {
		this.unid = unid;
	}
	public String getSql_text() {
		return sql_text;
	}
	public void setSql_text(String sql_text) {
		this.sql_text = sql_text;
	}


}
