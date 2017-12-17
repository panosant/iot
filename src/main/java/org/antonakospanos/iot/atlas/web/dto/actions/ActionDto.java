package org.antonakospanos.iot.atlas.web.dto.actions;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.antonakospanos.iot.atlas.dao.model.Action;
import org.antonakospanos.iot.atlas.web.dto.Dto;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * ActionDto
 */
@JsonPropertyOrder({"date", "recurring", "device", "conditions"})
public class ActionDto implements Dto<Action> {

	@NotNull
	private ZonedDateTime date;

	private RecurringActionDto recurring;

	@NotNull
	private DeviceActionDto device;

	private List<ConditionDto> conditions;

	public ZonedDateTime getDate() {
		return date;
	}

	public void setDate(ZonedDateTime date) {
		this.date = date;
	}

	public RecurringActionDto getRecurring() {
		return recurring;
	}

	public void setRecurring(RecurringActionDto recurring) {
		this.recurring = recurring;
	}

	public DeviceActionDto getDevice() {
		return device;
	}

	public void setDevice(DeviceActionDto device) {
		this.device = device;
	}

	public List<ConditionDto> getConditions() {
		return conditions;
	}

	public void setConditions(List<ConditionDto> conditions) {
		this.conditions = conditions;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ActionDto)) return false;

		ActionDto actionDto = (ActionDto) o;

		if (!date.equals(actionDto.date)) return false;
		if (recurring != null ? !recurring.equals(actionDto.recurring) : actionDto.recurring != null) return false;
		if (!device.equals(actionDto.device)) return false;
		return conditions != null ? conditions.equals(actionDto.conditions) : actionDto.conditions == null;
	}

	@Override
	public int hashCode() {
		int result = date.hashCode();
		result = 31 * result + (recurring != null ? recurring.hashCode() : 0);
		result = 31 * result + device.hashCode();
		result = 31 * result + (conditions != null ? conditions.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	@Override
	public ActionDto fromEntity(Action entity) {
		return null;
	}

	@Override
	public Action toEntity() {
		return null;
	}

	@Override
	public Action toEntity(Action entity) {
		return null;
	}
}
