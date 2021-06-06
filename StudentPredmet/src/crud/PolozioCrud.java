package crud;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Apolozio;
import model.ApolozioPK;
import model.Apredmet;
import model.Astudent;
import utils.PersistenceUtil;

public class PolozioCrud {
	
	public void insertPolozio(Astudent s, Apredmet p, int ocena, Date datum){
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;		
		try{
			et = em.getTransaction();
			et.begin();
			
			s = em.merge(s);
			p = em.merge(p);
			
			Apolozio pol = new Apolozio();
			pol.setDatum(datum);
			pol.setOcena(ocena);
			pol.setStudent(s);
			pol.setPredmet(p);
			
			ApolozioPK pk = new ApolozioPK();
			pk.setPredmetSpr(p.getSpr());
			pk.setStudentBri(s.getBri());
			
			pol.setId(pk);
			
			s.addPolozeniIspiti(pol);
			p.addStudentiKojiSuPolozili(pol);
			
			em.persist(pol);
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
	
	public List<Apolozio> polozeniIspiti(Astudent s){
		EntityManager em = PersistenceUtil.getEntityManager();
//		List<Apolozio> pol = s.getPolozeniIspiti();
//		pol.size();
		String upit =  "select s from Astudent s join fetch s.polozeniIspiti where s.bri=:x";
		Query q = em.createQuery(upit);
		q.setParameter("x", s.getBri());
		Astudent st = (Astudent)q.getSingleResult();
		em.close();
		return st.getPolozeniIspiti();
	}

}
