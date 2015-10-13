package week8.di;

public class Singer implements Performer {
  private Song song;

  public Song getSong() {
    return song;
  }

  public void setSong(Song song) {
    this.song = song;
  }

  @Override
  public void perform() {
    System.out.println("Sings: " + song);
  }
}
