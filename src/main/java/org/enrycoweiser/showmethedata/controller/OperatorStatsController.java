package org.enrycoweiser.showmethedata.controller;

import org.enrycoweiser.showmethedata.dto.request.OperatorStatsRequest;
import org.enrycoweiser.showmethedata.dto.response.OperatorStatsResponse;
import org.enrycoweiser.showmethedata.service.OperatorStatsService;
import org.enrycoweiser.showmethedata.standard.StandardController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/operator_stats")
public class OperatorStatsController implements StandardController<OperatorStatsRequest, OperatorStatsResponse> {

    private final OperatorStatsService service;

    public OperatorStatsController(OperatorStatsService service) {
        this.service = service;
    }

    @Override
    public OperatorStatsResponse getAPI(OperatorStatsRequest request) {
        return service.getAPI(request);
    }
}
