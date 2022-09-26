package parkinglot;

public enum ParkingSlotType {
    TwoWheeler {
        public double getPriceForParking(long duration) {
            return duration * 0.05;
        }
    },
    Compact {
        public double getPriceForParking(long duration) {
            return duration * 0.75;
        }
    },
    Medium {
        public double getPriceForParking(long duration) {
            return duration * 1.0;
        }
    },
    Large {
        public double getPriceForParking(long duration) {
            return duration * 1.25;
        }
    };

    public abstract double getPriceForParking(long duration);
}
