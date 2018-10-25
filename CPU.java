class CPU implements Runnable{

    int count = 0;
    boolean work = false;
    String b;
    CPU(){   }

    public synchronized void waiting(){
        while(!work) {
            try {

                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void  put(String a)
    {
        if(!work)
        {
            this.b = a;
            work = true;
            notify();
        }
        else
        {
            System.out.println("Delete process");
            count++;
        }
    }
    public synchronized int getCount(){
        return count;
    }
    public void run(){
        long processingTime;
        while(true) {
            if (work) {
                int randMin = 20;
                int randMax = 100; // rand = [20,100]
                processingTime = randMin + (int) (Math.random() * randMax);
                System.out.println("CPU:" + b + " processed in time " + processingTime + "\n");
                try {
                    Thread.sleep(processingTime);
                    System.out.println("CPU:Process with " + processingTime + " delay finished");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                work = false;
            }
            waiting();
        }
    }
}
