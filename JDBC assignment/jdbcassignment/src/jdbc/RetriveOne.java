package jdbc;



import jdbc.bean.article;
import jdbc.dao.DaoInterface;
import jdbc.dao.articleDao;

public class RetriveOne {
public static void main(String[] args) {
	DaoInterface<article, Integer> daoref = new articleDao();
	article allavailabelartical = daoref.retrieveOne(3);
	if(allavailabelartical != null)
		System.out.println(allavailabelartical);
	else
		System.out.println("artical with given ID does not exist.");
	
}
}
