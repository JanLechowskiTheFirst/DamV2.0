import Utils.UtilYAML;
import sterownik.AbstractSterownikTamy;
import sterownik.Sterownik;
import tama.AbstractTama;
import tama.LevelType;
import tama.Tama;
import upust.AbstractUpust;
import zbiornikWodny.AbstractZbiornik;
import zbiornikWodny.Zalew;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Simulation {

    public static void main(String args[]){

        Logger logger = Logger.getLogger(Logger.class.getName());
        try {
            FileHandler fileHandler = new FileHandler("app.log", true);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);
        }
        catch (IOException e){

        }


        List<AbstractUpust> upusty = new ArrayList<>();
        Map<LevelType, Double> mapaPoziomow = new HashMap<>();
        AbstractZbiornik zbiornik = new Zalew();
//        int j =0;

        try{
            upusty.addAll(UtilYAML.loadUpustKlapaPionowa());
            upusty.addAll(UtilYAML.loadUpustZasowaDenna());
            mapaPoziomow = UtilYAML.loadMapaPoziomow();
            zbiornik = UtilYAML.loadZalew();
//            j=UtilYAML.loadCalculationNumber();

        }
        catch(FileNotFoundException e){

        }

        AbstractSterownikTamy sterownik = new Sterownik(upusty, mapaPoziomow);
        AbstractTama tama = new Tama(upusty, sterownik, mapaPoziomow,  mapaPoziomow.get(LevelType.DESTRUCTIVE));
        ((Zalew)zbiornik).setTama(tama);


        int i =0;
        logger.info("START!");
        while(i<1500) { //i<j TODO

            zbiornik.setWaterLevel(zbiornik.calculateNewWaterLevel(zbiornik.calculateFlowRatio()));
            ((Zalew) zbiornik).getTama().getSterownik().control(zbiornik.getWaterLevel());

            logger.info(    "nr " + i + " Poziom wody " + zbiornik.getWaterLevel()
                            + " Upust 1 " + ((Zalew) zbiornik).getTama().getUpustList().get(0).getPosition().getPositionInPercentage()
                            + " Upust 2 " + ((Zalew) zbiornik).getTama().getUpustList().get(1).getPosition().getPositionInPercentage()
                            + " Upust 3 " + ((Zalew) zbiornik).getTama().getUpustList().get(2).getPosition().getPositionInPercentage()
                            + " Upust 4 " + ((Zalew) zbiornik).getTama().getUpustList().get(3).getPosition().getPositionInPercentage()
                            + " INFLOW " + ((Zalew) zbiornik).getInflow()
                            + " OUTFLOW " + ((Zalew) zbiornik).getTama().calculateTotalOutFlow(zbiornik.getWaterLevel()));
            i++;
        }

    }
}
