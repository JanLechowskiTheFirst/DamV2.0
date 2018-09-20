package tama;

import sterownik.AbstractSterownikTamy;
import upust.AbstractUpust;
import java.util.List;
import java.util.Map;

public class Tama extends AbstractTama{

    public Tama(List<AbstractUpust> upustList, AbstractSterownikTamy sterownik, Map<LevelType, Double> damRelatedWaterLevels, double heightOfTama) {
        super(upustList, sterownik, damRelatedWaterLevels, heightOfTama);
    }
}
