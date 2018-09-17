package mechanism;

public class MechanismPosition {

    double positionInPercentage;

    public MechanismPosition(double positionInPrecentage) {
        calculatePositionPercentage(positionInPrecentage);
    }

    public void calculatePositionPercentage(double positionInPrecentage){
        if(positionInPrecentage>=0 && positionInPrecentage<=100){
            this.positionInPercentage =positionInPrecentage;
        }
        else if(positionInPrecentage<0){
            this.positionInPercentage = 0;
        }
        else if(positionInPrecentage > 100){
            this.positionInPercentage =100;
        }
    }

    public void setPositioninPrecentage(double positionInPrecentage) {
        calculatePositionPercentage(positionInPrecentage);
    }

    public double getPositioninPrecentage() {
        return positionInPercentage /100;
    }
}

