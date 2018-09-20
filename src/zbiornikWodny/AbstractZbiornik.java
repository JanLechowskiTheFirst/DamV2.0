package zbiornikWodny;

public abstract class AbstractZbiornik implements Zbiornik {

    double approximatedCurveOfTank;
    double length;
    double waterLevel;

    AbstractZbiornik(double approximatedCurveOfTank, double length, double waterLevel) {
        this.approximatedCurveOfTank = approximatedCurveOfTank;
        this.length = length;
        this.waterLevel = waterLevel;
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
