package org.enrycoweiser.showmethedata.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.enrycoweiser.showmethedata.domain.OperatorPick;
import org.enrycoweiser.showmethedata.repository.custom.MyOperatorPickRepository;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class OperatorPickRepositoryImpl implements MyOperatorPickRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<OperatorPick> retrieveByTeamEventDates(String team, String event, String fromDate, String toDate) {
        StringBuilder hql = new StringBuilder();
        hql.append("from OperatorPick op where 1=1 ");
        if(event != null && !event.isEmpty()) {
            hql.append("and op.round.playedMap.match.event.code = :event ");
        }
        if(team != null && !team.isEmpty()) {
            hql.append("and op.team.code = :team ");
        }
        if(fromDate != null && fromDate.length() == 8) {
            hql.append("and op.round.playedMap.match.date >= :fromDate ");
        }
        if(toDate != null && toDate.length() == 8) {
            hql.append("and op.round.playedMap.match.date <= :toDate ");
        }

        /* --- Manage the dates --- */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        /* ------------------------ */

        var query = entityManager.createQuery(hql.toString(), OperatorPick.class);
        if(event != null && !event.isEmpty()) {
            query.setParameter("event", event);
        }
        if(team != null && !team.isEmpty()) {
            query.setParameter("team", team);
        }
        if(fromDate != null && fromDate.length() == 8) {
            query.setParameter("fromDate", fromDate);
        }
        if(toDate != null && toDate.length() == 8) {
            query.setParameter("toDate", toDate);
        }

        return query.getResultList();
    }
}
