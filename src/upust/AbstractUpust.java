package upust;

import mechanism.MechanismPosition;

public abstract class AbstractUpust implements Upust{

    MechanismPosition position;
    double height;
    double width;
    double distanceFromTheLakeBottomToTheBottomOfTheUpust;

    AbstractUpust(MechanismPosition position, double height, double width, double distanceFromTheLakeBottomToTheBottomOfTheUpust) {
        this.position = position;
        this.height = height;
        this.width = width;
        this.distanceFromTheLakeBottomToTheBottomOfTheUpust = distanceFromTheLakeBottomToTheBottomOfTheUpust;
    }


    public MechanismPosition getPosition() {
        return position;
    }

    public void setPosition(MechanismPosition position) {
        this.position = position;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDistanceFromTheLakeBottomToTheBottomOfTheUpust() {
        return distanceFromTheLakeBottomToTheBottomOfTheUpust;
    }

    public void setDistanceFromTheLakeBottomToTheBottomOfTheUpust(double distanceFromTheLakeBottomToTheBottomOfTheUpust) {
        this.distanceFromTheLakeBottomToTheBottomOfTheUpust = distanceFromTheLakeBottomToTheBottomOfTheUpust;
    }


    public double calculateOutflow(double waterLevel) {
        double depth = averageDepth(waterLevel);
        return speedOfFlow(depth)*flowArea();
    }

    public abstract double averageDepth(double waterLevel);

    public abstract double flowArea();

    public abstract void setMechanismPositionByFlowValue(double flowToBeSet, double waterLevel);

    public double speedOfFlow(double depth){
        return Math.sqrt(2*depth*10); //gravity acceleration  ~ 10 m/s^2
    }


}
