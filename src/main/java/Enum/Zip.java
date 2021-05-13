package Enum;

public enum Zip {

    SanJose( 95134),
    SantaClara(95050);


    private int getZip;

    Zip(int zip){this.getZip = zip;}

    public int getGetZip() {
        return getZip;
    }

}
