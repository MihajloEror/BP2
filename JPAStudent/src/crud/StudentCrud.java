package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Student;
import utils.PersistenceUtil;




public class StudentCrud {
	
	public void insertStudent(Student s){
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
			if(et!=null){
				et.rollback();
			}
		}finally{
			if(em!=null){
				em.close();
			}
		}
	}
	
	public boolean deleteStudent(Student s){		
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		boolean uspesno = false;
		try{
			et = em.getTransaction();
			et.begin();
			Student pomS = em.merge(s);
			em.remove(pomS);
			em.flush();
			et.commit();
			uspesno = true;
		}catch(Exception ex){
			ex.printStackTrace();
			if(et!=null){
				et.rollback();
			}
		}finally{
			if(em!=null){
				em.close();
			}
		}
		return uspesno;
	}
	
	public void updateStudent(Student s, String novoIme){
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		try{
			et = em.getTransaction();
			et.begin();
			Student pomS = em.merge(s);
			pomS.setIme(novoIme);
			em.merge(pomS);
			em.flush();
			et.commit();
		}catch(Exception ex){
			ex.printStackTrace();
			if(et!=null){
				et.rollback();
			}
		}finally{
			if(em!=null){
				em.close();
			}
		}
	}
	
	public List<Student> listStudent(){
		EntityManager em = PersistenceUtil.getEntityManager();
		String upit = "select s from Student s";
		List<Student> lista = em.createQuery(upit).getResultList();
		em.close();
		return lista;
	}

}
