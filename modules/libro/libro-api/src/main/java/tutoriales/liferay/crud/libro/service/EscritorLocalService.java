/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package tutoriales.liferay.crud.libro.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import tutoriales.liferay.crud.libro.model.Escritor;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for Escritor. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see EscritorLocalServiceUtil
 * @see tutoriales.liferay.crud.libro.service.base.EscritorLocalServiceBaseImpl
 * @see tutoriales.liferay.crud.libro.service.impl.EscritorLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface EscritorLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EscritorLocalServiceUtil} to access the escritor local service. Add custom service methods to {@link tutoriales.liferay.crud.libro.service.impl.EscritorLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasLibroEscritor(long libroId, long escritorId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasLibroEscritors(long libroId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Returns the number of escritors.
	*
	* @return the number of escritors
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEscritorsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLibroEscritorsCount(long libroId);

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link tutoriales.liferay.crud.libro.model.impl.EscritorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link tutoriales.liferay.crud.libro.model.impl.EscritorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns a range of all the escritors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link tutoriales.liferay.crud.libro.model.impl.EscritorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of escritors
	* @param end the upper bound of the range of escritors (not inclusive)
	* @return the range of escritors
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Escritor> getEscritors(int start, int end);

	/**
	* Returns all the escritors matching the UUID and company.
	*
	* @param uuid the UUID of the escritors
	* @param companyId the primary key of the company
	* @return the matching escritors, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Escritor> getEscritorsByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

	/**
	* Returns a range of escritors matching the UUID and company.
	*
	* @param uuid the UUID of the escritors
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of escritors
	* @param end the upper bound of the range of escritors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching escritors, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Escritor> getEscritorsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<Escritor> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Escritor> getLibroEscritors(long libroId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Escritor> getLibroEscritors(long libroId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Escritor> getLibroEscritors(long libroId, int start, int end,
		OrderByComparator<Escritor> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	/**
	* Returns the libroIds of the libros associated with the escritor.
	*
	* @param escritorId the escritorId of the escritor
	* @return long[] the libroIds of libros associated with the escritor
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getLibroPrimaryKeys(long escritorId);

	/**
	* Adds the escritor to the database. Also notifies the appropriate model listeners.
	*
	* @param escritor the escritor
	* @return the escritor that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Escritor addEscritor(Escritor escritor);

	/**
	* Creates a new escritor with the primary key. Does not add the escritor to the database.
	*
	* @param escritorId the primary key for the new escritor
	* @return the new escritor
	*/
	public Escritor createEscritor(long escritorId);

	/**
	* Deletes the escritor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param escritorId the primary key of the escritor
	* @return the escritor that was removed
	* @throws PortalException if a escritor with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Escritor deleteEscritor(long escritorId) throws PortalException;

	/**
	* Deletes the escritor from the database. Also notifies the appropriate model listeners.
	*
	* @param escritor the escritor
	* @return the escritor that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public Escritor deleteEscritor(Escritor escritor);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Escritor fetchEscritor(long escritorId);

	/**
	* Returns the escritor matching the UUID and group.
	*
	* @param uuid the escritor's UUID
	* @param groupId the primary key of the group
	* @return the matching escritor, or <code>null</code> if a matching escritor could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Escritor fetchEscritorByUuidAndGroupId(java.lang.String uuid,
		long groupId);

	/**
	* Returns the escritor with the primary key.
	*
	* @param escritorId the primary key of the escritor
	* @return the escritor
	* @throws PortalException if a escritor with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Escritor getEscritor(long escritorId) throws PortalException;

	/**
	* Returns the escritor matching the UUID and group.
	*
	* @param uuid the escritor's UUID
	* @param groupId the primary key of the group
	* @return the matching escritor
	* @throws PortalException if a matching escritor could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Escritor getEscritorByUuidAndGroupId(java.lang.String uuid,
		long groupId) throws PortalException;

	/**
	* Updates the escritor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param escritor the escritor
	* @return the escritor that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Escritor updateEscritor(Escritor escritor);

	public void addEscritor(long groupId, long companyId, long userId,
		java.lang.String userName, java.lang.String nombre);

	public void addLibroEscritor(long libroId, long escritorId);

	public void addLibroEscritor(long libroId, Escritor escritor);

	public void addLibroEscritors(long libroId, List<Escritor> escritors);

	public void addLibroEscritors(long libroId, long[] escritorIds);

	public void clearLibroEscritors(long libroId);

	public void deleteLibroEscritor(long libroId, long escritorId);

	public void deleteLibroEscritor(long libroId, Escritor escritor);

	public void deleteLibroEscritors(long libroId, List<Escritor> escritors);

	public void deleteLibroEscritors(long libroId, long[] escritorIds);

	public void setLibroEscritors(long libroId, long[] escritorIds);

	public void updateEscritor(long id, java.lang.String nombre)
		throws PortalException;
}