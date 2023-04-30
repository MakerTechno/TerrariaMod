package nowebsite.maker.terrariamod.manasystem.client;

/**
 * Class holding the data for mana client-side
 */
public class ClientManaData {

    private static int playerMana;
    private static int playerManaMaxInt;
    private static int playerStars;
    private static boolean usesArcaneCrystal;

    public static void set(int playerMana, int playerManaMaxInt,int playerStars,boolean usesArcaneCrystal) {
        ClientManaData.playerMana = playerMana;
        ClientManaData.playerManaMaxInt = playerManaMaxInt;
        ClientManaData.playerStars = playerStars;
        ClientManaData.usesArcaneCrystal = usesArcaneCrystal;
    }

    public static int getPlayerMana() {
        return playerMana;
    }

    public static int getPlayerManaMaxInt(){
        return playerManaMaxInt;
    }

    public static int getPlayerStars() {
        return playerStars;
    }

    public static boolean isUsesArcaneCrystal(){
        return usesArcaneCrystal;
    }
}
