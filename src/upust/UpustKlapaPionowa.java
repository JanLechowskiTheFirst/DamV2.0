package upust;

import mechanism.MechanismPosition;

public class UpustKlapaPionowa extends AbstractUpust{

    public UpustKlapaPionowa(MechanismPosition position, double height, double width, double distanceFromTheLakeBottomToTheBottomOfTheUpust){
        super(position, height, width, distanceFromTheLakeBottomToTheBottomOfTheUpust);
    }

    public double averageDepth(double waterLevel) {
        return Math.max(0, waterLevel - distanceFromTheLakeBottomToTheBottomOfTheUpust + ((height + height*position.getPositioninPrecentage())/2));
    }

    public double flowArea() {
        return (height - height *position.getPositioninPrecentage())*width;
    }
}

