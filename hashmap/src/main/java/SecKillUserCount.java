import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lizhecao 2021/3/4
 * @version 1.0
 */
public class SecKillUserCount {
  class Temp {
    int count;
    String s;

    public Temp(String s) {
      this.s = s;
      this.count = 1;
    }

    public int getCount() {
      return count;
    }

    public void setCount(int count) {
      this.count = count;
    }

    public String getS() {
      return s;
    }

    public void setS(String s) {
      this.s = s;
    }
  }
  public int count(List<String> timestamps) {
    Map<String, Temp> map = new HashMap<>();
    for (String t : timestamps) {
      String[] s = t.split("\\.");
      String pre = s[0];
      String after = s[1];
      Temp temp = map.get(pre);
      if (null == temp) {
        map.put(pre, new Temp(after));
      } else {
        if (temp.getS().compareTo(after) == 0) {
          temp.setCount(temp.getCount() + 1);
        } else if (temp.getS().compareTo(after) > 0) {
          map.put(pre, new Temp(after));
        }
      }
    }
    Integer result = 0;
    for (Temp value : map.values()) {
      result += value.getCount();
    }
    return result;
  }

  public static void main(String[] args) {
    SecKillUserCount secKillUserCount = new SecKillUserCount();
    List<String> l = new ArrayList<>();
    l.add("2019-01-01 08:59:00.123");
    l.add("2019-01-01 08:59:00.124");
    l.add("2019-01-01 08:59:00.125");
    System.out.println(secKillUserCount.count(l));
  }
}
