package com.jiwon.article;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ArticleController {
 
	@Autowired
	ArticleDao articleDao;

	static final Logger logger = LogManager.getLogger();

	@RequestMapping("/main")
	public String main() {
		return "main";
	}

	@RequestMapping("/article/step2")
	public String handleStep2(HttpSession session) {
		return "article/step2";
}
	
	@PostMapping("/article/step3")
	public String handleStep3(Article article,HttpSession session) {
			articleDao.insert(article);
			logger.debug("글정보를 저장했습니다. {}", article);
			return "redirect:/app/article/step3";
} 
	
	@RequestMapping(value="/article/step1",method=RequestMethod.GET)
	public String handleStep1(@RequestParam int articleId,Model model) {
		Article article = articleDao.selectOne(articleId);
		model.addAttribute("article",article);
		return "article/step1";
}


	@GetMapping("/articles")
	public String articles(
			@RequestParam(value = "page", defaultValue = "1") int page,
			Model model) {

		// 페이지 당 가져오는 행의 수
		final int COUNT = 100;
		// 시작점
		int offset = (page - 1) * COUNT;

		List<Article> articleList = articleDao.selectAll(offset, COUNT);

		int totalCount = articleDao.countAll();

		model.addAttribute("totalCount", totalCount);
		model.addAttribute("articles", articleList);
		return "articles";
	}

}