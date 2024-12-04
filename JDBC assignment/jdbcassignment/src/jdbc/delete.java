package jdbc;

import jdbc.bean.article;
import jdbc.dao.DaoInterface;
import jdbc.dao.articleDao;

public class delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoInterface<article, Integer> daoref = new articleDao();
		daoref.delete(1);

	}

}
