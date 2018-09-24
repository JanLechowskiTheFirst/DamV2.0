package sterownik;

import mechanism.MechanismPosition;
import tama.LevelType;
import upust.AbstractUpust;
import upust.UpustKlapaPionowa;
import upust.UpustZasowaDenna;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractSterownikTamy implements SterownikTamy {

    List<AbstractUpust> upustList;
    Map<LevelType, Double> damRelatedWaterLevels;
    double lastMeasuredWaterLevel;

    public AbstractSterownikTamy(List<AbstractUpust> upustList, Map<LevelType, Double> damRelatedWaterLevels){
        this.upustList=upustList;
        this.damRelatedWaterLevels=damRelatedWaterLevels;
    }

    public void control(double waterLevel) {
        List<AbstractUpust> upustyZasowy = upustList.stream().filter(u -> u instanceof UpustZasowaDenna).collect(Collectors.toList());
        List<AbstractUpust> upustyKlapy = upustList.stream().filter(u -> u instanceof UpustKlapaPionowa).collect(Collectors.toList());
        double waterLevelChangeFromLastMeasurement = waterLevel - lastMeasuredWaterLevel;

        if(waterLevel <= damRelatedWaterLevels.get(LevelType.DEFAULT)){
            upustyKlapy.stream().forEach(u -> u.setPosition(new MechanismPosition(100)));
            upustyZasowy.stream().forEach(u -> u.setMechanismPositionByFlowValue(5, waterLevel)); //minimum flow to sustain the life below dam is 9.5 m3/s
        }
        else if(waterLevel > damRelatedWaterLevels.get(LevelType.DEFAULT) && waterLevel <= damRelatedWaterLevels.get(LevelType.HAZARDOUS )){
            upustyKlapy.stream().forEach(u -> u.setPosition(new MechanismPosition(100)));
            upustyZasowy.stream().forEach(u -> u.setPosition(new MechanismPosition(0)));
        }
        else if(waterLevel > damRelatedWaterLevels.get(LevelType.HAZARDOUS) && waterLevel <= damRelatedWaterLevels.get(LevelType.DESTRUCTIVE ) && waterLevelChangeFromLastMeasurement < 0) {
            upustyKlapy.stream().forEach(u -> u.setPosition(new MechanismPosition(20)));
            upustyZasowy.stream().forEach(u -> u.setPosition(new MechanismPosition(0)));
        }
        else if(waterLevel > damRelatedWaterLevels.get(LevelType.HAZARDOUS) && waterLevel <= damRelatedWaterLevels.get(LevelType.DESTRUCTIVE ) && waterLevelChangeFromLastMeasurement > 0){
        upustyKlapy.stream().forEach(u -> u.setPosition(new MechanismPosition(0)));
        upustyZasowy.stream().forEach(u -> u.setPosition(new MechanismPosition(0)));
        }

        lastMeasuredWaterLevel=waterLevel;
    }
}
