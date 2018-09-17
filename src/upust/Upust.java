package upust;


@FunctionalInterface
public interface Upust {

    /**
     * Function calculated the outflow rate in m3/s of the upust.
     *
     *
     * @param waterLevel distance from the bottom of the reservoir to the the surface of water
     * @return outflow in m3/s
     */

    double calculateOutflow(double waterLevel);

}
