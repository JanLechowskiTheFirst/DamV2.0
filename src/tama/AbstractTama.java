package tama;

import sterownik.AbstractSterownikTamy;
import upust.AbstractUpust;
import java.util.List;
import java.util.Map;

public abstract class AbstractTama implements Zapora {

    List<AbstractUpust> upustList;
    AbstractSterownikTamy sterownik;
    Map<LevelType, Double> damRelatedWaterLevels;
    double heightOfTama;


    public AbstractTama(List<AbstractUpust> upustList, AbstractSterownikTamy sterownik, Map<LevelType, Double> damRelatedWaterLevels, double hightOfTama) {
        this.upustList = upustList;
        this.sterownik = sterownik;
        this.damRelatedWaterLevels=damRelatedWaterLevels;
        this.heightOfTama =hightOfTama;
    }

    public double getHeightOfTama() {
        return heightOfTama;
    }

    public void setHeightOfTama(double heightOfTama) {
        this.heightOfTama = heightOfTama;
    }

    public List<AbstractUpust> getUpustList() {
        return upustList;
    }

    public void setUpustList(List<AbstractUpust> upustList) {
        this.upustList = upustList;
    }

    public AbstractSterownikTamy getSterownik() {
        return sterownik;
    }

    public void setSterownik(AbstractSterownikTamy sterownik) {
        this.sterownik = sterownik;
    }

    public Map<LevelType, Double> getDamRelatedWaterLevels() {
        return damRelatedWaterLevels;
    }

    public void setDamRelatedWaterLevels(Map<LevelType, Double> damRelatedWaterLevels) {
        this.damRelatedWaterLevels = damRelatedWaterLevels;
    }

    public double calculateTotalOutFlow(double waterLevel){
        return upustList.stream().mapToDouble(u -> u.calculateOutflow(waterLevel)).sum();
    }



}
