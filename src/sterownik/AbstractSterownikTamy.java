package sterownik;

import mechanism.MechanismPosition;
import tama.LevelType;
import upust.AbstractUpust;
import upust.UpustKlapaPionowa;
import upust.UpustZasowa;

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
        List<AbstractUpust> upustyZasowy = upustList.stream().filter(u -> u instanceof UpustZasowa).collect(Collectors.toList());
        List<AbstractUpust> upustyKlapy = upustList.stream().filter(u -> u instanceof UpustKlapaPionowa).collect(Collectors.toList());
        double waterLevelChangeFromLastMeasurement = waterLevel - lastMeasuredWaterLevel;

        if(waterLevel <= damRelatedWaterLevels.get(LevelType.DEFAULT)){
            upustyKlapy.stream().forEach(u -> u.setPosition(new MechanismPosition(100)));
            upustyZasowy.stream().forEach(u -> u.setMechanismPositionByFlowValue(5, waterLevel));
        }
        else if(waterLevel > damRelatedWaterLevels.get(LevelType.DEFAULT) && waterLevel <= damRelatedWaterLevels.get(LevelType.HAZARDOUS ) && waterLevelChangeFromLastMeasurement>0){
            upustyKlapy.stream().forEach(u -> u.setMechanismPositionByFlowValue(100, waterLevel));
            upustyZasowy.stream().forEach(u -> u.setMechanismPositionByFlowValue(1000, waterLevel));
        }
        else if(waterLevel > damRelatedWaterLevels.get(LevelType.DEFAULT) && waterLevel <= damRelatedWaterLevels.get(LevelType.HAZARDOUS ) && waterLevelChangeFromLastMeasurement<0){
            upustyKlapy.stream().forEach(u -> u.setMechanismPositionByFlowValue(50, waterLevel));
            upustyZasowy.stream().forEach(u -> u.setMechanismPositionByFlowValue(1000, waterLevel));
        }
        else if(waterLevel > damRelatedWaterLevels.get(LevelType.DEFAULT) && waterLevel <= damRelatedWaterLevels.get(LevelType.HAZARDOUS ) && waterLevelChangeFromLastMeasurement<0){
            upustyKlapy.stream().forEach(u -> u.setMechanismPositionByFlowValue(50, waterLevel));
            upustyZasowy.stream().forEach(u -> u.setMechanismPositionByFlowValue(1000, waterLevel));
        }
        else if(waterLevel > damRelatedWaterLevels.get(LevelType.HAZARDOUS) && waterLevel <= damRelatedWaterLevels.get(LevelType.DESTRUCTIVE )){
            upustyKlapy.stream().forEach(u -> u.setMechanismPositionByFlowValue(200, waterLevel));
            upustyZasowy.stream().forEach(u -> u.setMechanismPositionByFlowValue(1000, waterLevel));
        }
        else{
            upustyKlapy.stream().forEach(u -> u.setMechanismPositionByFlowValue(1000, waterLevel));
            upustyZasowy.stream().forEach(u -> u.setMechanismPositionByFlowValue(1000, waterLevel));
        }

            lastMeasuredWaterLevel=waterLevel;
    }
}
