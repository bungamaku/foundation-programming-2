import lab9.EventSystem;
import lab9.event.Event;
import lab9.user.User;

import java.util.ArrayList;

public class Lab9Main
{
    public static void main(String[] args)
    {
        EventSystem es = new EventSystem();
        
        // Uji add user baru
        System.out.println(es.addUser("Mahasiswa Teladan"));
        System.out.println(es.addUser("Mahasiswa Baru"));
        System.out.println(es.addUser("Mahasiswa Teladan"));
        
        // Uji add event baru
        System.out.println(es.addEvent("UTS DDP2", "2016-05-21_11:02:34","2016-05-21_14:00:00","2000421412210"));
        System.out.println(es.addEvent("UTS DDP1", "2016-05-21_11:00:00","2016-05-21_12:00:00","451234412000"));
        System.out.println(es.addEvent("UTS DDP2", "2016-05-21_11:20:34","2016-05-21_15:00:00","50053123200"));
        System.out.println(es.addEvent("UAS DDP2", "2016-05-21_11:20:34","2016-05-20_15:00:00","44045"));
        System.out.println(es.addEvent("Asis SDA Forever", "2017-05-21_11:20:34","2018-05-21_15:00:00","123000000000000000000000123456789000000000000000001234567891234567800000000000000000000000000000000012345678912345678912345678900000000000000000000000000000000000000000001234567893456789123456789000000000000000123456789123456789000000000000000000123456789123456789123456789123456789123456789"));
        
        // Uji get event (Event.toString())
        System.out.println(es.getEvent("UTS DDP2"));
        System.out.println(es.getEvent("Asis SDA Forever"));
        
        // Uji register to event
        System.out.println(es.registerToEvent("Mahasiswa Baru","UTS DDP2"));
        System.out.println(es.registerToEvent("Mahasiswa Teladan","UTS DDP1"));
        System.out.println(es.registerToEvent("Mahasiswa Abadi","UTS DDP3"));
        System.out.println(es.registerToEvent("Mahasiswa Baru","UTS DDP1"));
        System.out.println(es.registerToEvent("Mahasiswa Abadi","UTS DDP1"));
        System.out.println(es.registerToEvent("Mahasiswa Teladan","Asis SDA Forever"));
        
        // Uji urutan dari getEvents() (sort)
        System.out.println(es.addUser("Mahasiswa suka makan"));
        System.out.println(es.addEvent("Makan siang","2014-01-20_12:30:00","2014-01-20_13:00:00","15000"));
        System.out.println(es.addEvent("Makan telat","2014-01-20_22:30:00","2014-01-20_23:00:00","35000"));
        System.out.println(es.addEvent("Sarapan","2014-01-20_06:30:00","2014-01-20_07:00:00","10000"));
        System.out.println(es.addEvent("Makan malam","2014-01-20_19:30:00","2014-01-20_20:00:00","20000"));
        System.out.println(es.addEvent("Ngoding seharian","2014-01-20_00:00:01","2014-01-20_23:59:59","0"));
        System.out.println(es.registerToEvent("Mahasiswa suka makan","Makan malam"));
        System.out.println(es.registerToEvent("Mahasiswa suka makan","Makan telat"));
        System.out.println(es.registerToEvent("Mahasiswa suka makan","Ngoding seharian"));
        System.out.println(es.registerToEvent("Mahasiswa suka makan","Sarapan"));
        System.out.println(es.registerToEvent("Mahasiswa suka makan","Makan siang"));
        User sukaMakan = es.getUser("Mahasiswa suka makan");
        for (Event e : sukaMakan.getEvents()) {
            System.out.println(e);
        }
        System.out.println("Biaya Mahasiswa suka makan: " + sukaMakan.getTotalCost());
        
        // Uji representasi cost
        User teladan = es.getUser("Mahasiswa Teladan");
        ArrayList<Event> teladanEvents = teladan.getEvents();
        for (Event te : teladanEvents) {
            System.out.println(te);
        }
        System.out.println("Biaya Mahasiswa Teladan: " + teladan.getTotalCost());
        System.out.println("Biaya Mahasiswa Baru: " + es.getUser("Mahasiswa Baru").getTotalCost());
    }
}
