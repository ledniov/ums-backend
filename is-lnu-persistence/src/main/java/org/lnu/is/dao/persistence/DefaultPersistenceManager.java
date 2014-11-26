package org.lnu.is.dao.persistence;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.lnu.is.domain.Model;
import org.lnu.is.domain.common.RowStatus;
import org.lnu.is.pagination.PagedQuerySearch;
import org.lnu.is.pagination.PagedResult;
import org.lnu.is.queries.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * Persistance Manager to work with entityManager.
 * @author ivanursul
 *
 * @param <T> Entity class.
 * @param <I> IDentifier class.
 */
@Repository("persistenceManager")
public class DefaultPersistenceManager<T extends Model, I> implements PersistenceManager<T, I> {
    private static final Logger LOG = LoggerFactory.getLogger(DefaultPersistenceManager.class);

    private static final String COUNT_QUERY = "SELECT COUNT(*) FROM %s a WHERE a IN(%s) ";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public T create(final T entity) {
		LOG.info("Saving entity for class:{}", entity.getClass());
		entityManager.persist(entity);
		return entity;
    }

    @Override
    public T findById(final Class<T> clazz, final I id) {
        T entity = entityManager.find(clazz, id);
        return entity;
    }

    @Override
    public T update(final T entity) {
    	LOG.info("Updating entity for class:{}", entity.getClass());
        return entityManager.merge(entity);
    }

    @Override
    public void remove(final T entity) {
    	LOG.info("Removing entity for class:{}", entity.getClass());
        entity.setActual(0);
        entity.setStatus(RowStatus.DELETED);
        update(entity);
    }

    @Override
    public T executeSingleResultQuery(final Query<T> query) {
        Query<T> finalQuery = query;
        TypedQuery<T> typedQuery = createQuery(finalQuery.getQuery(), finalQuery.getParameters(), finalQuery.getEntityClass());

        return typedQuery.getSingleResult();
    }

    @Override
    public List<T> executeMultipleResultQuery(final Query<T> query) {
        Query<T> finalQuery = query;
        TypedQuery<T> typedQuery = createQuery(finalQuery.getQuery(), finalQuery.getParameters(), finalQuery.getEntityClass());

        return typedQuery.getResultList();
    }

    @Override
    public PagedResult<T> search(final PagedQuerySearch<T> searchRequest) {
        Query<T> finalQuery =  new Query<T>(searchRequest.getClazz(), searchRequest.getQuery().getQuery(), searchRequest.getParameters());
        
        TypedQuery<T> typedQuery = createQuery(searchRequest.getQuery().getQuery(), searchRequest.getParameters(), searchRequest.getClazz());
        typedQuery.setFirstResult(searchRequest.getOffset());
        typedQuery.setMaxResults(searchRequest.getLimit());

        Long count = getQueryCount(finalQuery.getQuery(), finalQuery.getParameters(), finalQuery.getEntityClass());

        PagedResult<T> result = new PagedResult<T>(searchRequest.getOffset(), searchRequest.getLimit(), count, typedQuery.getResultList());

        return result;
    }

    /**
     * Gets query count for every.
     * @param <M> for generic class.
     * @param querySql query
     * @param parameters parameters.
     * @param clazz class isstance.
     * @return Count of elements in query
     */
    private <M> Long getQueryCount(final String querySql, final Map<String, Object> parameters, final Class<M> clazz) {

        String jpQuery = String.format(COUNT_QUERY, clazz.getSimpleName(), querySql);

        TypedQuery<Long> countQuery = createQuery(jpQuery, parameters, Long.class);

        return countQuery.getSingleResult();
    }

    /**
     * Creates typed Query for entityManager.
     * @param <M> for generic class.
     * @param querySql query.
     * @param parameters required parameters(can be empty)
     * @param clazz class instance.
     * @return Typed Query instance.
     */
    private <M> TypedQuery<M> createQuery(final String querySql, final Map<String, Object> parameters, final Class<M> clazz) {
        TypedQuery<M> typedQuery = entityManager.createQuery(querySql, clazz);

        LOG.info(String.format("Create JPQL: query=[%s]; parameters=[%s] ", querySql, parameters));

        for (Entry<String, Object> entry : parameters.entrySet()) {
            typedQuery.setParameter(entry.getKey(), entry.getValue());
        }

        return typedQuery;
    }
}
