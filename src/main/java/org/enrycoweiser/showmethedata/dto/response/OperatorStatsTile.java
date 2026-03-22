package org.enrycoweiser.showmethedata.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperatorStatsTile {
    private String operator;
    private String role;
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

    /* CUSTOM METHODS */

    public void addBan() {
        ban++;
    }

    public void addNotAvailable() {
        notAvailable++;
    }

    public double getPickPerc() {
        return getPerc(pick, round);
    }

    public double getWinPerc() {
        return getPerc(win, pick);
    }

    public double getPlantPerc() {
        return getPerc(plant, pick);
    }

    public double getBanPerc() {
        return getPerc(ban, round);
    }

    public double getRealPickPerc() {
        return getPerc(pick, (round - notAvailable - ban));
    }

    public double getPerc(int number1, int number2) {
        if(number2 == 0) {
            return -1;
        }

        return ((double) number1 / (double) number2) * 100.0;
    }
}
