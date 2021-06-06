package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Apredmet;
import utils.PersistenceUtil;

public class PredmetCrud {
	
	public void insertPredmet(Apredmet p){
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
	
	public Apredmet findPredmet(long spr){
		EntityManager em = PersistenceUtil.getEntityManager();
		Apredmet p = em.find(Apredmet.class, spr);
		em.close();
		return p;
	}
	
	public Apredmet getPredmet(String naziv){
		EntityManager em = PersistenceUtil.getEntityManager();
		String upit = "select p from Apredmet p where p.naziv=:x";
		Query q = em.createQuery(upit);
		q.setParameter("x", naziv);
		Apredmet p = (Apredmet)q.getSingleResult();
		em.close();
		return p;
	}
	
	public List<Apredmet> listPredmeti(){
		EntityManager em = PersistenceUtil.getEntityManager();
		List<Apredmet> predmeti = em.createQuery("select p from Apredmet p order by p.spr").getResultList();
		em.close();
		return predmeti;
	}

}
