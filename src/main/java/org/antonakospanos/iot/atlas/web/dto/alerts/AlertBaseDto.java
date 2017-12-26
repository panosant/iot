package org.antonakospanos.iot.atlas.web.dto.alerts;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.antonakospanos.iot.atlas.web.dto.actions.ConditionDto;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * AlertBaseDto
 */
@JsonPropertyOrder({"condition"})
public class AlertBaseDto {

	private ConditionDto condition;

	public ConditionDto getCondition() {
		return condition;
	}

	public void setCondition(ConditionDto condition) {
		this.condition = condition;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AlertBaseDto)) return false;

		AlertBaseDto that = (AlertBaseDto) o;

		return condition != null ? condition.equals(that.condition) : that.condition == null;
	}

	@Override
	public int hashCode() {
		return condition != null ? condition.hashCode() : 0;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}