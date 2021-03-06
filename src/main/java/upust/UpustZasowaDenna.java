package upust;

import mechanism.MechanismPosition;

/**
 * UpustZasowaDenna should be placed on the very bottom of the dam
 */

public class UpustZasowaDenna extends AbstractUpust{

    public UpustZasowaDenna(MechanismPosition position, double height, double width, double distanceFromTheLakeBottomToTheBottomOfTheUpust){
        super(position, height, width, distanceFromTheLakeBottomToTheBottomOfTheUpust);
    }

    public double averageDepth(double waterLevel) {
        return waterLevel > height/2 ? Math.max(0, waterLevel - distanceFromTheLakeBottomToTheBottomOfTheUpust - (height/2)) : waterLevel/2;
    }

    public double flowArea() {
        return (width - width*(position.getPositionInPercentage()/100))* height;
    }

    public void setMechanismPositionByFlowValue(double flowToBeSet, double waterLevel){
        double positionToSet = (-flowToBeSet/speedOfFlow(averageDepth(waterLevel)))*(1/height)+width;
        position = new MechanismPosition(positionToSet);
    }
}
