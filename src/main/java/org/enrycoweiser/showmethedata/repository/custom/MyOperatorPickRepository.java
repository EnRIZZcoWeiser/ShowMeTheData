package org.enrycoweiser.showmethedata.repository.custom;

import org.enrycoweiser.showmethedata.domain.OperatorPick;

import java.util.List;

public interface MyOperatorPickRepository {
    public abstract List<OperatorPick> retrieveByTeamEventDates(String team, String event, String fromDate, String toDate);
}
