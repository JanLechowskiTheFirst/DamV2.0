package zbiornikWodny;

import tama.AbstractTama;

public class Zalew extends AbstractZbiornik {

    private double inflow;
    private AbstractTama tama;

    public Zalew(double approximatedCurveOfTank, double length, double initialWaterLevel, AbstractTama tama, double inflow) {
        super(approximatedCurveOfTank, length, initialWaterLevel);
        this.tama=tama;
        this.inflow=inflow;

    }

    public double getInflow() {
        return inflow;
    }

    public void setInflow(double inflow) {
        this.inflow = inflow;
    }

    public AbstractTama getTama() {
        return tama;
    }

    public void setTama(AbstractTama tama) {
        this.tama = tama;
    }

    //must be calculated every second
    public double calculateNewWaterLevel(double flowRatio) {
        double currentVolume = calculateVolume();
        double newVolume = currentVolume+flowRatio;
        return Math.sqrt(newVolume*approximatedCurveOfTank/length);
    }


    public double calculateFlowRatio(){
        double outflow = tama.calculateTotalOutFlow(waterLevel);
        return inflow-outflow;
    }
}
