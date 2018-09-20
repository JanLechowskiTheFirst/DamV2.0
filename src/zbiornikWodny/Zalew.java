package zbiornikWodny;

import tama.AbstractTama;

public class Zalew extends AbstractZbiornik {

    private double inflow;
    private AbstractTama tama;
    private long lastTime;

    public Zalew(double approximatedCurveOfTank, double length, double initialWaterLevel, AbstractTama tama, double inflow, int timeBase) {
        super(approximatedCurveOfTank, length, initialWaterLevel, timeBase);
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

    public double calculateNewWaterLevel(double flowRatio) {
        double currentVolume = calculateVolume();
        double newVolume = currentVolume+flowRatio;
        return Math.min(tama.getHeightOfTama() , Math.sqrt(newVolume*approximatedCurveOfTank/length));
    }


    public double calculateFlowRatio(){
        long time = System.nanoTime();
        if(lastTime == 0) {
            lastTime = time;
            return 0;
        }
        double executionTime = time - lastTime;
        lastTime = time;
        double outflow = tama.calculateTotalOutFlow(waterLevel);
        return timeBase*((inflow/executionTime)-outflow);
    }
}
