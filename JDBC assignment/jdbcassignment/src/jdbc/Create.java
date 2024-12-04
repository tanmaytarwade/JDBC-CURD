package jdbc;

import jdbc.bean.article;
import jdbc.dao.DaoInterface;
import jdbc.dao.articleDao;

public class Create {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoInterface<article, Integer> daoref = new articleDao();
		article at = new article(4, "artical4", "painting", "2024-04-04", "vedanti");
		daoref.create(at);

	}

}
