public abstract class AudioPlayer implements Player{
  
  public AudioPlayer(){
  }
  public abstract void playback(AudioStream aud); //Abstract method
  public boolean canPlay(Loadable l){
    if(l instanceof AudioStream){ //checks to see if loadable object is an AudioStream object
      return true;
    }
    return false;
  }
  public void play(Loadable l){
    AudioStream x = (AudioStream) l; //casts l as an audiostream object
    playback(x); //plays back x as an AudioStream object
  }
}