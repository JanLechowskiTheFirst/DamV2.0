package zbiornikWodny;

public abstract class AbstractZbiornik implements Zbiornik {

    double approximatedCurveOfTank;
    double length;
    double waterLevel;
    int timeBase; //timeBase -> timebase x realTime, timebase = 10 -> time=timex10

    AbstractZbiornik(){

    }

    AbstractZbiornik(double approximatedCurveOfTank, double length, double waterLevel, int timeBase) {
        this.approximatedCurveOfTank = approximatedCurveOfTank;
        this.length = length;
        this.waterLevel = waterLevel;
        this.timeBase=timeBase;
    }

    public double getApproximatedCurveOfTank() {
        return approximatedCurveOfTank;
    }

    public void setApproximatedCurveOfTank(double approximatedCurveOfTank) {
        this.approximatedCurveOfTank = approximatedCurveOfTank;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(double waterLevel) {
        this.waterLevel = waterLevel;
    }

    public double calculateVolume() {
        return Math.pow(waterLevel, 2)*length/approximatedCurveOfTank;
    }

    public abstract double calculateFlowRatio();


}
