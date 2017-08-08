/**
 * Created by ac003588 on 8/7/2017.
 */
public class Main {

    public static void main(String[] args) {
        Album album1 = new Album("Killswitch Engage", "Incarnate");
        album1.addSong("In Due Time", 240);
        album1.addSong("My Curse", 300);
        album1.addSong("My Last Serenade", 280);

        System.out.println(album1.listSongs());

        Album album2 = new Album("Soilwork", "Figure Number 5");
        album2.addSong("Rejection Role", 240);
        album2.addSong("The Thrill", 300);
        album2.addSong("Dog of Pavlov", 280);

        System.out.println(album2.listSongs());


        Album album3 = new Album("Killswitch Engage", "Disarm the Descent");
        album3.addSong("Kill Heart", 240);
        album3.addSong("The Devil Within", 300);
        album3.addSong("Sacrifice", 280);

        System.out.println(album3.listSongs());



        Jukebox jukebox1 = new Jukebox();
        jukebox1.addAlbum(album1);
        jukebox1.addAlbum(album2);
        jukebox1.addAlbum(album3);

        System.out.println("Songs found... " + jukebox1.searchSongs("Killswitch Engage"));
        System.out.println("Songs found... " + jukebox1.searchSongs("Sacrifice"));
        System.out.println("Songs found... " + jukebox1.searchSongs("Incarnate"));

        jukebox1.jukeMenu();

    }
}
