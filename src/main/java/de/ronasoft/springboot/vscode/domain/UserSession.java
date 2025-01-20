package de.ronasoft.springboot.vscode.domain;


import de.lvm.nachrichtendienst.NachrichtendienstKonstanten;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

/**
 * Repräsentiert eine UserSession mit Session-Id, User-Id, Client-IP-Adresse
 * und der ID des ApplicationServers. Eine solche Session ist eindeutig
 * identifiziert durch die SessionId.
 * 
 * Das Objekt wird als XML-Stream uebertragen. Dazu wird JAXB benutzt.
 * 
 * TTL = 86400
 * 86400 Sekunden = 1 Tag
 * 
 * @author m500194
 */
@XmlRootElement(name = "usersession")
public class UserSession implements Comparable<UserSession>, Serializable {
	
	static Logger logger = LoggerFactory.getLogger(UserSession.class);

	/** die User-Id zu dieser Session. */
	@Indexed
	private String userId;
	/** die SessionId dieser UserSession */
	@Id
	private String sessionId;
	/** Die IP-Adresse des Clients im Format xxx.xxx.xxx.xxx */
	private String clientIP;
	/** die Id des Applicationservers */
	@Indexed
	private String applicationServerId;
	
	@Indexed
	/** Dieser Flag besagt, dass die UserSessionüber abgelaufene Nachrichten informiert wird, oder nicht.  **/
	private boolean notifiedForExpiredMessages = false;

	public UserSession(){
	}
	
	public UserSession(String sessionId, String userId, String clientIp, String applServerId){
		super();
		if (userId != null) {
			// Hier wird die UserId in Großbuchstaben umgewandelt
			// Grund ist: wenn alle Benutzer vom LAS-Server übermittelt werden,
			// wird die BenutzerId 'klein' übertragen
			this.userId = userId.toUpperCase();
		} else {
			this.userId = NachrichtendienstKonstanten.UNKNOWN_USERID;
		}
		this.sessionId = sessionId;
		
		this.clientIP = clientIp;
		
		this.applicationServerId = applServerId;		 
	}
	
	
	
	/**
	 * @return
	 */
	public String getApplicationServerId() {
		return applicationServerId;
	}

	/**
	 * @return
	 */
	public String getClientIP() {
		return clientIP;
	}

	/**
	 * @return
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param l
	 */
	public void setApplicationServerId(String l) {
		applicationServerId = l;
	}

	/**
	 * @param string
	 */
	public void setClientIP(String string) {
		clientIP = string;
	}

	/**
	 * @param string
	 */
	public void setSessionId(String string) {
		sessionId = string;
	}

	/**
	 * @param string
	 */
	public void setUserId(String string) {
		userId = string;
	}

	public boolean isNotifiedForExpiredMessages() {
		return notifiedForExpiredMessages;
	}

	public void setNotifiedForExpiredMessages(boolean notifiedForExpiredMessages) {
		this.notifiedForExpiredMessages = notifiedForExpiredMessages;
		logger.trace("notifiedForExpiredMessages wurde geändert:{}", this);
	}

	@Override
	public int compareTo(UserSession o) {
		return this.getUserId().compareToIgnoreCase(o.getUserId());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applicationServerId == null) ? 0 : applicationServerId.hashCode());
		result = prime * result + ((clientIP == null) ? 0 : clientIP.hashCode());
		result = prime * result + (notifiedForExpiredMessages ? 1231 : 1237);
		result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserSession other = (UserSession) obj;
		if (applicationServerId == null) {
			if (other.applicationServerId != null)
				return false;
		} else if (!applicationServerId.equals(other.applicationServerId))
			return false;
		if (clientIP == null) {
			if (other.clientIP != null)
				return false;
		} else if (!clientIP.equals(other.clientIP))
			return false;
		if (notifiedForExpiredMessages != other.notifiedForExpiredMessages)
			return false;
		if (sessionId == null) {
			if (other.sessionId != null)
				return false;
		} else if (!sessionId.equals(other.sessionId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserSession [userId=");
		builder.append(userId);
		builder.append(", sessionId=");
		builder.append(sessionId);
		builder.append(", clientIP=");
		builder.append(clientIP);
		builder.append(", applicationServerId=");
		builder.append(applicationServerId);
		builder.append(", notifiedForExpiredMessages=");
		builder.append(notifiedForExpiredMessages);
		builder.append("]");
		return builder.toString();
	}

}
