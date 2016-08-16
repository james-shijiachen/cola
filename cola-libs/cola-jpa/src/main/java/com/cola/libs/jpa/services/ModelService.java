/*
 * Copyright 2002-${Year} the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cola.libs.jpa.services;

import com.cola.libs.jpa.entities.AbstractEntity;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaUpdate;

/**
 * cola
 * Created by jiachen.shi on 7/18/2016.
 */
public interface ModelService {

    /**
     * Clear.
     */
    public void clear();

    /**
     * Gets entity graph.
     * @param str the str
     * @return the entity graph
     */
    public EntityGraph getEntityGraph(String str);

    /**
     * Create entity graph entity graph.
     * @param <T>    the type parameter
     * @param tClass the t class
     * @return the entity graph
     */
    public <T> EntityGraph<T> createEntityGraph(Class<T> tClass);

    /**
     * Gets current transacntion.
     * @return the current transacntion
     */
    public EntityTransaction getCurrentTransacntion();

    /**
     * Save t.
     * @param <T>    the type parameter
     * @param entity the entity
     * @return the t
     */
    public <T extends AbstractEntity> T save(T entity);

    /**
     * Save list.
     * @param <T>      the type parameter
     * @param entities the entities
     * @return the list
     */
    public <T extends AbstractEntity> List<T> save(Iterable<T> entities);

    /**
     * Delete.
     * @param <T>    the type parameter
     * @param <ID>   the type parameter
     * @param tClass the t class
     * @param id     the id
     */
    public <T extends AbstractEntity, ID extends Serializable> void delete(Class<T> tClass, ID id);

    /**
     * Delete.
     * @param <T>    the type parameter
     * @param entity the entity
     */
    public <T extends AbstractEntity> void delete(T entity);

    /**
     * Delete.
     * @param <T>      the type parameter
     * @param entities the entities
     */
    public <T extends AbstractEntity> void delete(Iterable<? extends T> entities);

    /**
     * Delete all.
     * @param <T>         the type parameter
     * @param entityClass the entity class
     */
    public <T extends AbstractEntity> void deleteAll(Class<T> entityClass);

    /**
     * Delete in batch.
     * @param <T>      the type parameter
     * @param entities the entities
     */
    public <T extends AbstractEntity> void deleteInBatch(Iterable<T> entities);

    /**
     * Load t.
     * @param <T>    the type parameter
     * @param <ID>   the type parameter
     * @param tClass the t class
     * @param id     the id
     * @return the t
     */
    public <T extends AbstractEntity, ID extends Serializable> T load(Class<T> tClass, ID id);

    /**
     * Load t.
     * @param <T>          the type parameter
     * @param <ID>         the type parameter
     * @param tClass       the t class
     * @param id           the id
     * @param lockModeType the lock mode type
     * @return the t
     */
    public <T extends AbstractEntity, ID extends Serializable> T load(Class<T> tClass, ID id, LockModeType lockModeType);

    /**
     * Load t.
     * @param <T>             the type parameter
     * @param <ID>            the type parameter
     * @param tClass          the t class
     * @param id              the id
     * @param entityGraphName the entity graph name
     * @return the t
     */
    public <T extends AbstractEntity, ID extends Serializable> T load(Class<T> tClass, ID id, String entityGraphName);

    /**
     * Load t.
     * @param <T>        the type parameter
     * @param <ID>       the type parameter
     * @param tClass     the t class
     * @param id         the id
     * @param properties the properties
     * @return the t
     */
    public <T extends AbstractEntity, ID extends Serializable> T load(Class<T> tClass, ID id, Map<String, Object> properties);

    /**
     * Load t.
     * @param <T>        the type parameter
     * @param <ID>       the type parameter
     * @param tClass     the t class
     * @param id         the id
     * @param type       the type
     * @param properties the properties
     * @return the t
     */
    public <T extends AbstractEntity, ID extends Serializable> T load(Class<T> tClass, ID id, LockModeType type, Map<String, Object> properties);

    /**
     * Get t.
     * @param <T>    the type parameter
     * @param <ID>   the type parameter
     * @param tClass the t class
     * @param id     the id
     * @return the t
     */
    public <T extends AbstractEntity, ID extends Serializable> T get(Class<T> tClass, ID id);

    /**
     * Execute int.
     * @param jpql the jpql
     * @return the int
     */
    public int execute(String jpql);

    /**
     * Execute int.
     * @param jpql    the jpql
     * @param parames the parames
     * @return the int
     */
    public int execute(String jpql, Iterable<Object> parames);

    /**
     * Execute int.
     * @param jpql    the jpql
     * @param parames the parames
     * @return the int
     */
    public int execute(String jpql, Map<String, Object> parames);

    /**
     * Execute int.
     * @param criteria the criteria
     * @return the int
     */
    public int execute(CriteriaUpdate criteria);

    /**
     * Execute int.
     * @param criteria the criteria
     * @return the int
     */
    public int execute(CriteriaDelete criteria);

    /**
     * Execute stored procedure t.
     * @param <T>                 the type parameter
     * @param <S>                 the type parameter
     * @param storedProcedureName the stored procedure name
     * @param params              the params
     * @param outParamName        the out param name
     * @param resultClass         the result class
     * @return the t
     */
    public <T, S> T executeStoredProcedure(String storedProcedureName, List<S> params, String outParamName, Class<T> resultClass);

    /**
     * Execute stored procedure t.
     * @param <T>                 the type parameter
     * @param <S>                 the type parameter
     * @param storedProcedureName the stored procedure name
     * @param params              the params
     * @param outParamName        the out param name
     * @param resultClass         the result class
     * @return the t
     */
    public <T, S> T executeStoredProcedure(String storedProcedureName, Map<String, S> params, String outParamName, Class<T> resultClass);

    /**
     * Exists boolean.
     * @param <T>         the type parameter
     * @param <ID>        the type parameter
     * @param entityClass the entity class
     * @param id          the id
     * @return the boolean
     */
    public <T extends AbstractEntity, ID extends Serializable> boolean exists(Class<T> entityClass, ID id);

}
