package Utils;

import org.yaml.snakeyaml.Yaml;
import tama.LevelType;
import upust.AbstractUpust;
import upust.UpustKlapaPionowa;
import upust.UpustZasowaDenna;
import zbiornikWodny.AbstractZbiornik;
import zbiornikWodny.Zalew;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UtilYAML {


    public static List<AbstractUpust> loadUpustKlapaPionowa() throws FileNotFoundException {

        InputStream input = new FileInputStream(new File(
                "src/main/resources/upustKlapaConfig.yaml"));

        Yaml yaml = new Yaml();
        Iterable<Object> data = yaml.loadAll(input);
        assert (data instanceof UpustKlapaPionowa);
        List<AbstractUpust> upustyKlapy = new ArrayList<>();
        for (Object o : data) {
            upustyKlapy.add((UpustKlapaPionowa) o);
        }

        return upustyKlapy;

    }

    public static List<AbstractUpust> loadUpustZasowaDenna() throws FileNotFoundException {

        InputStream input = new FileInputStream(new File(
                "src/main/resources/upustZasowaConfig.yaml"));

        Yaml yaml = new Yaml();
        Iterable<Object> data = yaml.loadAll(input);
        assert (data instanceof UpustZasowaDenna);
        List<AbstractUpust> upustyZasowa = new ArrayList<>();
        for (Object o : data) {
            upustyZasowa.add((UpustZasowaDenna) o);
        }
        return  upustyZasowa;

    }



    public static Map<LevelType, Double> loadMapaPoziomow() throws FileNotFoundException {

        InputStream input = new FileInputStream(new File(
                "src/main/resources/damLevelsConfig.yaml"));

        Yaml yaml = new Yaml();
        return (Map<LevelType, Double>) yaml.load(input);

    }

    public static AbstractZbiornik loadZalew() throws FileNotFoundException {

        Yaml yaml = new Yaml();

        InputStream input = new FileInputStream(new File(
                "src/main/resources/zalewConfig.yaml"));

        return  (Zalew) yaml.load(input);
    }


    public static int loadCalculationNumber() throws FileNotFoundException {

        Yaml yaml = new Yaml();

        InputStream input = new FileInputStream(new File(
                "src/main/resources/setupConfig.yaml"));

        return  (int) yaml.load(input);
    }

}
