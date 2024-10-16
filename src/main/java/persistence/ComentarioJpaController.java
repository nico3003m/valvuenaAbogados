/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Archivo;
import logica.Comentario;
import persistence.exceptions.NonexistentEntityException;

/**
 *
 * @author Nicolas Moreno
 */
public class ComentarioJpaController implements Serializable {

    public ComentarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
      public ComentarioJpaController( ) {
        emf = Persistence.createEntityManagerFactory("valbuenaAbogadosPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Comentario comentario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Archivo archivo = comentario.getArchivo();
            if (archivo != null) {
                archivo = em.getReference(archivo.getClass(), archivo.getId());
                comentario.setArchivo(archivo);
            }
            em.persist(comentario);
            if (archivo != null) {
                archivo.getComentarios().add(comentario);
                archivo = em.merge(archivo);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Comentario comentario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Comentario persistentComentario = em.find(Comentario.class, comentario.getId());
            Archivo archivoOld = persistentComentario.getArchivo();
            Archivo archivoNew = comentario.getArchivo();
            if (archivoNew != null) {
                archivoNew = em.getReference(archivoNew.getClass(), archivoNew.getId());
                comentario.setArchivo(archivoNew);
            }
            comentario = em.merge(comentario);
            if (archivoOld != null && !archivoOld.equals(archivoNew)) {
                archivoOld.getComentarios().remove(comentario);
                archivoOld = em.merge(archivoOld);
            }
            if (archivoNew != null && !archivoNew.equals(archivoOld)) {
                archivoNew.getComentarios().add(comentario);
                archivoNew = em.merge(archivoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = comentario.getId();
                if (findComentario(id) == null) {
                    throw new NonexistentEntityException("The comentario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Comentario comentario;
            try {
                comentario = em.getReference(Comentario.class, id);
                comentario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The comentario with id " + id + " no longer exists.", enfe);
            }
            Archivo archivo = comentario.getArchivo();
            if (archivo != null) {
                archivo.getComentarios().remove(comentario);
                archivo = em.merge(archivo);
            }
            em.remove(comentario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Comentario> findComentarioEntities() {
        return findComentarioEntities(true, -1, -1);
    }

    public List<Comentario> findComentarioEntities(int maxResults, int firstResult) {
        return findComentarioEntities(false, maxResults, firstResult);
    }

    private List<Comentario> findComentarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Comentario.class));
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

    public Comentario findComentario(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Comentario.class, id);
        } finally {
            em.close();
        }
    }

    public int getComentarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Comentario> rt = cq.from(Comentario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
