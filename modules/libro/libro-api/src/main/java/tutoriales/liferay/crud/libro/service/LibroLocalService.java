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

import tutoriales.liferay.crud.libro.model.Libro;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for Libro. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see LibroLocalServiceUtil
 * @see tutoriales.liferay.crud.libro.service.base.LibroLocalServiceBaseImpl
 * @see tutoriales.liferay.crud.libro.service.impl.LibroLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface LibroLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LibroLocalServiceUtil} to access the libro local service. Add custom service methods to {@link tutoriales.liferay.crud.libro.service.impl.LibroLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasEscritorLibro(long escritorId, long libroId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasEscritorLibros(long escritorId);

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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEscritorLibrosCount(long escritorId);

	/**
	* Returns the number of libros.
	*
	* @return the number of libros
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLibrosCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link tutoriales.liferay.crud.libro.model.impl.LibroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link tutoriales.liferay.crud.libro.model.impl.LibroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Libro> getEscritorLibros(long escritorId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Libro> getEscritorLibros(long escritorId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Libro> getEscritorLibros(long escritorId, int start, int end,
		OrderByComparator<Libro> orderByComparator);

	/**
	* Returns a range of all the libros.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link tutoriales.liferay.crud.libro.model.impl.LibroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of libros
	* @param end the upper bound of the range of libros (not inclusive)
	* @return the range of libros
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Libro> getLibros(int start, int end);

	/**
	* Returns all the libros matching the UUID and company.
	*
	* @param uuid the UUID of the libros
	* @param companyId the primary key of the company
	* @return the matching libros, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Libro> getLibrosByUuidAndCompanyId(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of libros matching the UUID and company.
	*
	* @param uuid the UUID of the libros
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of libros
	* @param end the upper bound of the range of libros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching libros, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Libro> getLibrosByUuidAndCompanyId(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Libro> orderByComparator);

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
	* Returns the escritorIds of the escritors associated with the libro.
	*
	* @param libroId the libroId of the libro
	* @return long[] the escritorIds of escritors associated with the libro
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getEscritorPrimaryKeys(long libroId);

	/**
	* Adds the libro to the database. Also notifies the appropriate model listeners.
	*
	* @param libro the libro
	* @return the libro that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Libro addLibro(Libro libro);

	/**
	* Creates a new libro with the primary key. Does not add the libro to the database.
	*
	* @param libroId the primary key for the new libro
	* @return the new libro
	*/
	public Libro createLibro(long libroId);

	/**
	* Deletes the libro with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param libroId the primary key of the libro
	* @return the libro that was removed
	* @throws PortalException if a libro with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Libro deleteLibro(long libroId) throws PortalException;

	/**
	* Deletes the libro from the database. Also notifies the appropriate model listeners.
	*
	* @param libro the libro
	* @return the libro that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public Libro deleteLibro(Libro libro);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Libro fetchLibro(long libroId);

	/**
	* Returns the libro matching the UUID and group.
	*
	* @param uuid the libro's UUID
	* @param groupId the primary key of the group
	* @return the matching libro, or <code>null</code> if a matching libro could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Libro fetchLibroByUuidAndGroupId(java.lang.String uuid, long groupId);

	/**
	* Returns the libro with the primary key.
	*
	* @param libroId the primary key of the libro
	* @return the libro
	* @throws PortalException if a libro with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Libro getLibro(long libroId) throws PortalException;

	/**
	* Returns the libro matching the UUID and group.
	*
	* @param uuid the libro's UUID
	* @param groupId the primary key of the group
	* @return the matching libro
	* @throws PortalException if a matching libro could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Libro getLibroByUuidAndGroupId(java.lang.String uuid, long groupId)
		throws PortalException;

	/**
	* Updates the libro in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param libro the libro
	* @return the libro that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Libro updateLibro(Libro libro);

	public void addEscritorLibro(long escritorId, long libroId);

	public void addEscritorLibro(long escritorId, Libro libro);

	public void addEscritorLibros(long escritorId, List<Libro> libros);

	public void addEscritorLibros(long escritorId, long[] libroIds);

	public void clearEscritorLibros(long escritorId);

	public void deleteEscritorLibro(long escritorId, long libroId);

	public void deleteEscritorLibro(long escritorId, Libro libro);

	public void deleteEscritorLibros(long escritorId, List<Libro> libros);

	public void deleteEscritorLibros(long escritorId, long[] libroIds);

	public void setEscritorLibros(long escritorId, long[] libroIds);
}