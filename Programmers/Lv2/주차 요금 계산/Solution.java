import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, String> map = new HashMap<String, String>();
        Map<String, Integer> timeOfCar = new HashMap<String, Integer>();
        
        for(String record : records) {
            String time = record.substring(0, 5);
            String car = record.substring(6, 10);
            String history = record.substring(11, record.length());

            if(history.equals("IN")) {
                map.put(car, time);
            } else {
                String startOfTime = map.get(car);
                int durationOfCar = calcTime(startOfTime, time);
                timeOfCar.compute(car, (k, v) -> (v == null) ? durationOfCar : v + durationOfCar);
                map.remove(car);
            }
        }
        if(!map.isEmpty()) {
            for(String car : map.keySet()) {
                String startOfTime = map.get(car);
                int durationOfCar = calcTime(startOfTime, "23:59");
                timeOfCar.compute(car, (k, v) -> (v == null) ? durationOfCar : v + durationOfCar);
            }
        }
       
        Object[] result = timeOfCar.keySet().toArray();
        Arrays.sort(result);
        int [] answer = new int[result.length];
        for(int i = 0; i < result.length; i++) {
            answer[i] = calcCost(timeOfCar.get(result[i]), fees);
        }
        return answer;
    }
    
    private int calcTime(String time) {
        int hour = Integer.parseInt(time.substring(0,2));
        int min = Integer.parseInt(time.substring(3,5));
        
        return hour * 60 + min;
    }
    
    private int calcTime(String startTime, String endTime) {
        int startMin = calcTime(startTime);
        int endMin = calcTime(endTime);

        return endMin - startMin;
    }
    
    private int calcCost(int time, int[] fees) {

        int costOfCar = time > 0 ? fees[1] : 0;
        if(time > fees[0]) {
            int costMin = (time  - fees[0]) % fees[2] == 0 ? (time  - fees[0]) / fees[2] : (time  - fees[0]) / fees[2] + 1;
            costOfCar += costMin * fees[3];
        }
        return costOfCar;
    }
}