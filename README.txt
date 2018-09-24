Project role is to simulate dam. Whole thing is written in Java 10 with dependency on SnakeYaml,
YAML parser used in project to parse YAML config files.

Project has modules:
    Mechanism - new type implemented for the need of the limited scope double value representing the moving of the mechanism.
    It is representing the position in percentage of the operational distance.
    Sterownik - package is steering the locking mechanisms of the dam
    Tama - dam package, represents dam and it's most important role is to calculate total outflow, aggregating outflows pipes outflow rate
    Upust - outflow mechanism, main role is to calculate individual outflow mechanism outflow
    Utils - package with class made of static methods used for YAML loading and parsing
    ZbiornikWodny - zbiornik aggregates all objects, provides water level calculations based on the total flow ration (inflow - outflow)
