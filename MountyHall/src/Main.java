import java.util.*;

public class Main {
    public static void main(String[] args) {

        boolean a;
        boolean b;
        boolean c;
        int cont = 0;
        String door, showndoor;
        boolean[] newDoor = new boolean[10000];
        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            a = r.nextBoolean();
            if (a) {
                b = false;
                c = false;
            } else {
                b = r.nextBoolean();
                if (b) c = false;
                else c = true;
            }
            door = PickDoor();
            System.out.println("Guest picked door: "+ door);

            showndoor = HostOpen(door, a, b, c);
            System.out.println("Host opened door: "+ showndoor);
            String swich = Switch(showndoor, door);
                if(swich =="a") {
                    newDoor[i] = a;
                    System.out.println("Guest switched to door: a");
                }
                if(swich =="b") {
                    newDoor[i] = b;
                    System.out.println("Guest switched to door: b");
                }
                if(swich =="c") {
                    newDoor[i] = c;
                    System.out.println("Guest switched to door: c");
                }
            if (newDoor[i])
                cont++;
        }

        System.out.println("Guest guessed " + cont + " out of 10000 times");
        int val = (cont*100)/10000;
        System.out.println(val);
    }

    public static String PickDoor() {
        Random r = new Random();
        String s = "";
        char c;

        c = (char) (r.nextInt(3) + 'a');
        s += c;

        return switch (s) {
            case ("a") -> "a";
            case ("b") -> "b";
            case ("c") -> "c";
            default -> "";
        };
    }

    public static String HostOpen(String PickedDoor, boolean a, boolean b, boolean c) {
        switch (PickedDoor) {
            case ("a"):
                if (a) {
                    return "b";//the chosen door (a) has the money
                } else if (c) {
                    return "b";//c has the money
                } else
                    return "c";//b has the money
            case ("b"):
                if (b) {
                    return "c";//the chosen door (b) has the money
                } else if (a) {
                    return "c";//a has the money
                } else
                    return "a";//c has the money
            case ("c"):
                if (c) {
                    return "a";//the chosen door (c) has the money
                } else if (b) {
                    return "a";//b has the money
                } else
                    return "b";//a has the money
        }
        return "";
    }

    public static String Switch(String ChosenDoor, String ShownDoor) {
        if (ChosenDoor == "a" && ShownDoor == "b") {
            return "c";
        }
        if (ChosenDoor == "a" && ShownDoor == "c") {
            return "b";
        }
        if (ChosenDoor == "b" && ShownDoor == "a") {
            return "c";
        }
        if (ChosenDoor == "b" && ShownDoor == "c") {
            return "a";
        }
        if (ChosenDoor == "c" && ShownDoor == "a") {
            return "b";
        }
        if (ChosenDoor == "c" && ShownDoor == "b") {
            return "a";
        }
        return "";
    }
}
