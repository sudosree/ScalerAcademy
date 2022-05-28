package designpattern.builderpattern.house;

public class House {
    private final int walls;
    private final int floors;
    private final int doors;
    private final int windows;
    private final int roofs;
    private final boolean swimmingPool;
    private final boolean garage;
    private final boolean garden;
    private final boolean powerBackup;

    public static class Builder {
        // required parameters
        private final int walls;
        private final int floors;
        private final int doors;
        private final int windows;
        private final int roofs;

        // optional parameters
        private boolean swimmingPool = false;
        private boolean garage = false;
        private boolean garden = false;
        private boolean powerBackup = false;

        public Builder(int walls, int floors, int doors, int windows, int roofs) {
            this.walls = walls;
            this.floors = floors;
            this.doors = doors;
            this.windows = windows;
            this.roofs = roofs;
        }

        public Builder swimmingPool(boolean val) {
            this.swimmingPool = val;
            return this;
        }

        public Builder garage(boolean val) {
            this.garage = val;
            return this;
        }

        public Builder garden(boolean val) {
            this.garden = val;
            return this;
        }

        public Builder powerBackup(boolean val) {
            this.powerBackup = val;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }

    private House(Builder builder) {
        this.walls = builder.walls;
        this.floors = builder.floors;
        this.doors = builder.doors;
        this.windows = builder.windows;
        this.roofs = builder.roofs;
        this.swimmingPool = builder.swimmingPool;
        this.garage = builder.garage;
        this.garden = builder.garden;
        this.powerBackup = builder.powerBackup;
    }

    public int getWalls() {
        return walls;
    }

    public int getFloors() {
        return floors;
    }

    public int getDoors() {
        return doors;
    }

    public int getWindows() {
        return windows;
    }

    public int getRoofs() {
        return roofs;
    }

    public boolean isSwimmingPool() {
        return swimmingPool;
    }

    public boolean isGarage() {
        return garage;
    }

    public boolean isGarden() {
        return garden;
    }

    public boolean isPowerBackup() {
        return powerBackup;
    }
}
