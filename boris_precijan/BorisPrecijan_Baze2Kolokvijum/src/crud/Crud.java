package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Autor;
import model.Knjiga;
import model.Oblast;
import utils.PersistenceUtil;

public class Crud {
	
	public boolean insertKnjiga(Knjiga k) {
		boolean rez = false;
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;		
		try{
			et = em.getTransaction();
			et.begin();
			em.persist(k);
			em.flush();
			et.commit();
			rez = true;
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
		return rez;
	}
	
	public List<Autor> sviAutori(){
		String upit = "Autor.findAll";
		EntityManager em = PersistenceUtil.getEntityManager();
		List<Autor> lista = em.createNamedQuery(upit).getResultList();
		em.close();
		return lista;
	}
	
	public List<Knjiga> sveKnjige(){
		String upit = "Knjiga.findAll";
		EntityManager em = PersistenceUtil.getEntityManager();
		List<Knjiga> lista = em.createNamedQuery(upit).getResultList();
		em.close();
		return lista;
	}
	
	public List<Oblast> sveOblasti(){
		String upit = "Oblast.findAll";
		EntityManager em = PersistenceUtil.getEntityManager();
		List<Oblast> lista = em.createNamedQuery(upit).getResultList();
		em.close();
		return lista;
	}
	
	public boolean poveziKnjiguIOblast(Knjiga k, Oblast o) {
		boolean rez = false;
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		try{
			et = em.getTransaction();
			et.begin();
			k = em.merge(k);
			o = em.merge(o);
			k.getOblasti().add(o);
			o.getKnjige().add(k);
			em.merge(k);
			em.merge(o);
			em.flush();
			et.commit();
			rez = true;
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
		return rez;
	}
	
	public boolean deleteKnjiga(Knjiga k) {
		boolean rez = false;
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		try{
			et = em.getTransaction();
			et.begin();
			k = em.merge(k);
			List<Oblast> oblasti = k.getOblasti();
			for(Oblast o : oblasti) {
				o.getKnjige().remove(k);
				em.merge(o);
			}
			em.remove(k);
			em.flush();
			et.commit();
			rez = true;
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
		return rez;
	}
	
	public List<Knjiga> sveKnjige(Oblast o){
		EntityManager em = PersistenceUtil.getEntityManager();
		List<Knjiga> lista = o.getKnjige();
		em.close();
		return lista;
	}
	
}
