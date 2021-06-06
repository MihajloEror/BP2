package crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Apredmet;
import model.Astudent;
import oracle.net.aso.s;
import utils.PersistenceUtil;

public class SlusaCrud {
	
	public void poveziStudentaIPredmet(Astudent s, Apredmet p){
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;		
		try{
			et = em.getTransaction();
			et.begin();
			
			s = em.merge(s);
			p = em.merge(p);
			
			s.getPredmeti().add(p);
			p.getStudenti().add(s);
			
			em.merge(s);
			em.merge(p);
			
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
