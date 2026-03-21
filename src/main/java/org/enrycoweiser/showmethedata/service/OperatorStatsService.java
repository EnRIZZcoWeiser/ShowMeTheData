package org.enrycoweiser.showmethedata.service;

import org.enrycoweiser.showmethedata.domain.Operator;
import org.enrycoweiser.showmethedata.domain.OperatorPick;
import org.enrycoweiser.showmethedata.dto.request.OperatorStatsRequest;
import org.enrycoweiser.showmethedata.dto.response.OperatorStatsResponse;
import org.enrycoweiser.showmethedata.repository.OperatorPickRepository;
import org.enrycoweiser.showmethedata.repository.OperatorRepository;
import org.enrycoweiser.showmethedata.standard.StandardService;
import org.enrycoweiser.showmethedata.utils.ErrorUtil;
import org.enrycoweiser.showmethedata.utils.TransactionUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatorStatsService implements StandardService<OperatorStatsRequest, OperatorStatsResponse> {

    private final OperatorRepository operatorRepository;
    private final OperatorPickRepository operatorPickRepository;

    public OperatorStatsService(OperatorRepository operatorRepository,
                                OperatorPickRepository operatorPickRepository) {
        this.operatorRepository = operatorRepository;
        this.operatorPickRepository = operatorPickRepository;
    }

    @Override
    public OperatorStatsResponse getAPI(OperatorStatsRequest request) {
        OperatorStatsResponse response;

        try {
            response = new OperatorStatsResponse();

            List<Operator> operator = operatorRepository.retrieveAll();
            List<OperatorPick> operatorPicks = operatorPickRepository.retrieveByTeamEventDates(request.getTeam(), request.getEvent(), request.getFromDate(), request.getToDate());

            return response;
        } catch (Exception e) {
            TransactionUtil.rollback();

            response = new OperatorStatsResponse();
            response.createErrorResponse(ErrorUtil.API_001_MSG, ErrorUtil.API_001);
            return response;
        }
    }
}
