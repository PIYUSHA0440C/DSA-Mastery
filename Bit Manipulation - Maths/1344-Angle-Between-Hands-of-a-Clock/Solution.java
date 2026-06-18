class Solution {
    public double angleClock(int hour, int minutes) {
        double minutesAngle = minutes * 6;
        
        double hourAngle = (30 * (hour % 12)) + 0.5 * minutes;

        double diff = Math.abs(minutesAngle - hourAngle);
        
        return Math.min(diff, 360.0 - diff);
    }
}
