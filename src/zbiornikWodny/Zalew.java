package zbiornikWodny;

import tama.AbstractTama;

public class Zalew extends AbstractZbiornik {

    double inflow;
    AbstractTama tama;

    public Zalew(double approximatedCurveOfTank, double length, double initialWaterLevel) {
        super(approximatedCurveOfTank, length, initialWaterLevel);
    }

    public double getInflow() {
        return inflow;
    }

    public void setInflow(double inflow) {
        this.inflow = inflow;
    }

    //must be calculated every second
    public double calculateNewWaterLevel(double flowRatio) {
        double currentVolume = calculateVolume();
        double newVolume = currentVolume+flowRatio;
        return Math.sqrt(newVolume*approximatedCurveOfTank/length);
    }


    double calculateFlowRatio(double outflow){
        return inflow-outflow;
    }
}
