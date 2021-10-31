package Git;

public class TTS {
    public static void main(String[] args) {
        //1大2中，3小
        ParkingSystem system = new ParkingSystem(1,2,1);

        system.parse("[1,2,1],[1],[1],[2],[3]");
        system.print();
    }

}
