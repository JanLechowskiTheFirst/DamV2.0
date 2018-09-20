package upust;

import mechanism.MechanismPosition;

public class UpustKlapaPionowa extends AbstractUpust{

    public UpustKlapaPionowa(MechanismPosition position, double height, double width, double distanceFromTheLakeBottomToTheBottomOfTheUpust){
        super(position, height, width, distanceFromTheLakeBottomToTheBottomOfTheUpust);
    }

    public double averageDepth(double waterLevel) {
        return Math.max(0, waterLevel - distanceFromTheLakeBottomToTheBottomOfTheUpust - ((height + height*(position.getPositionInPercentage()/100))/2));
    }

    public double flowArea() {
        return (height - height *(position.getPositionInPercentage()/100))*width;
    }

    public void setMechanismPositionByFlowValue(double flowToBeSet, double waterLevel) {
        while(calculateOutflow(waterLevel) >= flowToBeSet+0.25 || calculateOutflow(waterLevel) <= flowToBeSet-0.25 ){
            if(flowToBeSet > calculateOutflow(waterLevel) && position.getPositionInPercentage() > 0)
            setPosition(new MechanismPosition(getPosition().getPositionInPercentage()-1));
            else if(flowToBeSet < calculateOutflow(waterLevel) && position.getPositionInPercentage() < 100){
                    setPosition(new MechanismPosition(getPosition().getPositionInPercentage() + 1));
            }
            else{
                break;
            }
        }
    }
}

