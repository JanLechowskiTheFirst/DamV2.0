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

    double lastMeasuredWaterLevel;




    public void control(List<AbstractUpust> upustList, Map<LevelType, Double> damRelatedWaterLevels, double waterLevel, double totalFlow) {
        List<AbstractUpust> upustyZasowy = upustList.stream().filter(u -> u instanceof UpustZasowa).collect(Collectors.toList());
        List<AbstractUpust> upustyKlapy = upustList.stream().filter(u -> u instanceof UpustKlapaPionowa).collect(Collectors.toList());

        double totalOutFlow = abstractTama.calculateTotalOutFlow(waterLevel);

        double waterLevelChangeFromLastMeasurement = waterLevel - lastMeasuredWaterLevel;


        if(waterLevel <= abstractTama.getDamRelatedWaterLevels().get(LevelType.DEFAULT)){
            upustyKlapy.stream().forEach(u -> u.setPosition(new MechanismPosition(100)));
            upustyZasowy.
        }




        lastMeasuredWaterLevel=waterLevel;
    }
}
