package week8.di;

import java.util.List;

public class Band {
  private List<Performer> performerList;

  public List<Performer> getPerformerList() {
    return performerList;
  }

  public void setPerformerList(List<Performer> performerList) {
    this.performerList = performerList;
  }

  public void startBand(){
    for (Performer performer : performerList) {
      performer.perform();
    }
  }
}
