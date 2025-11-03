import java.lang.Math;

public class RobotSleep {
    private static final int VEL_ROBOT = 20; 
    private static final long ADICIONAL_MS = 100; 

   
    public static long calculateSleepForReta(int distancia) {
        return (long) (Math.abs(distancia) / (double) VEL_ROBOT * 1000) + ADICIONAL_MS;
    }

   
    public static long calculateSleepForCurva(int raio, int angulo) {
        return (long) (raio * Math.toRadians(angulo) / (double) VEL_ROBOT * 1000) + ADICIONAL_MS;
    }
}
