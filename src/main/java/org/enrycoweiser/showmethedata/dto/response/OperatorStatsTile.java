package org.enrycoweiser.showmethedata.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperatorStatsTile {
    private String operator;
    private int round;
    private int pick;
    private double pickPerc;
    private int win;
    private double winPerc;
    private int plant;
    private double plantPerc;
    private int ban;
    private double banPerc;
    private int notAvailable;
    private double realPickPerc;
}
