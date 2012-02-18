
package org.hi.base.menu.strutsmenu;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author ���
 * Created on 2004-3-23
 */
public class XmlUtil {

	private Log log = LogFactory.getLog(this.getClass());

	/**
	 * @param obj
	 * @return
	 * @throws Exception
	 * ��һ�����󱣴�Ϊһ��XML��
	 */
	public String getXml(Object obj) throws Exception {
		String result = "";
		String pre = String.valueOf(System.currentTimeMillis());
		File tmp = null;
		try {
			tmp = File.createTempFile(pre, ".tmp");
			write(obj, tmp.getAbsolutePath());
			BufferedReader in =
				new BufferedReader(new FileReader(tmp.getAbsolutePath()));
			String str;
			while ((str = in.readLine()) != null) {
				result += str;
			}
			in.close();
		} catch (IOException e) {
			log.error(e, e);
		} finally {
			try {
				if (tmp != null)
					tmp.delete();
			} catch (RuntimeException e1) {
			}
		}

		return result;

	}
	/**
	 * @param xml
	 * @return
	 * @throws Exception
	 * ��һ��XML���лָ�һ������
	 * 
	 */
	public Object getObjFromXml(String xml) throws Exception {
		Object result = null;
		String pre = String.valueOf(System.currentTimeMillis());
		File tmp = null;
		try {
			tmp = File.createTempFile(pre, ".tmp");

			BufferedWriter in =
				new BufferedWriter(new FileWriter(tmp.getAbsolutePath()));
			in.write(xml);
			in.close();
			result = read(tmp.getAbsolutePath());
		} catch (IOException e) {
			log.error(e, e);
		} finally {
			try {
				if (tmp != null)
					tmp.delete();
			} catch (RuntimeException e1) {
			}
		}

		return result;
	}

	/**
	 * @param obj
	 * @param fileName
	 * @throws FileNotFoundException
	 * ��һ�����󱣴浽һ��ָ�����ļ���
	 */
	public void write(Object obj, String fileName)
		throws FileNotFoundException {
		try {
			dowrite(obj, new FileOutputStream(fileName));
		} catch (FileNotFoundException e) {
//			log.error(e, e);
			throw e;
		}
	}

	private void dowrite(Object obj, OutputStream io) {
		XMLEncoder encoder = null;

		try {
			encoder = new XMLEncoder(io);
			encoder.writeObject(obj);
		} catch (Exception e) {
			log.error(e, e);
		} finally {
			try {
				if (encoder != null) {
					encoder.close();
				}
			} catch (Exception e1) {
				log.error(e1, e1);
			}
		}
	}

	/**
	 * @param fileName
	 * @return
	 * @throws FileNotFoundException
	 *  ��һ��ָ����XML�ļ��лָ�һ������
	 */
	public Object read(String fileName) throws FileNotFoundException {

			FileInputStream in = new FileInputStream(fileName);
			return read(in);

	}
	
	public Object read(InputStream in) throws FileNotFoundException {
		XMLDecoder decoder = null;

		try {
			decoder = new XMLDecoder(in);

			Object x = decoder.readObject();

			return x;
		}finally {
			try {
				if (decoder != null) {
					decoder.close();
				}
			} catch (Exception e1) {
				log.error(e1, e1);
			}
		}
	}
}