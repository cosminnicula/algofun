package dev.intermediatebox.array.utils;

public class Geometry {
  public static double euclidianDistance(int x1, int x2, int y1, int y2) {
    return Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
  }
}
