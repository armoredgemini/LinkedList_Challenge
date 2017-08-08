import java.util.ArrayList;

/**
 * Created by ac003588 on 8/7/2017.
 */
public class Album {
    // An album will have an Artist
    // An album will have a title
    // An album will have a list of song objects
    // Add songs to an album
    // Remove songs from album
    // list songs on album

    private ArrayList<Song> songList = new ArrayList<>();
    String artist;
    String title;


    public Album(String artist, String title) {
        this.artist = artist;
        this.title = title;
        this.songList = new ArrayList<Song>();

    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public void addSong(String song, int duration) {
        Song newSong = new Song(song, duration);
        songList.add(newSong);
        System.out.println("Song " + song + " has been added to album");
    }

    public void removeSong(String song) {
        if(songList.contains(song)) {
            songList.remove(song);
        } else {
            System.out.println("Song " + song + " does not exist on album");
        }
    }

    public ArrayList<String> listSongs() {
        ArrayList<String> songNames = new ArrayList();
        for(Song s : songList) {
            //System.out.println("Adding Song " + s.getTitle());
            songNames.add(s.getTitle());
        }
        return songNames;
    }


    // Look for a song, and return the song object if
    public Song getSong(String name) {
        //System.out.println("Name provided to getSong is " + name);
        if (listSongs().contains(name)) {
            for (Song s : songList) {
                if (s.getTitle().equals(name)) {
                    //System.out.println("getSong Search matched " + name);
                    return s;
                }
            }
        }
        //System.out.println("getSong did not match " + name);
        return null;
    }

}
