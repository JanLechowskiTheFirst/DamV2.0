package mechanism;

public class MechanismPosition {

    double positionInPercentage;

    public MechanismPosition(double positionInPrecentage) {
        calculatePositionPercentage(positionInPrecentage);
    }

    public void calculatePositionPercentage(double positionInPrecentage){
        if(positionInPrecentage>=0 && positionInPrecentage<=100){
            positionInPercentage =positionInPrecentage;
        }
        else if(positionInPrecentage<0){
            positionInPercentage = 0;
        }
        else if(positionInPrecentage > 100){
            positionInPercentage =100;
        }
    }

    public void setPositioninPrecentage(double positionInPrecentage) {
        calculatePositionPercentage(positionInPrecentage);
    }

    public double getPositioninPrecentage() {
        return positionInPercentage;
    }
}

