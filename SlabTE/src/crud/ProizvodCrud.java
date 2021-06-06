package crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Proizvod;
import utils.PersistenceUtil;

public class ProizvodCrud {
	
	public void insertProizvod(Proizvod p){
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;		
		try{
			et = em.getTransaction();
			et.begin();
			em.persist(p);
			em.flush();
			et.commit();
		}catch(Exception ex){
			ex.printStackTrace();
			if(et != null){
				et.rollback();
			}
		}finally{
			if(em != null && em.isOpen()){
				em.close();
			}
		}		
	}

}
