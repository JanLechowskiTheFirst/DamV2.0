import mechanism.MechanismPosition;
import sterownik.AbstractSterownikTamy;
import sterownik.Sterownik;
import tama.AbstractTama;
import tama.LevelType;
import tama.Tama;
import upust.AbstractUpust;
import upust.UpustKlapaPionowa;
import upust.UpustZasowaDenna;
import zbiornikWodny.AbstractZbiornik;
import zbiornikWodny.Zalew;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Simulation {

    public static void main(String args[]){

        List<AbstractUpust> upusty = new ArrayList<>();
        upusty.add(new UpustZasowaDenna(new MechanismPosition(100), 1.5, 1.8, 0));
        upusty.add(new UpustZasowaDenna(new MechanismPosition(100), 1.5, 1.8, 0));
        upusty.add(new UpustKlapaPionowa(new MechanismPosition(100), 2.6, 11.2, 27.4));
        upusty.add(new UpustKlapaPionowa(new MechanismPosition(100), 2.6, 11.2, 27.4));

        Map<LevelType, Double> mapaPoziomow = new HashMap<>();
        mapaPoziomow.put(LevelType.DEFAULT, 10.0);
        mapaPoziomow.put(LevelType.DESTRUCTIVE, 30.0);
        mapaPoziomow.put(LevelType.HAZARDOUS, 27.4);


        AbstractSterownikTamy sterownik = new Sterownik(upusty, mapaPoziomow);
        AbstractTama tama = new Tama(upusty, sterownik, mapaPoziomow, 30);

        AbstractZbiornik zbiornik = new Zalew(0.2, 100,10, tama, 500, 1);

        int i =0;
        System.out.println("START!");
        while(i<1600) {

            zbiornik.setWaterLevel(zbiornik.calculateNewWaterLevel(zbiornik.calculateFlowRatio()));
            ((Zalew) zbiornik).getTama().getSterownik().control(zbiornik.getWaterLevel());

            System.out.println(i);
            System.out.println("Poziom wody " + zbiornik.getWaterLevel());
            System.out.println("Upust 1 " + ((Zalew) zbiornik).getTama().getUpustList().get(0).getPosition().getPositionInPercentage());
            System.out.println("Upust 2 " + ((Zalew) zbiornik).getTama().getUpustList().get(1).getPosition().getPositionInPercentage());
            System.out.println("Upust 3 " + ((Zalew) zbiornik).getTama().getUpustList().get(2).getPosition().getPositionInPercentage());
            System.out.println("Upust 4 " + ((Zalew) zbiornik).getTama().getUpustList().get(3).getPosition().getPositionInPercentage());
            System.out.println("INFLOW " + ((Zalew) zbiornik).getInflow());
            System.out.println("OUTFLOW " + ((Zalew) zbiornik).getTama().calculateTotalOutFlow(zbiornik.getWaterLevel()));

            i++;

        }

    }
}
