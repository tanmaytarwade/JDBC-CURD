package jdbc;

import jdbc.bean.article;
import jdbc.dao.DaoInterface;
import jdbc.dao.articleDao;

public class Upadate {
public static void main(String[] args) {
	DaoInterface<article, Integer> daoref = new articleDao();
	article at= daoref. retrieveOne(1);
	
	at.setName("artical5");
	daoref.update(at);
	
	
	
}
}
