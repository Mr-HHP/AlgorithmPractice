package other.od200;

import java.net.InetAddress;
import java.util.*;

/**
 * @author Mr.黄
 * @description 根据IP查找城市
 * @since 2024/7/23 13:58
 **/
public class Main49 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cityAndIpRanges = scanner.nextLine();
        String ips = scanner.nextLine();
        List<IpRange> ranges = new ArrayList<>();
        for (String segment : cityAndIpRanges.split(";")) {
            String[] split = segment.split("=");
            String city = split[0];
            String range = split[1];
            String[] split1 = range.split(",");
            String startIp = split1[0];
            String endIp = split1[1];
            ranges.add(new IpRange(ipToLong(startIp), ipToLong(endIp), city));
        }
        List<String> queries = Arrays.asList(ips.split(","));
        List<String> result = findCityMatches(ranges, queries);
        System.out.println(String.join(",", result));
    }

    public static List<String> findCityMatches(List<IpRange> ranges, List<String> queries) {
        Collections.sort(ranges);
        List<String> result = new ArrayList<>();
        for (String ip : queries) {
            long ipToLong = ipToLong(ip);
            String bestMatch = "";
            long smallestRange = Long.MAX_VALUE;
            for (IpRange ipRange : ranges) {
                if (ipToLong >= ipRange.start && ipToLong <= ipRange.end) {
                    long size = ipRange.end - ipRange.start;
                    if (size < smallestRange || (size == smallestRange && ipRange.city.compareTo(bestMatch) > 0)) {
                        bestMatch = ipRange.city;
                        smallestRange = size;
                    }
                }
            }
            result.add(bestMatch);
        }
        return result;
    }

    public static long ipToLong(String ip) {
        long result = 0;
        try {
            byte[] address = InetAddress.getByName(ip).getAddress();
            for (byte b : address) {
                result = result << 8 | (b & 0xFF);
            }
        } catch (Exception e) {
            e.printStackTrace();;
        }
        return result;
    }
}

class IpRange implements Comparable<IpRange> {
    long start;
    long end;
    String city;

    public IpRange(long start, long end, String city) {
        this.start = start;
        this.end = end;
        this.city = city;
    }

    @Override
    public int compareTo(IpRange o) {
        if (this.start != o.start) {
            return Long.compare(this.start, o.start);
        }
        return Long.compare(this.end, o.end);
    }
}
