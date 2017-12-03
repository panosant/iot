package org.antonakospanos.iot.atlas.service;

import org.antonakospanos.iot.atlas.dao.model.Action;
import org.antonakospanos.iot.atlas.dao.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActionService {

	@Autowired
	ActionRepository actionRepository;

	public void rescheduleActions(List<Action> actions) {

		for (Iterator<Action> iterator = actions.iterator(); iterator.hasNext(); ) {
			Action action = iterator.next();

			if (action.getPeriodOfMinutes() != null) {
				// Schedule the next action
				action.setNextExecution(action.getNextExecution().plusMinutes(action.getPeriodOfMinutes()));
			} else {
				// Remove the action from the iterator and the list
				iterator.remove();
			}
		}
		actionRepository.saveAll(actions);
	}

	public List<Action> findPlannedActions(Long moduleId) {
		List<Action> actions = actionRepository.findByModuleId(moduleId);

		return actions.stream()
				.filter(a -> a.getNextExecution().isBefore(ZonedDateTime.now()))
				.collect(Collectors.toList());
	}
}