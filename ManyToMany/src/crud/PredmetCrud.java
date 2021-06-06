package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Nastavnik;
import model.Predmet;
import utils.PersistenceUtil;

public class PredmetCrud {
	
	public void insertPredmet(Predmet p){
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
	
	public Predmet findPredmet(long id){
		EntityManager em = PersistenceUtil.getEntityManager();
		Predmet p = em.find(Predmet.class, id);
		em.close();
		return p;
	}
	
	public Predmet getPredmet(Predmet p){
		EntityManager em = PersistenceUtil.getEntityManager();
		String upit = "select p from Predmet p where p.naziv=:x";
		Query q = em.createQuery(upit);
		q.setParameter("x", p.getNaziv());
		Predmet pred = (Predmet)q.getSingleResult();
		em.close();
		return pred;
	}
	
	public List<Predmet> listPredmeti(){
		EntityManager em = PersistenceUtil.getEntityManager();
		List<Predmet> predmeti = em.createQuery("select n from Predmet n order by n.predmetId").getResultList();
		em.close();
		return predmeti;
	}
	
	public List<Predmet> predavaniPredmeti(Nastavnik n){
		EntityManager em = PersistenceUtil.getEntityManager();
		n = em.merge(n);
		n.getPredmets().size();
		List<Predmet> predmeti = n.getPredmets();
		em.close();
		return predmeti;
	} 
	
	public void deletePredmet(Predmet p){
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;		
		try{
			et = em.getTransaction();
			et.begin();
			
			p = em.merge(p);
			List<Nastavnik> nastavnici = p.getNastavniks();
			for(Nastavnik n : nastavnici){
				n.getPredmets().remove(p);
				em.merge(n);
			}
			em.remove(p);
					
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
