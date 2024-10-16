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
import logica.Comentario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Archivo;
import persistence.exceptions.NonexistentEntityException;

/**
 *
 * @author Nicolas Moreno
 */
public class ArchivoJpaController implements Serializable {

    public ArchivoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
      public ArchivoJpaController( ) {
        emf = Persistence.createEntityManagerFactory("valbuenaAbogadosPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Archivo archivo) {
        if (archivo.getComentarios() == null) {
            archivo.setComentarios(new ArrayList<Comentario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Caso caso = archivo.getCaso();
            if (caso != null) {
                caso = em.getReference(caso.getClass(), caso.getId());
                archivo.setCaso(caso);
            }
            List<Comentario> attachedComentarios = new ArrayList<Comentario>();
            for (Comentario comentariosComentarioToAttach : archivo.getComentarios()) {
                comentariosComentarioToAttach = em.getReference(comentariosComentarioToAttach.getClass(), comentariosComentarioToAttach.getId());
                attachedComentarios.add(comentariosComentarioToAttach);
            }
            archivo.setComentarios(attachedComentarios);
            em.persist(archivo);
            if (caso != null) {
                caso.getArchivos().add(archivo);
                caso = em.merge(caso);
            }
            for (Comentario comentariosComentario : archivo.getComentarios()) {
                Archivo oldArchivoOfComentariosComentario = comentariosComentario.getArchivo();
                comentariosComentario.setArchivo(archivo);
                comentariosComentario = em.merge(comentariosComentario);
                if (oldArchivoOfComentariosComentario != null) {
                    oldArchivoOfComentariosComentario.getComentarios().remove(comentariosComentario);
                    oldArchivoOfComentariosComentario = em.merge(oldArchivoOfComentariosComentario);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Archivo archivo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Archivo persistentArchivo = em.find(Archivo.class, archivo.getId());
            Caso casoOld = persistentArchivo.getCaso();
            Caso casoNew = archivo.getCaso();
            List<Comentario> comentariosOld = persistentArchivo.getComentarios();
            List<Comentario> comentariosNew = archivo.getComentarios();
            if (casoNew != null) {
                casoNew = em.getReference(casoNew.getClass(), casoNew.getId());
                archivo.setCaso(casoNew);
            }
            List<Comentario> attachedComentariosNew = new ArrayList<Comentario>();
            for (Comentario comentariosNewComentarioToAttach : comentariosNew) {
                comentariosNewComentarioToAttach = em.getReference(comentariosNewComentarioToAttach.getClass(), comentariosNewComentarioToAttach.getId());
                attachedComentariosNew.add(comentariosNewComentarioToAttach);
            }
            comentariosNew = attachedComentariosNew;
            archivo.setComentarios(comentariosNew);
            archivo = em.merge(archivo);
            if (casoOld != null && !casoOld.equals(casoNew)) {
                casoOld.getArchivos().remove(archivo);
                casoOld = em.merge(casoOld);
            }
            if (casoNew != null && !casoNew.equals(casoOld)) {
                casoNew.getArchivos().add(archivo);
                casoNew = em.merge(casoNew);
            }
            for (Comentario comentariosOldComentario : comentariosOld) {
                if (!comentariosNew.contains(comentariosOldComentario)) {
                    comentariosOldComentario.setArchivo(null);
                    comentariosOldComentario = em.merge(comentariosOldComentario);
                }
            }
            for (Comentario comentariosNewComentario : comentariosNew) {
                if (!comentariosOld.contains(comentariosNewComentario)) {
                    Archivo oldArchivoOfComentariosNewComentario = comentariosNewComentario.getArchivo();
                    comentariosNewComentario.setArchivo(archivo);
                    comentariosNewComentario = em.merge(comentariosNewComentario);
                    if (oldArchivoOfComentariosNewComentario != null && !oldArchivoOfComentariosNewComentario.equals(archivo)) {
                        oldArchivoOfComentariosNewComentario.getComentarios().remove(comentariosNewComentario);
                        oldArchivoOfComentariosNewComentario = em.merge(oldArchivoOfComentariosNewComentario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = archivo.getId();
                if (findArchivo(id) == null) {
                    throw new NonexistentEntityException("The archivo with id " + id + " no longer exists.");
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
            Archivo archivo;
            try {
                archivo = em.getReference(Archivo.class, id);
                archivo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The archivo with id " + id + " no longer exists.", enfe);
            }
            Caso caso = archivo.getCaso();
            if (caso != null) {
                caso.getArchivos().remove(archivo);
                caso = em.merge(caso);
            }
            List<Comentario> comentarios = archivo.getComentarios();
            for (Comentario comentariosComentario : comentarios) {
                comentariosComentario.setArchivo(null);
                comentariosComentario = em.merge(comentariosComentario);
            }
            em.remove(archivo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Archivo> findArchivoEntities() {
        return findArchivoEntities(true, -1, -1);
    }

    public List<Archivo> findArchivoEntities(int maxResults, int firstResult) {
        return findArchivoEntities(false, maxResults, firstResult);
    }

    private List<Archivo> findArchivoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Archivo.class));
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

    public Archivo findArchivo(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Archivo.class, id);
        } finally {
            em.close();
        }
    }

    public int getArchivoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Archivo> rt = cq.from(Archivo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
