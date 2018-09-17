package zbiornikWodny;

public interface Zbiornik {

    /**
     * @return volume of the reservoir
     * */

    double calculateVolume();

    /**
     * Function calculates new water level based on current flow ratio.
     * Flow ratio is a sum of inflow and outflow to the reservoir.
     *
     *
     * @return water level, the distance from bottom to water surface.
     */
    double calculateNewWaterLevel(double flowRatio);

}
