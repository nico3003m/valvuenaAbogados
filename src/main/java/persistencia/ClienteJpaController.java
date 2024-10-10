/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

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
import logica.Cliente;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Nicolas Moreno
 */
public class ClienteJpaController implements Serializable {

    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
      public ClienteJpaController() {
        emf = Persistence.createEntityManagerFactory("valbuenaAbogadosPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliente cliente) {
        if (cliente.getCasos() == null) {
            cliente.setCasos(new ArrayList<Caso>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Caso> attachedCasos = new ArrayList<Caso>();
            for (Caso casosCasoToAttach : cliente.getCasos()) {
                casosCasoToAttach = em.getReference(casosCasoToAttach.getClass(), casosCasoToAttach.getId());
                attachedCasos.add(casosCasoToAttach);
            }
            cliente.setCasos(attachedCasos);
            em.persist(cliente);
            for (Caso casosCaso : cliente.getCasos()) {
                Cliente oldClienteOfCasosCaso = casosCaso.getCliente();
                casosCaso.setCliente(cliente);
                casosCaso = em.merge(casosCaso);
                if (oldClienteOfCasosCaso != null) {
                    oldClienteOfCasosCaso.getCasos().remove(casosCaso);
                    oldClienteOfCasosCaso = em.merge(oldClienteOfCasosCaso);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getId());
            List<Caso> casosOld = persistentCliente.getCasos();
            List<Caso> casosNew = cliente.getCasos();
            List<Caso> attachedCasosNew = new ArrayList<Caso>();
            for (Caso casosNewCasoToAttach : casosNew) {
                casosNewCasoToAttach = em.getReference(casosNewCasoToAttach.getClass(), casosNewCasoToAttach.getId());
                attachedCasosNew.add(casosNewCasoToAttach);
            }
            casosNew = attachedCasosNew;
            cliente.setCasos(casosNew);
            cliente = em.merge(cliente);
            for (Caso casosOldCaso : casosOld) {
                if (!casosNew.contains(casosOldCaso)) {
                    casosOldCaso.setCliente(null);
                    casosOldCaso = em.merge(casosOldCaso);
                }
            }
            for (Caso casosNewCaso : casosNew) {
                if (!casosOld.contains(casosNewCaso)) {
                    Cliente oldClienteOfCasosNewCaso = casosNewCaso.getCliente();
                    casosNewCaso.setCliente(cliente);
                    casosNewCaso = em.merge(casosNewCaso);
                    if (oldClienteOfCasosNewCaso != null && !oldClienteOfCasosNewCaso.equals(cliente)) {
                        oldClienteOfCasosNewCaso.getCasos().remove(casosNewCaso);
                        oldClienteOfCasosNewCaso = em.merge(oldClienteOfCasosNewCaso);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = cliente.getId();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
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
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            List<Caso> casos = cliente.getCasos();
            for (Caso casosCaso : casos) {
                casosCaso.setCliente(null);
                casosCaso = em.merge(casosCaso);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
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

    public Cliente findCliente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
