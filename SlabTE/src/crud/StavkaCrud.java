package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Proizvod;
import model.Racun;
import model.Stavka;
import model.StavkaPK;
import utils.PersistenceUtil;

public class StavkaCrud {
	
	public void insertStavka(Racun r, long stavkaId, Proizvod p, int kolicina){
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;		
		try{
			et = em.getTransaction();
			et.begin();
			
			r = em.merge(r);
			p = em.merge(p);
			
			Stavka s = new Stavka();
			s.setProizvod(p);
			s.setRacun(r);
			s.setKolicina(kolicina);
			
			StavkaPK pk = new StavkaPK();
			pk.setStavkaId(stavkaId);
			pk.setRacunRacunId(r.getRacunId());
			
			s.setId(pk);
			
			em.persist(s);
			
			p.addStavke(s);
			r.addStavke(s);
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
