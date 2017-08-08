import java.util.*;

/**
 * Created by ac003588 on 8/7/2017.
 */
public class Jukebox {
    // A jukebox will create and maintain a playlist
    // The playlist will be comprised of songs from various albums
    // The playlist will have an ArrayList of Albums
    // You can search for artists, albums or songs
    // Add songs to the playlist
    // play the playlist
    // Skip Forward
    // Skip Backward
    // Stop

    LinkedList<Song> playList = new LinkedList<Song>();
    ArrayList<Album> albums = new ArrayList<Album>();
    Scanner reader = new Scanner(System.in);
    ListIterator<Song> stringListIterator;

    public Jukebox() {


    }

    public void addAlbum(Album a) {
        //for (Album x : albums)
            if (albums.contains(a)) {
                System.out.printf("Album already exists");
            } else {
                albums.add(a);
                System.out.println("Album " + a.getTitle() + " added...");
            }
    }



    // This will use listSongs from Album
    public ArrayList searchSongs(String term) {
        ArrayList foundSongs = new ArrayList<>();
        if (albums.isEmpty()) {
            System.out.println("No albums in Jukebox");
            return null;
        } else {
            for (Album a : albums) {
                if (a.artist.equals(term) || a.getTitle().equals(term)) {
                    // Artist can return multiple albums
                    // I now need to print the songs for each album that has this artist
                    // And add them to the foundSongs list
                    //System.out.println("Album or Title matched");
                    for (String s : a.listSongs()) {
                        foundSongs.add(s);
                    }
                    } else if (a.listSongs().contains(term)) {
                    //System.out.println("Song in listSongs");
                    foundSongs.add(a.getSong(term).getTitle());
                } //else {
                    //System.out.println("No logic in searchSongs matched");
                //}
            }
            return foundSongs;
        }
    }





    private void menu() {
        System.out.println("Jukebox Menu: \n" +
        "1: Search for Song\n" +
        "2: Add Song to Playlist \n" +
        "3: Play playlist\n" +
        "4: Skip to Next Song\n" +
        "5: Play Previous Song\n" +
        "6: Print Menu\n" +
        "7: Exit");
    }

    public void jukeMenu() {
        boolean exit = false;
        menu();

        while (!exit) {
            System.out.println("Please Select 1 - 6");
            String action = reader.next();
            int n = Integer.parseInt(action);
            switch (n) {
                case 1:
                    System.out.print("Please enter Search Criteria: ");
                    reader.nextLine();
                    String search = reader.nextLine();
                    System.out.println("Song " + searchSongs(search) + " found");
                    break;
                case 2:
                    System.out.print("Please enter Song: ");
                    reader.nextLine();
                    String song = reader.nextLine();
                    if (searchSongs(song).isEmpty()) {
                        System.out.println("\nSong does not exist");
                    } else {
                        for (Album a : albums) {
                            if(a.listSongs().contains(song)) {
                                System.out.println("Song " + song + " added to playlist");
                                playList.add(a.getSong(song));
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Playing playlist");
                    if(!playList.isEmpty()) {
                        stringListIterator = playList.listIterator(0);
                        //System.out.println("Next Index is " + stringListIterator.nextIndex());
                        //while(stringListIterator.hasNext()) {
                            //Song nextSong = stringListIterator.next();

                            System.out.printf("Playing " + stringListIterator.next().getTitle() + "\n");
                            System.out.println("Playing next.." + stringListIterator.next().getTitle() + "\n");
                            stringListIterator.previous();

                        //}
                    } else {
                        System.out.println("Playlist is empty...");
                    }
                    break;
                case 4:
                    if(stringListIterator.hasNext()) {

                        System.out.println("Skipping to " + stringListIterator.next().getTitle());
                    }else {
                        System.out.println("At end of playlist");
                    }
                    break;
                case 5:
                    if(stringListIterator.hasPrevious()) {
                        stringListIterator.previous();
                        System.out.println("Going back to " + stringListIterator.previous().getTitle());
                    }
                    break;

                case 7:
                    exit = true;
                    break;

            }
        }
    }

}








