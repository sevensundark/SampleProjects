package think_in_java.thread.deadlock;

public class MyThread extends Thread {
    private DeadlockRisk dead;  
    private int a, b;  
  
    MyThread(DeadlockRisk dead, int a, int b, String threadName) {  
        this.dead = dead;  
        this.a = a;  
        this.b = b;  
        this.setName(threadName);  
    }  
  
    @Override  
    public void run() {  
        dead.read();  
        dead.write(a, b);  
    }  
}
