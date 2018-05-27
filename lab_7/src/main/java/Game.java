import character.*;
import java.util.ArrayList;

public class Game{
    ArrayList<Player> player = new ArrayList<Player>();
    String splitter = "=======================================\n";

    public Player find(String name){
        for (int i=0; i < player.size(); i++) {
            if (player.get(i).getName() == name) {
                return player.get(i);
            }
        }
        return null;
    }

    public String add(String chara, String tipe, int hp){
        Player checkPlayer = find(chara);
        if (checkPlayer == null) {
            if (tipe == "Human") {
                Player newPlayer = new Human(chara, hp);
                player.add(newPlayer);
            } else if (tipe == "Monster") {
                Player newPlayer = new Monster(chara, hp);
                player.add(newPlayer);
            } else if (tipe == "Magician") {
                Player newPlayer = new Magician(chara, hp);
                player.add(newPlayer);
            }
            return splitter + chara + " ditambah ke game";
        } else {
            return splitter + "Sudah ada karakter bernama " + chara;
        }
    }

    public String add(String chara, String tipe, int hp, String roar){
        Player checkPlayer = find(chara);
        if (checkPlayer == null) {
            if (tipe == "Human") {
                Player newPlayer = new Human(chara, hp);
                player.add(newPlayer);
            } else if (tipe == "Monster") {
                Player newPlayer = new Monster(chara, hp);
                newPlayer.setRoar(roar);
                player.add(newPlayer);
            } else if (tipe == "Magician") {
                Player newPlayer = new Magician(chara, hp);
                player.add(newPlayer);
            }
            return splitter + chara + " ditambah ke game";
        } else {
            return splitter + "Sudah ada karakter bernama " + chara;
        }
    }

    public String remove(String chara){
        Player checkPlayer = find(chara);
        if (checkPlayer == null) {
            return splitter + "Tidak ada " + chara;
        }
        player.remove(checkPlayer);
        return splitter + chara + " dihapus dari game";
    }

    public String status(String chara){
        Player checkPlayer = find(chara);
        if (checkPlayer == null) {
            return splitter + "Tidak ada " + chara;
        }
        return splitter + checkPlayer.status();
    }

    public String status(){
        String allStatus = "";
        for (int i=0; i < player.size(); i++) {
            allStatus += player.get(i).status() + "\n";
        }
        return splitter + allStatus.substring(0, allStatus.length()-2);        
    }

    public String diet(String chara){
        Player checkPlayer = find(chara);
        if (checkPlayer == null) {
            return splitter + "Tidak ada " + chara;
        }
        return splitter + checkPlayer.diet();
    }

    public String diet(){
        String allDiet = "";
        for (int i=0; i < player.size(); i++) {
            allDiet += player.get(i).getName() + " memakan: \n" + player.get(i).diet() + "\n\n";
        }
        return splitter + allDiet.substring(0, allDiet.length()-4);
    }

    public String attack(String meName, String enemyName){
        Player mePlayer = find(meName);
        Player enemyPlayer = find(enemyName);

        if (mePlayer == null || enemyPlayer == null) {
            return splitter + "Tidak ada " + meName + " atau " + enemyName;
        }

        return splitter + mePlayer.attack(enemyPlayer);
    }

    public String burn(String meName, String enemyName){
        Player mePlayer = find(meName);
        Player enemyPlayer = find(enemyName);

        if (mePlayer == null || enemyPlayer == null) {
            return splitter + "Tidak ada " + meName + " atau " + enemyName;
        }

        if(mePlayer.getType() == "Magician") {
            return splitter + mePlayer.burn(enemyPlayer);
        } 

        return splitter + meName + " tidak bisa membakar " + enemyName;
    }

    public String eat(String meName, String enemyName){
        Player mePlayer = find(meName);
        Player enemyPlayer = find(enemyName);
        String doneEat = "";

        if (mePlayer == null || enemyPlayer == null) {
            return splitter + "Tidak ada " + meName + " atau " + enemyName;
        }

        if (!mePlayer.getIsDead() && enemyPlayer.getIsDead()) {

            if (mePlayer.getType() == "Human" || mePlayer.getType() == "Magician") {
                if (enemyPlayer.getType() != "Monster" || !enemyPlayer.getIsCooked()) {
                    return splitter + mePlayer.getName() + " tidak bisa memakan " + enemyPlayer.getName();
                }
            }

            doneEat = splitter + mePlayer.eat(enemyPlayer);
            remove(enemyName);
            return doneEat;
        }

        return splitter + mePlayer.getName() + " tidak bisa memakan " + enemyPlayer.getName();
    }

    public String roar(String meName){
        Player mePlayer = find(meName);

        if (mePlayer == null) {
            return splitter + "Tidak ada " + meName;
        }

        if(mePlayer.getType() == "Monster") {
            return splitter + mePlayer.roar();
        }

        return splitter + meName + " tidak bisa melakukan roar";
    }
}