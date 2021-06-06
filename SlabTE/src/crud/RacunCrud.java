package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import model.Racun;
import model.Stavka;
import utils.PersistenceUtil;

public class RacunCrud {
	
	public void insertRacun(Racun r){
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;		
		try{
			et = em.getTransaction();
			et.begin();
			em.persist(r);
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
	
	
	
	public void deleteRacun(Racun r){
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;		
		try{
			et = em.getTransaction();
			et.begin();
			
			r = em.merge(r);
			List<Stavka> stavke = r.getStavke();
			for(Stavka s : stavke){
				em.remove(s);
			}
			
			em.remove(r);
			
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
	
	public Racun findRacun(long id){
		EntityManager em = PersistenceUtil.getEntityManager();
		Racun r = em.find(Racun.class, id);
		em.close();
		return r;
	}
	
	public List<Racun> listRacuni(){
		EntityManager em = PersistenceUtil.getEntityManager();
		List<Racun> racuni = em.createQuery("select r from Racun r").getResultList();
		em.close();
		return racuni;
	}
	
	public void izracunajTotal(Racun r){
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;		
		try{
			et = em.getTransaction();
			et.begin();
			
			double total = 0;
			
			r = em.merge(r);
			List<Stavka> stavke = r.getStavke();
			for(Stavka s : stavke){
				total = total + s.getKolicina() * s.getProizvod().getCena();
			}
			r.setTotal(total);
			em.merge(r);
			
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
