package org.hi.framework.dao.ibatis;

public class MappingException extends RuntimeException {
	private final String path;
	private final String type;
	public MappingException(String customMessage, String type, String path, Throwable cause) {
		super(customMessage, cause);
		this.type=type;
		this.path=path;
	}
	public MappingException(String type, String path, Throwable cause) {
		this("Could not parse mapping document from " + type + (path==null?"":" " + path), type, path, cause);		
	}
	
	public String getType() {
		return type;
	}
	
	public String getPath() {
		return path;
	}
}
