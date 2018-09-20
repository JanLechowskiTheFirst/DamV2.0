package tama;

import sterownik.AbstractSterownikTamy;
import upust.AbstractUpust;

import java.util.List;
import java.util.Map;

public abstract class AbstractTama implements Zapora {

    List<AbstractUpust> upustList;
    AbstractSterownikTamy sterownik;
    Map<LevelType, Double> damRelatedWaterLevels;


    public AbstractTama(List<AbstractUpust> upustList, AbstractSterownikTamy sterownik, Map<LevelType, Double> damRelatedWaterLevels) {
        this.upustList = upustList;
        this.sterownik = sterownik;
        this.damRelatedWaterLevels=damRelatedWaterLevels;
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
