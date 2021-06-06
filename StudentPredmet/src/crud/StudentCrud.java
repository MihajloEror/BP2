package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Apolozio;
import model.Apredmet;
import model.Astudent;
import utils.PersistenceUtil;

public class StudentCrud {
	
	public void insertStudent(Astudent s){
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;		
		try{
			et = em.getTransaction();
			et.begin();
			em.persist(s);
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
	
	public Astudent findStudent(long bri){
		EntityManager em = PersistenceUtil.getEntityManager();
		Astudent s = em.find(Astudent.class, bri);
		em.close();
		return s;
	}
	
	public List<Astudent> listStudenti(){
		EntityManager em = PersistenceUtil.getEntityManager();
		List<Astudent> studenti = em.createQuery("select s from Astudent s order by s.bri").getResultList();
		em.close();
		return studenti;
	}
	
	public void deleteStudent(Astudent s){
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;		
		try{
			et = em.getTransaction();
			et.begin();
			
			s = em.merge(s);
			List<Apolozio> pol = s.getPolozeniIspiti();
			for(Apolozio pl : pol){
				em.remove(pl);
			}
			em.merge(s);
			
			List<Apredmet> predmeti = s.getPredmeti();
			for(Apredmet p : predmeti){
				p.getStudenti().remove(s);
				em.merge(p);
			}
			
			em.remove(s);
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
