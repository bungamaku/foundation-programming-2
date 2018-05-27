public class Lab7 {
    public static void main(String[] args){
        Game game1 = new Game();
        System.out.println(game1.add("Almarhum", "Human", 0)); //Almarhum ditambah ke game
        System.out.println(game1.add("Humas", "Human", 10)); //Humas ditambah ke game
        System.out.println(game1.add("Fooder", "Monster", 0)); //Fooder ditambah ke game
        System.out.println(game1.add("Mon", "Monster", 50)); //Mon ditambah ke game
        System.out.println(game1.add("Mons", "Monster", 50)); //Mons ditambah ke game
        System.out.println(game1.add("Mons", "Monster", 50)); //Sudah ada karakter bernama Mons
        System.out.println(game1.add("Mons", "Magician", 50)); //Sudah ada karakter bernama Mons
        System.out.println(game1.add("Magi", "Magician", 150)); //Magi ditambah ke game
        System.out.println(game1.remove("Mons")); //Mons dihapus dari game
        System.out.println(game1.remove("Mons")); //Tidak ada Mons
        System.out.println(game1.remove("Monsta")); //Tidak ada Monsta
        System.out.println(game1.add("Mons", "Monster", 50)); //Mons ditambah ke game
        System.out.println(game1.burn("Magi", "Fooder")); //Nyawa Fooder 0 \n dan matang
        System.out.println(game1.eat("Humas", "Fooder")); //Humas memakan Fooder\nNyawa Humas kini 25
        System.out.println(game1.attack("Magi", "Humas")); //Nyawa Humas 15
        System.out.println(game1.attack("Mon", "Humas")); //Nyawa Humas 5
        System.out.println(game1.burn("Magi", "Humas")); //Nyawa Humas 0 \n dan matang
        System.out.println(game1.burn("Magi", "Mons")); //Nyawa Mons 90
        System.out.println(game1.eat("Magi", "Humas")); //Magi tidak bisa memakan Humas
        System.out.println(game1.eat("Mons", "Humas")); //Mons memakan Humas\nNyawa Mons kini 105
        System.out.println(game1.eat("Mons", "Magi")); //Mons tidak bisa memakan Magi
        System.out.println(game1.diet("Mons"));//Human Humas
        System.out.println(game1.add("Humas", "Human", 20)); //Humas ditambah ke game
        System.out.println(game1.status("Magi"));//Magician Magi\nHP: 150\nMasih hidup\Belum memakan siapa siapa
        System.out.println(game1.status("Mons"));//Monster Mons\nHP: 105\nMasih hidup\nMemakan Human Humas
        System.out.println(game1.roar("Magi"));//Magi tidak bisa berteriak
        System.out.println(game1.roar("Mons"));//AAAAAAaaaAAAAAaaaAAAAAA    
        System.out.println(game1.roar("Katty Perry"));//Tidak ada Katty Perry
        System.out.println(game1.status());
        // Human Almarhum
        // HP: 0
        // Sudah meninggal dunia dengan damai
        // Belum memakan siapa siapa 
        // Monster Mon
        // HP: 100
        // Masih hidup
        // Belum memakan siapa siapa
        // Magician Magi
        // HP: 150
        // Masih hidup
        // Belum memakan siapa siapa
        // Monster Mons
        // HP: 105
        // Masih hidup
        // Memakan Human Humas
        // Human Humas
        // HP: 20
        // Masih hidup
        // Belum memakan siapa siapa
    }
}