/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Caso;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Abogado;
import persistence.exceptions.NonexistentEntityException;

/**
 *
 * @author Nicolas Moreno
 */
public class AbogadoJpaController implements Serializable {

    public AbogadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public AbogadoJpaController() {
        emf = Persistence.createEntityManagerFactory("valbuenaAbogadosPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Abogado abogado) {
        if (abogado.getCasos() == null) {
            abogado.setCasos(new ArrayList<Caso>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Caso> attachedCasos = new ArrayList<Caso>();
            for (Caso casosCasoToAttach : abogado.getCasos()) {
                casosCasoToAttach = em.getReference(casosCasoToAttach.getClass(), casosCasoToAttach.getId());
                attachedCasos.add(casosCasoToAttach);
            }
            abogado.setCasos(attachedCasos);
            em.persist(abogado);
            for (Caso casosCaso : abogado.getCasos()) {
                Abogado oldAbogadoOfCasosCaso = casosCaso.getAbogado();
                casosCaso.setAbogado(abogado);
                casosCaso = em.merge(casosCaso);
                if (oldAbogadoOfCasosCaso != null) {
                    oldAbogadoOfCasosCaso.getCasos().remove(casosCaso);
                    oldAbogadoOfCasosCaso = em.merge(oldAbogadoOfCasosCaso);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Abogado abogado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Abogado persistentAbogado = em.find(Abogado.class, abogado.getId());
            List<Caso> casosOld = persistentAbogado.getCasos();
            List<Caso> casosNew = abogado.getCasos();
            List<Caso> attachedCasosNew = new ArrayList<Caso>();
            for (Caso casosNewCasoToAttach : casosNew) {
                casosNewCasoToAttach = em.getReference(casosNewCasoToAttach.getClass(), casosNewCasoToAttach.getId());
                attachedCasosNew.add(casosNewCasoToAttach);
            }
            casosNew = attachedCasosNew;
            abogado.setCasos(casosNew);
            abogado = em.merge(abogado);
            for (Caso casosOldCaso : casosOld) {
                if (!casosNew.contains(casosOldCaso)) {
                    casosOldCaso.setAbogado(null);
                    casosOldCaso = em.merge(casosOldCaso);
                }
            }
            for (Caso casosNewCaso : casosNew) {
                if (!casosOld.contains(casosNewCaso)) {
                    Abogado oldAbogadoOfCasosNewCaso = casosNewCaso.getAbogado();
                    casosNewCaso.setAbogado(abogado);
                    casosNewCaso = em.merge(casosNewCaso);
                    if (oldAbogadoOfCasosNewCaso != null && !oldAbogadoOfCasosNewCaso.equals(abogado)) {
                        oldAbogadoOfCasosNewCaso.getCasos().remove(casosNewCaso);
                        oldAbogadoOfCasosNewCaso = em.merge(oldAbogadoOfCasosNewCaso);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = abogado.getId();
                if (findAbogado(id) == null) {
                    throw new NonexistentEntityException("The abogado with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Abogado abogado;
            try {
                abogado = em.getReference(Abogado.class, id);
                abogado.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The abogado with id " + id + " no longer exists.", enfe);
            }
            List<Caso> casos = abogado.getCasos();
            for (Caso casosCaso : casos) {
                casosCaso.setAbogado(null);
                casosCaso = em.merge(casosCaso);
            }
            em.remove(abogado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Abogado> findAbogadoEntities() {
        return findAbogadoEntities(true, -1, -1);
    }

    public List<Abogado> findAbogadoEntities(int maxResults, int firstResult) {
        return findAbogadoEntities(false, maxResults, firstResult);
    }

    private List<Abogado> findAbogadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Abogado.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Abogado findAbogado(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Abogado.class, id);
        } finally {
            em.close();
        }
    }

    public int getAbogadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Abogado> rt = cq.from(Abogado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
