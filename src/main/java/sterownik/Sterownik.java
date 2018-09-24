package sterownik;

import tama.LevelType;
import upust.AbstractUpust;
import java.util.List;
import java.util.Map;

public class Sterownik extends AbstractSterownikTamy{

    public Sterownik(List<AbstractUpust> upustList, Map<LevelType, Double> damRelatedLevels){
        super(upustList, damRelatedLevels);
    }


}
