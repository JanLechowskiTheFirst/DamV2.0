import mechanism.MechanismPosition;
import sterownik.AbstractSterownikTamy;
import sterownik.Sterownik;
import tama.AbstractTama;
import tama.LevelType;
import tama.Tama;
import upust.AbstractUpust;
import upust.UpustKlapaPionowa;
import upust.UpustZasowa;
import zbiornikWodny.AbstractZbiornik;
import zbiornikWodny.Zalew;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Simulation {

    public static void main(String args[]){

        List<AbstractUpust> upusty = new ArrayList<>();
        upusty.add(new UpustZasowa(new MechanismPosition(100), 2, 1, 0));
        upusty.add(new UpustZasowa(new MechanismPosition(100), 2, 1, 0));
        upusty.add(new UpustKlapaPionowa(new MechanismPosition(100), 2, 1, 8));
        upusty.add(new UpustKlapaPionowa(new MechanismPosition(100), 2, 1, 8));

        Map<LevelType, Double> mapaPoziomow = new HashMap<>();
        mapaPoziomow.put(LevelType.DEFAULT, 10.0);
        mapaPoziomow.put(LevelType.DESTRUCTIVE, 20.0);
        mapaPoziomow.put(LevelType.HAZARDOUS, 30.0);


        AbstractSterownikTamy sterownik = new Sterownik(upusty, mapaPoziomow);
        AbstractTama tama = new Tama(upusty, sterownik, mapaPoziomow);

        AbstractZbiornik zbiornik = new Zalew(0.2, 30,10, tama, 200);

        int i =0;
        System.out.println("START!");
        while(i<300) {
            zbiornik.setWaterLevel(zbiornik.calculateNewWaterLevel(zbiornik.calculateFlowRatio()));
            ((Zalew) zbiornik).getTama().getSterownik().control(zbiornik.getWaterLevel());
            i++;
            System.out.println("Poziom wody " + zbiornik.getWaterLevel());
            System.out.println("Upust 1 " + ((Zalew) zbiornik).getTama().getUpustList().get(0).getPosition().getPositioninPrecentage());
            System.out.println("Upust 2 " + ((Zalew) zbiornik).getTama().getUpustList().get(1).getPosition().getPositioninPrecentage());
            System.out.println("Upust 3 " + ((Zalew) zbiornik).getTama().getUpustList().get(2).getPosition().getPositioninPrecentage());
            System.out.println("Upust 4 " + ((Zalew) zbiornik).getTama().getUpustList().get(3).getPosition().getPositioninPrecentage());
            System.out.println("Tama totalFlow " + ((Zalew) zbiornik).getTama().calculateTotalOutFlow(zbiornik.getWaterLevel()));
            System.out.println("Doplyw wody " + ((Zalew) zbiornik).getInflow());
        }

    }
}
