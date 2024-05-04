package com.sts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MetalRepo {
	
	private JdbcTemplate template;
	
	
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void save(Metal metal) {
		String sql="insert into tab1 (id,name,add) values (?,?,?)";
		int rows=template.update(sql,metal.getId(),metal.getName(),metal.getAdd());
		System.out.println(rows+" affected");
	}
	
	public List<Metal> findAll() {
		String sql="Select * from tab1";
		RowMapper<Metal>mapper=new RowMapper<Metal>() {
			
			@Override
			public Metal mapRow(ResultSet rs, int rowNum) throws SQLException {
				Metal a=new Metal();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setAdd(rs.getString(3));
				return a;
			}
		};
		List<Metal>list= template.query(sql,mapper);
		return list;
	}
}
