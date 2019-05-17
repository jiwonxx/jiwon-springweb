package com.jiwon.article;

import java.util.List;


public interface ArticleDao {


	int insert(Article article);
	
	Article selectOne(int articleId);
	
	List<Article> selectAll(int offset, int count);
	

	int countAll();

}