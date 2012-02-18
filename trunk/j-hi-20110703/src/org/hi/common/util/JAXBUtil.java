package org.hi.common.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;


public class JAXBUtil {
	protected final static Log log = LogFactory.getLog("org.hi.common.util.JAXBUtil");
	
	public static Object loadObect(Class clzz, String fileName) throws JAXBException, FileNotFoundException{
		
		 JAXBContext jc = JAXBContext.newInstance( clzz.getPackage().getName(), clzz.getClassLoader() );
		 Unmarshaller u = jc.createUnmarshaller();
		 Object obj;
		try {
			obj = u.unmarshal( new FileInputStream( fileName ) );
		} catch (FileNotFoundException e) {
			log.error("not found xml file  in " + fileName);
			throw e;
		}
		return obj;
	}
	
	public static Object loadObect(Class clzz, InputStream inputStream) throws JAXBException{
		
		 JAXBContext jc = JAXBContext.newInstance( clzz.getPackage().getName(), clzz.getClassLoader() );
		 Unmarshaller u = jc.createUnmarshaller();
		 Object obj;
		obj = u.unmarshal( inputStream );
		return obj;
	}

	public static Object loadObect(Class clzz, Reader reader) throws JAXBException{
		
		 JAXBContext jc = JAXBContext.newInstance( clzz.getPackage().getName(), clzz.getClassLoader() );
		 Unmarshaller u = jc.createUnmarshaller();
		 Object obj;
		obj = u.unmarshal( reader );
		return obj;
	}	
	
	public static File writeObject( Class clzz, Object obj, String fileName) throws JAXBException, IOException{
		return writeObject(clzz, obj, fileName, null);
	}
	
	public static File writeObject( Class clzz, Object obj, String fileName, String[] cDatas) throws JAXBException, IOException{
		 File f = new File(fileName);
		 
		 JAXBContext context = JAXBContext.newInstance( clzz.getPackage().getName(), clzz.getClassLoader() );
		 Marshaller m = context.createMarshaller();

		 m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 // get an Apache XMLSerializer configured to generate CDATA
		 if(cDatas != null){
			 XMLSerializer serializer = getXMLSerializer(cDatas, f);
		 	m.marshal(obj, serializer.asContentHandler());
		 }
		 else
			 m.marshal(obj, f);
		 return f;
	}
	
	public static OutputStream toOutputStream(Class clzz, Object obj,OutputStream os ) throws JAXBException, IOException{
		return toOutputStream(clzz, obj, null);
	}
	
	public static OutputStream toOutputStream( Class clzz, Object obj, OutputStream os, String[] cDatas) throws JAXBException, IOException{
		if(os == null)
			os = new BufferedOutputStream(System.out);

		 JAXBContext context = JAXBContext.newInstance( clzz.getPackage().getName(), clzz.getClassLoader() );
		 Marshaller m = context.createMarshaller();

		 m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 if(cDatas != null){
			 XMLSerializer serializer = getXMLSerializer(cDatas, os);
		 	m.marshal(obj, serializer.asContentHandler());
		 }
		 else
			 m.marshal(obj,os);
		 return os;
	}
	
	   private static XMLSerializer getXMLSerializer(String[] cDatas, OutputStream os) throws FileNotFoundException {
	        OutputFormat of = new OutputFormat();
	        of.setCDataElements(cDatas);
	        of.setPreserveSpace(true);
	        of.setOmitXMLDeclaration(true);
	        
	        XMLSerializer serializer = new XMLSerializer(of);
	        serializer.setOutputByteStream(os);
	        return serializer;
	    }
	
    private static XMLSerializer getXMLSerializer(String[] cDatas, File f) throws FileNotFoundException {
        OutputFormat of = new OutputFormat();
        of.setCDataElements(cDatas);
        of.setPreserveSpace(true);
        of.setOmitXMLDeclaration(true);
        XMLSerializer serializer = new XMLSerializer(of);
        serializer.setOutputByteStream(new FileOutputStream(f));
        return serializer;
    }
        

       
	
}
