package org.hi.framework.dao.hibernate;

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;

public class StringClobType implements UserType {
	public int[] sqlTypes() {
		return new int[] { Types.CLOB };
	}

	public Class returnedClass() {
		return String.class;
	}

	public boolean equals(Object x, Object y) {
		return (x == y) || (x != null && y != null && (x.equals(y)));
	}

	public Object nullSafeGet(ResultSet rs, String[] names, Object owner)
			throws HibernateException, SQLException {
		Reader reader = rs.getCharacterStream(names[0]);
		if (reader == null)
			return null;
		StringBuffer sb = new StringBuffer();
		try {
			char[] charbuf = new char[4096];
			for (int i = reader.read(charbuf); i > 0; i = reader.read(charbuf)) {
				sb.append(charbuf, 0, i);
			}
		} catch (IOException e) {
			throw new SQLException(e.getMessage());
		}
		return sb.toString();
	}

	public void nullSafeSet(PreparedStatement st, Object value, int index)
			throws HibernateException, SQLException {
		if (value != null) {
			StringReader r = new StringReader((String) value);
			st.setCharacterStream(index, r, ((String) value).length());
		} else {
			st.setNull(index, sqlTypes()[0]);
		}
	}

	public Object deepCopy(Object value) {
		if (value == null)
			return null;
		return new String((String) value);
	}

	public boolean isMutable() {
		return false;
	}

	/*
	 * @see org.hibernate.usertype.UserType#hashCode(java.lang.Object)
	 */
	public int hashCode(Object arg0) throws HibernateException {
		return 0;
	}

	/*
	 * @see org.hibernate.usertype.UserType#disassemble(java.lang.Object)
	 */
	public Serializable disassemble(Object arg0) throws HibernateException {
		return null;
	}

	/*
	 * @see org.hibernate.usertype.UserType#assemble(java.io.Serializable,
	 * java.lang.Object)
	 */
	public Object assemble(Serializable arg0, Object arg1)
			throws HibernateException {
		return null;
	}

	/*
	 * @see org.hibernate.usertype.UserType#replace(java.lang.Object,
	 * java.lang.Object, java.lang.Object)
	 */
	public Object replace(Object arg0, Object arg1, Object arg2)
			throws HibernateException {
		return null;
	}

}
