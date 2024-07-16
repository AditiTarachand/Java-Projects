
import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String Artist;
    private ArrayList<song> song;

    public Album(String name, String Artist ){
     this.name= name;
     this.Artist= Artist;
     this.song= new ArrayList<song>();
    }

    public Album(){

    }
    public song findSong(String title)
    {
        for(song checkedSong: song){
            if (checkedSong.getTitle().equals(title)) {
                return checkedSong;
                
            }
            
        }
        return null;

    }

    public boolean addSong(String title, double duration)
    {


        if (findSong(title)== null) {
            song.add(new song(title, duration));
            System.out.println(title+" Successfully added to the list");
            return true;

            
        }
        else{
            System.out.println("Song with name "+title +"already exist in the list");
            return false;
        }
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<song> Playlist)
    {
        int index= trackNumber-1;
        if (index> 0 && index<= this.song.size()) {
            Playlist.add(this.song.get(index));
           return true; 
        }
        System.out.println("This Album does not have song with track number "+ trackNumber);
        return false;

    }
    public boolean addToPlaylist(String title, LinkedList<song> Playlist){
        for(song checkedSong: this.song){
            if (checkedSong.getTitle().equals(title)) {
                Playlist.add(checkedSong);
                return true;
            }
            
        }
        System.out.println("There is no such song in Album");
            return false;

    }

    
}
