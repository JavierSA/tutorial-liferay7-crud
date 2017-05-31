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

package tutoriales.liferay.crud.libro.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import tutoriales.liferay.crud.libro.model.Libro;
import tutoriales.liferay.crud.libro.service.LibroLocalService;
import tutoriales.liferay.crud.libro.service.persistence.EscritorPersistence;
import tutoriales.liferay.crud.libro.service.persistence.LibroPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the libro local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link tutoriales.liferay.crud.libro.service.impl.LibroLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see tutoriales.liferay.crud.libro.service.impl.LibroLocalServiceImpl
 * @see tutoriales.liferay.crud.libro.service.LibroLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class LibroLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements LibroLocalService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link tutoriales.liferay.crud.libro.service.LibroLocalServiceUtil} to access the libro local service.
	 */

	/**
	 * Adds the libro to the database. Also notifies the appropriate model listeners.
	 *
	 * @param libro the libro
	 * @return the libro that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Libro addLibro(Libro libro) {
		libro.setNew(true);

		return libroPersistence.update(libro);
	}

	/**
	 * Creates a new libro with the primary key. Does not add the libro to the database.
	 *
	 * @param libroId the primary key for the new libro
	 * @return the new libro
	 */
	@Override
	public Libro createLibro(long libroId) {
		return libroPersistence.create(libroId);
	}

	/**
	 * Deletes the libro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param libroId the primary key of the libro
	 * @return the libro that was removed
	 * @throws PortalException if a libro with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Libro deleteLibro(long libroId) throws PortalException {
		return libroPersistence.remove(libroId);
	}

	/**
	 * Deletes the libro from the database. Also notifies the appropriate model listeners.
	 *
	 * @param libro the libro
	 * @return the libro that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Libro deleteLibro(Libro libro) {
		return libroPersistence.remove(libro);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Libro.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return libroPersistence.findWithDynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return libroPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return libroPersistence.findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return libroPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return libroPersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public Libro fetchLibro(long libroId) {
		return libroPersistence.fetchByPrimaryKey(libroId);
	}

	/**
	 * Returns the libro matching the UUID and group.
	 *
	 * @param uuid the libro's UUID
	 * @param groupId the primary key of the group
	 * @return the matching libro, or <code>null</code> if a matching libro could not be found
	 */
	@Override
	public Libro fetchLibroByUuidAndGroupId(String uuid, long groupId) {
		return libroPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the libro with the primary key.
	 *
	 * @param libroId the primary key of the libro
	 * @return the libro
	 * @throws PortalException if a libro with the primary key could not be found
	 */
	@Override
	public Libro getLibro(long libroId) throws PortalException {
		return libroPersistence.findByPrimaryKey(libroId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(libroLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Libro.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("libroId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(libroLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Libro.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("libroId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(libroLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Libro.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("libroId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {
		final ExportActionableDynamicQuery exportActionableDynamicQuery = new ExportActionableDynamicQuery() {
				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary = portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(stagedModelType,
						modelAdditionCount);

					long modelDeletionCount = ExportImportHelperUtil.getModelDeletionCount(portletDataContext,
							stagedModelType);

					manifestSummary.addModelDeletionCount(stagedModelType,
						modelDeletionCount);

					return modelAdditionCount;
				}
			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(new ActionableDynamicQuery.AddCriteriaMethod() {
				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(dynamicQuery,
						"modifiedDate");
				}
			});

		exportActionableDynamicQuery.setCompanyId(portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Libro>() {
				@Override
				public void performAction(Libro libro)
					throws PortalException {
					StagedModelDataHandlerUtil.exportStagedModel(portletDataContext,
						libro);
				}
			});
		exportActionableDynamicQuery.setStagedModelType(new StagedModelType(
				PortalUtil.getClassNameId(Libro.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return libroLocalService.deleteLibro((Libro)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return libroPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the libros matching the UUID and company.
	 *
	 * @param uuid the UUID of the libros
	 * @param companyId the primary key of the company
	 * @return the matching libros, or an empty list if no matches were found
	 */
	@Override
	public List<Libro> getLibrosByUuidAndCompanyId(String uuid, long companyId) {
		return libroPersistence.findByUuid_C(uuid, companyId);
	}

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
	@Override
	public List<Libro> getLibrosByUuidAndCompanyId(String uuid, long companyId,
		int start, int end, OrderByComparator<Libro> orderByComparator) {
		return libroPersistence.findByUuid_C(uuid, companyId, start, end,
			orderByComparator);
	}

	/**
	 * Returns the libro matching the UUID and group.
	 *
	 * @param uuid the libro's UUID
	 * @param groupId the primary key of the group
	 * @return the matching libro
	 * @throws PortalException if a matching libro could not be found
	 */
	@Override
	public Libro getLibroByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {
		return libroPersistence.findByUUID_G(uuid, groupId);
	}

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
	@Override
	public List<Libro> getLibros(int start, int end) {
		return libroPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of libros.
	 *
	 * @return the number of libros
	 */
	@Override
	public int getLibrosCount() {
		return libroPersistence.countAll();
	}

	/**
	 * Updates the libro in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param libro the libro
	 * @return the libro that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Libro updateLibro(Libro libro) {
		return libroPersistence.update(libro);
	}

	/**
	 */
	@Override
	public void addEscritorLibro(long escritorId, long libroId) {
		escritorPersistence.addLibro(escritorId, libroId);
	}

	/**
	 */
	@Override
	public void addEscritorLibro(long escritorId, Libro libro) {
		escritorPersistence.addLibro(escritorId, libro);
	}

	/**
	 */
	@Override
	public void addEscritorLibros(long escritorId, long[] libroIds) {
		escritorPersistence.addLibros(escritorId, libroIds);
	}

	/**
	 */
	@Override
	public void addEscritorLibros(long escritorId, List<Libro> libros) {
		escritorPersistence.addLibros(escritorId, libros);
	}

	/**
	 */
	@Override
	public void clearEscritorLibros(long escritorId) {
		escritorPersistence.clearLibros(escritorId);
	}

	/**
	 */
	@Override
	public void deleteEscritorLibro(long escritorId, long libroId) {
		escritorPersistence.removeLibro(escritorId, libroId);
	}

	/**
	 */
	@Override
	public void deleteEscritorLibro(long escritorId, Libro libro) {
		escritorPersistence.removeLibro(escritorId, libro);
	}

	/**
	 */
	@Override
	public void deleteEscritorLibros(long escritorId, long[] libroIds) {
		escritorPersistence.removeLibros(escritorId, libroIds);
	}

	/**
	 */
	@Override
	public void deleteEscritorLibros(long escritorId, List<Libro> libros) {
		escritorPersistence.removeLibros(escritorId, libros);
	}

	/**
	 * Returns the escritorIds of the escritors associated with the libro.
	 *
	 * @param libroId the libroId of the libro
	 * @return long[] the escritorIds of escritors associated with the libro
	 */
	@Override
	public long[] getEscritorPrimaryKeys(long libroId) {
		return libroPersistence.getEscritorPrimaryKeys(libroId);
	}

	/**
	 */
	@Override
	public List<Libro> getEscritorLibros(long escritorId) {
		return escritorPersistence.getLibros(escritorId);
	}

	/**
	 */
	@Override
	public List<Libro> getEscritorLibros(long escritorId, int start, int end) {
		return escritorPersistence.getLibros(escritorId, start, end);
	}

	/**
	 */
	@Override
	public List<Libro> getEscritorLibros(long escritorId, int start, int end,
		OrderByComparator<Libro> orderByComparator) {
		return escritorPersistence.getLibros(escritorId, start, end,
			orderByComparator);
	}

	/**
	 */
	@Override
	public int getEscritorLibrosCount(long escritorId) {
		return escritorPersistence.getLibrosSize(escritorId);
	}

	/**
	 */
	@Override
	public boolean hasEscritorLibro(long escritorId, long libroId) {
		return escritorPersistence.containsLibro(escritorId, libroId);
	}

	/**
	 */
	@Override
	public boolean hasEscritorLibros(long escritorId) {
		return escritorPersistence.containsLibros(escritorId);
	}

	/**
	 */
	@Override
	public void setEscritorLibros(long escritorId, long[] libroIds) {
		escritorPersistence.setLibros(escritorId, libroIds);
	}

	/**
	 * Returns the escritor local service.
	 *
	 * @return the escritor local service
	 */
	public tutoriales.liferay.crud.libro.service.EscritorLocalService getEscritorLocalService() {
		return escritorLocalService;
	}

	/**
	 * Sets the escritor local service.
	 *
	 * @param escritorLocalService the escritor local service
	 */
	public void setEscritorLocalService(
		tutoriales.liferay.crud.libro.service.EscritorLocalService escritorLocalService) {
		this.escritorLocalService = escritorLocalService;
	}

	/**
	 * Returns the escritor persistence.
	 *
	 * @return the escritor persistence
	 */
	public EscritorPersistence getEscritorPersistence() {
		return escritorPersistence;
	}

	/**
	 * Sets the escritor persistence.
	 *
	 * @param escritorPersistence the escritor persistence
	 */
	public void setEscritorPersistence(EscritorPersistence escritorPersistence) {
		this.escritorPersistence = escritorPersistence;
	}

	/**
	 * Returns the libro local service.
	 *
	 * @return the libro local service
	 */
	public LibroLocalService getLibroLocalService() {
		return libroLocalService;
	}

	/**
	 * Sets the libro local service.
	 *
	 * @param libroLocalService the libro local service
	 */
	public void setLibroLocalService(LibroLocalService libroLocalService) {
		this.libroLocalService = libroLocalService;
	}

	/**
	 * Returns the libro persistence.
	 *
	 * @return the libro persistence
	 */
	public LibroPersistence getLibroPersistence() {
		return libroPersistence;
	}

	/**
	 * Sets the libro persistence.
	 *
	 * @param libroPersistence the libro persistence
	 */
	public void setLibroPersistence(LibroPersistence libroPersistence) {
		this.libroPersistence = libroPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("tutoriales.liferay.crud.libro.model.Libro",
			libroLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"tutoriales.liferay.crud.libro.model.Libro");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return LibroLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Libro.class;
	}

	protected String getModelClassName() {
		return Libro.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = libroPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = tutoriales.liferay.crud.libro.service.EscritorLocalService.class)
	protected tutoriales.liferay.crud.libro.service.EscritorLocalService escritorLocalService;
	@BeanReference(type = EscritorPersistence.class)
	protected EscritorPersistence escritorPersistence;
	@BeanReference(type = LibroLocalService.class)
	protected LibroLocalService libroLocalService;
	@BeanReference(type = LibroPersistence.class)
	protected LibroPersistence libroPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}