public class LoadableAudio implements Loadable, AudioStream{
  private int f; //frequency
  private int s; //size
  private int a = 0;
  private int[] t; 
  public LoadableAudio(){ //default constructor
  }
  public LoadableAudio(int frequency, int size){ //sets initial frequency and size 
    this.f = frequency;
    this.s = size;
  }
  public void setT(int[] d){ //method to set a value for the list
    this.t = d; 
  }
  public boolean matches(int [] data){
    if(data[0] == 3 &&  data[1] == 2 && data[2] == 1){ //check to see if audio file
      return true;
    }
    return false;
  }
  public LoadableAudio load(int[] data)throws LoadException{
    if(4 > data.length){//ensures there is at least the audio data sign and frequency value
      throw new LoadException("not enough data");
    }
    for(int i = 4; i < data.length; i++){
      if(-999 > data[i] || 999 < data[i]){ //check to see if point is out of bounds or not
        throw new LoadException("out of bounds");
      }
    }
    LoadableAudio y = new LoadableAudio(data[3], data.length - 4);
    int[] d = new int[data.length - 4]; //first of the values is after point 3
    int n = 0; //counter for index
    for(int i = 4; i < data.length; i++){
      d[n] = data[i];
      n++;
    }
    y.setT(d); //sets d = new list y
    return y;
  }
  public int freq(){
    return this.f;
  }
  public int next(){
    int hold = this.t[a];
    a++;
    return hold; //returns the next value
  }
  public boolean hasNext(){
    if(a < this.t.length){
      return true; //checks if there is a next value
    }
    return false;
  }
}
