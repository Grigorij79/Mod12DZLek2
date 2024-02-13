import java.util.concurrent.atomic.AtomicBoolean;

public class ProcessThread extends  Thread{
    private  int number;
    private AtomicBoolean processed = new AtomicBoolean(true);
    private NumberProcessor processor;
    public ProcessThread (NumberProcessor processor){
        this.processor = processor;
    }
public boolean isPfocesed () {
        return processed.get();
}


    public synchronized void process(int number) {
        this.number = number;
        processed.set(false);
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (processed.get()){
                continue;
            }
            processor.process(number);

            processed.set(true);
        }
    }
}

