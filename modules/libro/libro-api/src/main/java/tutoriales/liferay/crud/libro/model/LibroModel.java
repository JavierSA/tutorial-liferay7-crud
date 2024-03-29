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

package tutoriales.liferay.crud.libro.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Libro service. Represents a row in the &quot;LIBRO_Libro&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link tutoriales.liferay.crud.libro.model.impl.LibroModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link tutoriales.liferay.crud.libro.model.impl.LibroImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Libro
 * @see tutoriales.liferay.crud.libro.model.impl.LibroImpl
 * @see tutoriales.liferay.crud.libro.model.impl.LibroModelImpl
 * @generated
 */
@ProviderType
public interface LibroModel extends BaseModel<Libro>, GroupedModel, ShardedModel,
	StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a libro model instance should use the {@link Libro} interface instead.
	 */

	/**
	 * Returns the primary key of this libro.
	 *
	 * @return the primary key of this libro
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this libro.
	 *
	 * @param primaryKey the primary key of this libro
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this libro.
	 *
	 * @return the uuid of this libro
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this libro.
	 *
	 * @param uuid the uuid of this libro
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the libro ID of this libro.
	 *
	 * @return the libro ID of this libro
	 */
	public long getLibroId();

	/**
	 * Sets the libro ID of this libro.
	 *
	 * @param libroId the libro ID of this libro
	 */
	public void setLibroId(long libroId);

	/**
	 * Returns the group ID of this libro.
	 *
	 * @return the group ID of this libro
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this libro.
	 *
	 * @param groupId the group ID of this libro
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this libro.
	 *
	 * @return the company ID of this libro
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this libro.
	 *
	 * @param companyId the company ID of this libro
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this libro.
	 *
	 * @return the user ID of this libro
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this libro.
	 *
	 * @param userId the user ID of this libro
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this libro.
	 *
	 * @return the user uuid of this libro
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this libro.
	 *
	 * @param userUuid the user uuid of this libro
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this libro.
	 *
	 * @return the user name of this libro
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this libro.
	 *
	 * @param userName the user name of this libro
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this libro.
	 *
	 * @return the create date of this libro
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this libro.
	 *
	 * @param createDate the create date of this libro
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this libro.
	 *
	 * @return the modified date of this libro
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this libro.
	 *
	 * @param modifiedDate the modified date of this libro
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the titulo of this libro.
	 *
	 * @return the titulo of this libro
	 */
	@AutoEscape
	public String getTitulo();

	/**
	 * Sets the titulo of this libro.
	 *
	 * @param titulo the titulo of this libro
	 */
	public void setTitulo(String titulo);

	/**
	 * Returns the publicacion of this libro.
	 *
	 * @return the publicacion of this libro
	 */
	public Date getPublicacion();

	/**
	 * Sets the publicacion of this libro.
	 *
	 * @param publicacion the publicacion of this libro
	 */
	public void setPublicacion(Date publicacion);

	/**
	 * Returns the genero of this libro.
	 *
	 * @return the genero of this libro
	 */
	@AutoEscape
	public String getGenero();

	/**
	 * Sets the genero of this libro.
	 *
	 * @param genero the genero of this libro
	 */
	public void setGenero(String genero);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(tutoriales.liferay.crud.libro.model.Libro libro);

	@Override
	public int hashCode();

	@Override
	public CacheModel<tutoriales.liferay.crud.libro.model.Libro> toCacheModel();

	@Override
	public tutoriales.liferay.crud.libro.model.Libro toEscapedModel();

	@Override
	public tutoriales.liferay.crud.libro.model.Libro toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}