package org.enrycoweiser.showmethedata.service;

import org.enrycoweiser.showmethedata.domain.Round;
import org.enrycoweiser.showmethedata.dto.request.OperatorStatsRequest;
import org.enrycoweiser.showmethedata.dto.response.OperatorStatsResponse;
import org.enrycoweiser.showmethedata.dto.response.OperatorStatsTile;
import org.enrycoweiser.showmethedata.repository.QueryDtoRepository;
import org.enrycoweiser.showmethedata.repository.RoundRepository;
import org.enrycoweiser.showmethedata.standard.StandardService;
import org.enrycoweiser.showmethedata.statics.OperatorStatsStatic;
import org.enrycoweiser.showmethedata.utils.ErrorUtil;
import org.enrycoweiser.showmethedata.utils.GeneralUtil;
import org.enrycoweiser.showmethedata.utils.TransactionUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OperatorStatsService implements StandardService<OperatorStatsRequest, OperatorStatsResponse> {

    private final QueryDtoRepository queryDtoRepository;
    private final RoundRepository roundRepository;

    public OperatorStatsService(QueryDtoRepository queryDtoRepository,
                                RoundRepository roundRepository) {
        this.queryDtoRepository = queryDtoRepository;
        this.roundRepository = roundRepository;
    }

    @Override
    public OperatorStatsResponse getAPI(OperatorStatsRequest request) {
        OperatorStatsResponse response;

        try {
            response = new OperatorStatsResponse();

            String team = request.getTeam();
            String event = request.getEvent();
            String fromDate = request.getFromDate();
            String toDate = request.getToDate();

            List<Round> rounds = roundRepository.retrieveByTeamEventDates(team, event, fromDate, toDate);
            List<OperatorStatsTile> tiles = queryDtoRepository.getOperatorStatsTile(team, event, fromDate, toDate);

            OperatorStatsStatic.completeTiles(rounds, tiles, team);

            List<OperatorStatsTile> attack = new ArrayList<>();
            List<OperatorStatsTile> defence = new ArrayList<>();

            for (OperatorStatsTile tile : tiles) {
                if(tile.getRole().equals(GeneralUtil.ROLE_ATK)) {
                    attack.add(tile);
                } else {
                    defence.add(tile);
                }
            }

            response.setAttackTiles(attack);
            response.setDefenceTiles(defence);
            return response;

        } catch (Exception e) {
            TransactionUtil.rollback();

            response = new OperatorStatsResponse();
            response.createErrorResponse(ErrorUtil.API_001_MSG, ErrorUtil.API_001);
            return response;
        }
    }
}
