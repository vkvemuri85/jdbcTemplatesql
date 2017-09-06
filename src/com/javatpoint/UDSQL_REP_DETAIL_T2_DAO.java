package com.javatpoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class UDSQL_REP_DETAIL_T2_DAO {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// public int saveSQL(UDSQL_REP_DETAIL_T2 e){
	// String query="insert into cdwmeta.UDSQL_REP_DETAIL_T3
	// values('"+e.getUnid()+"','"+e.getSql_text()+"')";
	// return jdbcTemplate.update(query);
	// }
	public int saveSQL(String e, String f) {
		String query = "insert into UDSQL_REP_DETAIL_T2 values('" + e + "','" + f + "')";
		return jdbcTemplate.update(query);
	}

	public List<UDSQL_REP_DETAIL_T2> findAll() {

		// String sql = "SELECT cast(UNID as varchar2(100)) as
		// UNID,replace(replace(SQL_TEXT,'promptmany',''),'#','') as SQL_TEXT FROM
		// CDWMETA.UDSQL_REP_DETAIL_T2 where sql_text is not null and
		// round(length(sql_text)/10,0)<4";
		String sql = "SELECT UNID,SQL_TEXT FROM UDSQL_REP_DETAIL_T2";
		List<UDSQL_REP_DETAIL_T2> queries = new ArrayList<UDSQL_REP_DETAIL_T2>();

		@SuppressWarnings("unchecked")
		List<Map> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			UDSQL_REP_DETAIL_T2 myrow = new UDSQL_REP_DETAIL_T2();
			myrow.setUnid((String) (row.get("UNID")));
			myrow.setSql_text((String) row.get("SQL_TEXT"));
			queries.add(myrow);
		}

		return queries;
	}

}
