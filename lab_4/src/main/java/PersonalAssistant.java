public class PersonalAssistant {
    public static void main(String[] args) {
        //Menginisiasi seorang Manusia bernama Me Cin dengan umur 11
        Manusia adek = new Manusia("Me Cin", 11); 

        //Menginisiasi seorang Manusia bernama Yumna dengan umur 20 dan mempunyai uang sebanyak 500000
        Manusia abang = new Manusia("Yumna", 20, 500000);

        System.out.println(abang);
        System.out.println(adek);
        adek.sakit("Candu Internet");

        //Cek semua method
        abang.bekerja(8, 2);
        abang.rekreasi("Ancol");
        abang.sakit("Hati");
        abang.beriUang(adek);
        System.out.println(abang);

        //Kerja sampe modar
        abang.bekerja(24, 2);
        System.out.println(abang);

        //Abisin bahagianya
        abang.sakit("Migrain");
        System.out.println(abang);

        //Max bahagia
        abang.beriUang(adek, 900000);
        System.out.println(abang);

        //Cek duit kurang
        abang.rekreasi("San Diego Hills");
        abang.beriUang(adek, 100000);

        System.out.println("----------------------------------------------------------");

        adek.bekerja(1, 1);
        adek.rekreasi("KRL");
        adek.beriUang(abang, 5000);
        adek.sakit("Pelit");
        adek.beriUang(abang);
        System.out.println(adek);
    }
}
