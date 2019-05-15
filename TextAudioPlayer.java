public class TextAudioPlayer extends AudioPlayer{
  private int i;
  public TextAudioPlayer(){
  }
  public void playback(AudioStream aud){
    while(aud.hasNext() == true){ //checks to see if there is a next value
      int pos = (aud.next()+1000)*7/200; //position of the asterix
      for(i = 0; i < pos; i++){ 
        System.out.print(" "); //prints a space until the value of the asterix is reached
      }
      System.out.print("*");//prints asterix
      System.out.println();//prints the new line
    }
    
  }
}
  