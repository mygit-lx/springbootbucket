package com.example.demo;

import com.example.dao.entity.Article;
import com.example.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootHibernateApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(SpringbootHibernateApplicationTests.class);

	@Resource
	private ArticleService articleService;


	@Test
	public void contextLoads() {
	}

	/**
	 * 测试增删改查
	 */
	@Test
	public void test() {
		//通过id查询一条数据
		Article article = articleService.getArticleById(1);
		System.out.println("查询的数据1为:"+article.toString());
		//assertThat(article.getTitle(), is("Java Concurrency"));

		//查询所有数据
		List<Article> list = articleService.getAllArticles();
		System.out.println("查询所有数据2为:"+list.toString());
		//assertThat(list, notNullValue());
		//assertThat(list.size(), is(3));

		//插入一条记录
		Article article1 = new Article();
		article1.setCategory("php");
		article1.setTitle("second Php");
		System.out.println("待插入的记录:"+article1.toString());
		//boolean flag = articleService.addArticle(article1);
		//System.out.println("插入一条记录："+flag);
		//assertThat(flag, is(false));

		//更新一条记录
		Article article2 = new Article();
		article2.setArticleId(1);
		article2.setTitle("Python Concurrency");
		//articleService.updateArticle(article2);
		//Article article1 = articleService.getArticleById(1);
		//assertThat(article1.getTitle(), is("Python Concurrency"));


		//articleService.deleteArticle(5);
		//Article article2 = articleService.getArticleById(1);
		//assertThat(article2, nullValue());

		Map<String, Object> map = articleService.getArticle("");
		System.out.println(map);
	}

	@Test
	public void test01(){
		//插入一条记录
		Article article1 = new Article();
		article1.setCategory("php03");
		article1.setTitle("second Php03");
		System.out.println("待插入的记录:"+article1.toString());
		boolean flag = articleService.addArticle(article1);
		System.out.println("插入一条记录："+flag);
	}

	@Test
	public void test02(){
		//通过id查询一条数据
		Article article = articleService.getArticleById(0);
		System.out.println("查询的数据1为:"+article.toString());
	}

}
