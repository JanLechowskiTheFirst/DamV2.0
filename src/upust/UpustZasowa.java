package upust;

import mechanism.MechanismPosition;

public class UpustZasowa extends AbstractUpust{

    public UpustZasowa(MechanismPosition position, double height, double width, double distanceFromTheLakeBottomToTheBottomOfTheUpust){
        super(position, height, width, distanceFromTheLakeBottomToTheBottomOfTheUpust);
    }

    public double averageDepth(double waterLevel) {
        return Math.max(0, waterLevel - distanceFromTheLakeBottomToTheBottomOfTheUpust + (height/2));
    }

    public double flowArea() {
        return (width - width*(position.getPositioninPrecentage()/100))* height;
    }

    public void setMechanismPositionByFlowValue(double flowToBeSet, double waterLevel){
        double positionToSet = (-flowToBeSet/speedOfFlow(this.averageDepth(waterLevel)))*(1/height)+width;
        position = new MechanismPosition(positionToSet);
    }
}
