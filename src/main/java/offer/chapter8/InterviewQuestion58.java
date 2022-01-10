package offer.chapter8;

import java.util.Map;
import java.util.TreeMap;

/**
 * 面试题58：日程表
 * 请实现一个类型MyCalendar用来记录自己的日程安排，
 * 该类型用方法book(int start, int end)在日程表中添加一个时间区域为[start, end)的事项（这是一个半开半闭区间）。
 * 如果[start, end)中之前没有安排其他事项，则成功添加该事项并返回true；否则，不能添加该事项，并返回false
 *
 * @author Mr.黄
 * @date 2022/01/10
 **/
public class InterviewQuestion58 {
  class MyCalendar {
    private TreeMap<Integer, Integer> events;
    
    public MyCalendar() {
      events = new TreeMap<>();
    }
    
    /**
     * 添加事项
     *   当插入一个新事项是，事项对应的时间区间不能重叠。
     *   
     * @param start 待添加事项的开始时间
     * @param end   待添加事项的结束时间
     * @return 添加成功返回true，否则返回false
     */
    public boolean book(int start, int end) {
      // 获取开始时间小于等于start的最晚的一个事项event
      Map.Entry<Integer, Integer> event = events.floorEntry(start);
      if (event != null && event.getValue() > start) {
        // 如果获取到的event事项的结束时间大于start，则添加事项失败
        return false;
      }
      // 获取开始时间大于等于start的最早的一个事项event
      event = events.ceilingEntry(start);
      if (event != null && event.getKey() < end) {
        // 如果获取到的事项event的开始时间小于end，则添加事项失败
        return false;
      }
      // 添加事项成功
      events.put(start, end);
      return true;
    }
  }
}