import java.util.HashMap;
import java.util.Map;

public class RobotManager {
    // Static maps shared across ALL instances
    private static Map<String, MyRobotLegoEV3> activeRobots = new HashMap<>();
    private static Map<String, RobotLegoSimulado> activeSimulatedRobots = new HashMap<>();
    
    public synchronized static MyRobotLegoEV3 getRobotByName(String name, GestorRobot gestor) {
        if (!activeRobots.containsKey(name)) {
            // Create new robot only if it doesn't exist
            MyRobotLegoEV3 newRobot = new MyRobotLegoEV3();
            newRobot.start();
            newRobot.setGestor(gestor);
            activeRobots.put(name, newRobot);
        }
        return activeRobots.get(name);
    }
    
    public synchronized static RobotLegoSimulado getSimulatedRobotByName(String name) {
        if (!activeSimulatedRobots.containsKey(name)) {
            RobotLegoSimulado newRobot = new RobotLegoSimulado();
            activeSimulatedRobots.put(name, newRobot);
        }
        return activeSimulatedRobots.get(name);
    }
    
    public synchronized static void removeRobot(String name) {
        activeRobots.remove(name);
    }
    
    public synchronized static void removeSimulatedRobot(String name) {
        activeSimulatedRobots.remove(name);
    }
    
    public synchronized static boolean isRobotActive(String name) {
        return activeRobots.containsKey(name);
    }
}
