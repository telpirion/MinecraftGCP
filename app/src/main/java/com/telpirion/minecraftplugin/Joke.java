package com.telpirion.minecraftplugin;

import java.util.ArrayList;
import java.util.Random;

public class Joke {
  private ArrayList<String> jokes = new ArrayList<>();

  public Joke() {
    jokes.add("Why did the chicken cross the road? To get to the other side!");
    jokes.add("What do you call a bear with no teeth? A gummy bear!");
    jokes.add("What do you call a pony with a sore throat? A little horse!");
  }

  public String getJoke() {
    Random random = new Random();
    int index = random.nextInt(jokes.size());
    return jokes.get(index);
  }
}
