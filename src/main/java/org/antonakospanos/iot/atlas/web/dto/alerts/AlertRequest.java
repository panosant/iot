package org.antonakospanos.iot.atlas.web.dto.alerts;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AlertRequest {

	@JsonProperty("timestamp")
	private String timestamp = null;

	@JsonProperty("username")
	private String username = null;

	@JsonProperty("alert")
	private AlertDto alert = null;

	public AlertRequest() {
	}

	public AlertRequest(String timestamp, String username, AlertDto alert) {
		this.timestamp = timestamp;
		this.username = username;
		this.alert = alert;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public AlertDto getAlert() {
		return alert;
	}

	public void setAlert(AlertDto alert) {
		this.alert = alert;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AlertRequest)) return false;

		AlertRequest that = (AlertRequest) o;

		if (!timestamp.equals(that.timestamp)) return false;
		if (!username.equals(that.username)) return false;
		return alert.equals(that.alert);
	}

	@Override
	public int hashCode() {
		int result = timestamp.hashCode();
		result = 31 * result + username.hashCode();
		result = 31 * result + alert.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}