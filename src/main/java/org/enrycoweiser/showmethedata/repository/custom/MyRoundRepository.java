package org.enrycoweiser.showmethedata.repository.custom;

import org.enrycoweiser.showmethedata.domain.Round;
import java.util.List;

public interface MyRoundRepository {
    public abstract List<Round> retrieveByTeamEventDates(String team, String event, String fromDate, String toDate);
}
