package org.enrycoweiser.showmethedata.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.enrycoweiser.showmethedata.standard.StandardResponse;

import java.util.List;

@Getter
@Setter
public class OperatorStatsResponse extends StandardResponse {
    private List<OperatorStatsTile> attackTiles;
    private List<OperatorStatsTile> defenceTiles;
}
