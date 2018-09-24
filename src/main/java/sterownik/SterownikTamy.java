package sterownik;

public interface SterownikTamy {

    /**
     * Function controls the upust setting of entire dam
     *
     * @param waterLevel current water level of the lake
     */
    void control(double waterLevel);

}
