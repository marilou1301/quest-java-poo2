package fr.wildcodeschool.java07;

public class Eagle extends Bird implements Fly {

    private boolean flying;
    private int altitude;
    private int maxAltitude;

    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.altitude = 0;
        this.maxAltitude = 4000;
    }

    public int getAltitude() {
        return altitude;
    }
    
    public int getMaxAltitude() {
        return maxAltitude;
    }
    public boolean isFlying() {
        return flying;
    }

    @Override
    public String sing() {
        return "Screech!";
    }
    
    // implémentation des méthodes héritées
    
    @Override
    public void takeOff() {
        if (!this.flying && this.altitude == 0) {
            this.flying = true;
            System.out.printf("%s takes off in the sky.%n", this.getName());
        }
    }

    /*
     * ascension / l'aigle monte de <param> metres  , 
     * <return>  = altitude atteinte ( ou maximum de l'individu )
     */
    @Override
    public int ascend(int meters) {
        if (this.flying) {
            this.altitude = Math.min(this.altitude + meters, this.maxAltitude);
            System.out.printf("%s flies upward, altitude : %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }

    /*
     * descente / l'aigle descend de <param> metres  , 
     * <return>  = altitude atteinte ( ou 0 )
     */
    @Override
    public int descend(int meters) {
        if (this.flying) {
            this.altitude = Math.max(this.altitude - meters, 0);
            System.out.printf("%s flies downward, altitude : %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }

    /**
     * atterrissage, doit être à 1 mètre du sol au maximum 
     */
    @Override
    public void land() {
        if (this.flying && this.altitude <= 1) {
            System.out.printf("%s lands on the ground.%n", this.getName());
        } else {
            System.out.printf("%s is too high, it can't land.%n", this.getName());
        }
    }
}


