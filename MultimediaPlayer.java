import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
public class MultimediaPlayer implements Player, Loadable{
  private TextImageViewer x;
  private TextAudioPlayer y;
  private LoadableImage z;
  private LoadableAudio a;
  private ArrayList<Loadable> loads; //arraylist where audiio files and images are stored
  private ArrayList<Player> plays; //arraylist where playable files are stored
  
  public MultimediaPlayer(){ //default constructor
    x = new TextImageViewer();
    y = new TextAudioPlayer();
    z = new LoadableImage();
    a = new LoadableAudio();
    loads = new ArrayList<Loadable>();
    plays =  new ArrayList<Player>();
    loads.add(z);
    loads.add(a);
    plays.add(x);
    plays.add(y);
  }
  public void add(Loadable l){
    if(l instanceof LoadableImage){ //checks if l is a loadable image
      loads.add(l); //adds l to arraylist if l is a loadable image
    }
    if(l instanceof LoadableAudio){ //checks if l is an audio file and adds it to the loadable arrraylist if true
      loads.add(l);
    }
  }
  public boolean canPlay(Loadable l){
    for(Player i : plays){ //goes through the arraylis of Players to see if there is a player for l
      if(i.canPlay(l)){
        return true; //if there is a match 
      }
    }
    return false; //if there in no player which may play l
  }
  public void play(Loadable l){
    for(Player i: plays){ //goes through the list of Players to find the compatible player
      if(i.canPlay(l)){ 
        i.play(l); //plays the file l with the player
      }
    }
  }
  public int[] read(String filename) throws LoadException, IOException{
    Scanner s = new Scanner(new File(filename)); //creating the scanner object
    int g = 0; //counting integer to keep track of indices
    while(s.hasNext()){//condition of having a next value
      if(s.hasNextInt()){ 
        int val = s.nextInt();//sets the value to the next integer value
        g++; //increments the counter
      }
      else{
        throw new LoadException("value not int"); //if the next value is not an integer then exception is thrown
      }
      if(s.hasNextLine() == false){ //when the last value is reached a break statemtns is passed
        break;
      }
    }
    s.close(); // closes the file
    s = new Scanner(new File(filename)); //reopens the file
    int[]d = new int[g]; //creates a new array which will be returned
    for(int i = 0; i < d.length; i++){
      d[i] = s.nextInt(); // sets each value in the array to a value recieved form the scanner
    }
    s.close(); //closes the file a second time
    return d; //returns the new array
  }
  public boolean matches(int[] data){
    for(Loadable i : loads){
      if(i.matches(data) != false){ //checks to see if the data matches i
        return true;
      }
    }
    return false;
  }
  public Loadable load(int[] data) throws LoadException{
    for(Loadable i : loads){
      if(i.matches(data) != false){ //checks to see if there is a match
        return i.load(data);
      }
    }
    throw new LoadException("no"); //kthrown exception if no match
  }
  public void play(String filename) throws LoadException, IOException{
    play(load(read(filename)));
  }
}