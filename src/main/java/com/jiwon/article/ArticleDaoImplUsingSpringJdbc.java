package com.jiwon.article;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;


@Repository("articleDao") 
public class ArticleDaoImplUsingSpringJdbc implements ArticleDao {
	
	static final String INSERT = "INSERT article(title, content, userId, name) VALUES (?, ?, ?, ?)";
	
	static final String SELECT_ALL = "SELECT articleId, title, content, userId, name, left(cdate,19) cdate FROM article ORDER BY articleId desc LIMIT ?,?";

	static final String COUNT_ALL = "SELECT count(articleId) count FROM article";
	
	static final String SELECT_ONE = "SELECT articleId, title, userId, content, name, udate FROM article WHERE articleId=?";

	@Autowired
	JdbcTemplate jdbcTemplate;

	final RowMapper<Article> articleRowMapper = new BeanPropertyRowMapper<>(Article.class);
	
	@Override
	public Article selectOne(int articleId) {
		return jdbcTemplate.queryForObject(SELECT_ONE,
				new BeanPropertyRowMapper<>(Article.class), articleId);
	}

	@Override
	public int insert(Article article) {
		return jdbcTemplate.update(INSERT, article.getTitle(),
				article.getContent(), "2017041006", "김지원");
	}

	@Override
	public List<Article> selectAll(int offset, int count) {
		return jdbcTemplate.query(SELECT_ALL, articleRowMapper, offset, count);
	}

	@Override
	public int countAll() {
		return jdbcTemplate.queryForObject(COUNT_ALL, Integer.class);
	}
}