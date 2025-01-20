package de.ronasoft.springboot.vscode.domain;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Repräsentiert einen Applicationserver. In dieser Klasse wird für
 * jeden ApplicationServer festgehalten, wann der letzte Request oder
 * Ping eingetroffen ist und ob bereits eine Initial-Übertragung
 * aller Sessions stattgefunden hat.
 * 
 * TTL = 86400
 * 86400 Sekunden = 1 Tag
 * 
 * @author m500194
 */
public class ApplicationServerDefinition implements Comparable<ApplicationServerDefinition>, Serializable {

	private static Logger logger = LoggerFactory.getLogger(ApplicationServerDefinition.class);

	private String serverId;
	
	private long lastNotification;  // Timestamp-Value in Millisekunden
	
	private boolean completeUserSessionSetRetrieved = false;

	public ApplicationServerDefinition(String serverId){
		super();
		this.serverId = serverId;
		lastNotification = System.currentTimeMillis();
		logger.debug("@Konstruktor ApplicationServerDefinition wird neu erzeugt. ApplicationServerDefinition:{}", this);
	}
	/**
	 * @return
	 */
	public boolean isCompleteUserSessionSetRetrieved() {
		logger.debug("ApplicationServerDefinition {}, isCompleteUserSessionSetRetrieved {} abgefragt.", this,
				completeUserSessionSetRetrieved);
		return completeUserSessionSetRetrieved;
	}

	/**
	 * @return
	 */
	public long getLastNotification() {
		return lastNotification;
	}

	/**
	 * @param b
	 */
	public void setCompleteUserSessionSetRetrieved(boolean b) {
		logger.debug("ApplicationServerDefinition mit ID {}, wird mit setCompleteUserSessionSetRetrieved {} gesetzt.",
				this.getServerId(), b);
		completeUserSessionSetRetrieved = b;
	}

	/**
	 * @param l
	 */
	public void setLastNotification(long l) {
		lastNotification = l;
	}

	public String getServerId(){
		return serverId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return serverId.hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof ApplicationServerDefinition)){
			return false;
		}else{
			return this.serverId.equalsIgnoreCase(((ApplicationServerDefinition)obj).serverId);
		}
	}
	
	@Override
	public int compareTo(ApplicationServerDefinition o) {
		 return StringUtils.compareIgnoreCase(this.getServerId(), o.getServerId());
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ApplicationServerDefinition [serverId=");
		builder.append(serverId);
		builder.append(", lastNotification=");
		builder.append(lastNotification);
		builder.append(", completeUserSessionSetRetrieved=");
		builder.append(completeUserSessionSetRetrieved);
		builder.append(", hashId=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

}
