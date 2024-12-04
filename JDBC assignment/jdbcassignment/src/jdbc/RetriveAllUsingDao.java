package jdbc;

import java.util.Collection;

import jdbc.bean.article;
import jdbc.dao.DaoInterface;
import jdbc.dao.articleDao;

public class RetriveAllUsingDao {
	public static void main(String[] args) {
		DaoInterface<article, Integer> daoref = new articleDao();
		Collection<article> allavailabelartical = daoref.retrieveAll();
		for (article currentArticle:allavailabelartical)
			System.out.println(currentArticle);
	
	}

}
