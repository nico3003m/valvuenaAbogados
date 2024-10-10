
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Abogado;
import logica.Cliente;
import logica.Archivo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Caso;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Nicolas Moreno
 */
public class CasoJpaController implements Serializable {

    public CasoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
      public CasoJpaController() {
        emf = Persistence.createEntityManagerFactory("valbuenaAbogadosPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Caso caso) {
        if (caso.getArchivos() == null) {
            caso.setArchivos(new ArrayList<Archivo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Abogado abogado = caso.getAbogado();
            if (abogado != null) {
                abogado = em.getReference(abogado.getClass(), abogado.getId());
                caso.setAbogado(abogado);
            }
            Cliente cliente = caso.getCliente();
            if (cliente != null) {
                cliente = em.getReference(cliente.getClass(), cliente.getId());
                caso.setCliente(cliente);
            }
            List<Archivo> attachedArchivos = new ArrayList<Archivo>();
            for (Archivo archivosArchivoToAttach : caso.getArchivos()) {
                archivosArchivoToAttach = em.getReference(archivosArchivoToAttach.getClass(), archivosArchivoToAttach.getId());
                attachedArchivos.add(archivosArchivoToAttach);
            }
            caso.setArchivos(attachedArchivos);
            em.persist(caso);
            if (abogado != null) {
                abogado.getCasos().add(caso);
                abogado = em.merge(abogado);
            }
            if (cliente != null) {
                cliente.getCasos().add(caso);
                cliente = em.merge(cliente);
            }
            for (Archivo archivosArchivo : caso.getArchivos()) {
                Caso oldCasoOfArchivosArchivo = archivosArchivo.getCaso();
                archivosArchivo.setCaso(caso);
                archivosArchivo = em.merge(archivosArchivo);
                if (oldCasoOfArchivosArchivo != null) {
                    oldCasoOfArchivosArchivo.getArchivos().remove(archivosArchivo);
                    oldCasoOfArchivosArchivo = em.merge(oldCasoOfArchivosArchivo);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Caso caso) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Caso persistentCaso = em.find(Caso.class, caso.getId());
            Abogado abogadoOld = persistentCaso.getAbogado();
            Abogado abogadoNew = caso.getAbogado();
            Cliente clienteOld = persistentCaso.getCliente();
            Cliente clienteNew = caso.getCliente();
            List<Archivo> archivosOld = persistentCaso.getArchivos();
            List<Archivo> archivosNew = caso.getArchivos();
            if (abogadoNew != null) {
                abogadoNew = em.getReference(abogadoNew.getClass(), abogadoNew.getId());
                caso.setAbogado(abogadoNew);
            }
            if (clienteNew != null) {
                clienteNew = em.getReference(clienteNew.getClass(), clienteNew.getId());
                caso.setCliente(clienteNew);
            }
            List<Archivo> attachedArchivosNew = new ArrayList<Archivo>();
            for (Archivo archivosNewArchivoToAttach : archivosNew) {
                archivosNewArchivoToAttach = em.getReference(archivosNewArchivoToAttach.getClass(), archivosNewArchivoToAttach.getId());
                attachedArchivosNew.add(archivosNewArchivoToAttach);
            }
            archivosNew = attachedArchivosNew;
            caso.setArchivos(archivosNew);
            caso = em.merge(caso);
            if (abogadoOld != null && !abogadoOld.equals(abogadoNew)) {
                abogadoOld.getCasos().remove(caso);
                abogadoOld = em.merge(abogadoOld);
            }
            if (abogadoNew != null && !abogadoNew.equals(abogadoOld)) {
                abogadoNew.getCasos().add(caso);
                abogadoNew = em.merge(abogadoNew);
            }
            if (clienteOld != null && !clienteOld.equals(clienteNew)) {
                clienteOld.getCasos().remove(caso);
                clienteOld = em.merge(clienteOld);
            }
            if (clienteNew != null && !clienteNew.equals(clienteOld)) {
                clienteNew.getCasos().add(caso);
                clienteNew = em.merge(clienteNew);
            }
            for (Archivo archivosOldArchivo : archivosOld) {
                if (!archivosNew.contains(archivosOldArchivo)) {
                    archivosOldArchivo.setCaso(null);
                    archivosOldArchivo = em.merge(archivosOldArchivo);
                }
            }
            for (Archivo archivosNewArchivo : archivosNew) {
                if (!archivosOld.contains(archivosNewArchivo)) {
                    Caso oldCasoOfArchivosNewArchivo = archivosNewArchivo.getCaso();
                    archivosNewArchivo.setCaso(caso);
                    archivosNewArchivo = em.merge(archivosNewArchivo);
                    if (oldCasoOfArchivosNewArchivo != null && !oldCasoOfArchivosNewArchivo.equals(caso)) {
                        oldCasoOfArchivosNewArchivo.getArchivos().remove(archivosNewArchivo);
                        oldCasoOfArchivosNewArchivo = em.merge(oldCasoOfArchivosNewArchivo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = caso.getId();
                if (findCaso(id) == null) {
                    throw new NonexistentEntityException("The caso with id " + id + " no longer exists.");
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
            Caso caso;
            try {
                caso = em.getReference(Caso.class, id);
                caso.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The caso with id " + id + " no longer exists.", enfe);
            }
            Abogado abogado = caso.getAbogado();
            if (abogado != null) {
                abogado.getCasos().remove(caso);
                abogado = em.merge(abogado);
            }
            Cliente cliente = caso.getCliente();
            if (cliente != null) {
                cliente.getCasos().remove(caso);
                cliente = em.merge(cliente);
            }
            List<Archivo> archivos = caso.getArchivos();
            for (Archivo archivosArchivo : archivos) {
                archivosArchivo.setCaso(null);
                archivosArchivo = em.merge(archivosArchivo);
            }
            em.remove(caso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Caso> findCasoEntities() {
        return findCasoEntities(true, -1, -1);
    }

    public List<Caso> findCasoEntities(int maxResults, int firstResult) {
        return findCasoEntities(false, maxResults, firstResult);
    }

    private List<Caso> findCasoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Caso.class));
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

    public Caso findCaso(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Caso.class, id);
        } finally {
            em.close();
        }
    }

    public int getCasoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Caso> rt = cq.from(Caso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
