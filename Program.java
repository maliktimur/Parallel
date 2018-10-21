public class Program {



    private CPU cpu1;


    private CPUProcess newProcess;

    public static int getRandomNumber(int min, int max) {
        int tmp = min + (int)(Math.random()*max);
        System.out.println("Delay is: " + tmp);
        return tmp;
    }

    Program(){
        cpu1 = new CPU("Processor");


        start();
    }

    public void start(){
        cpu1.start();
        int count = 0;

        int proc = 15;

        for (int i = 0; i < proc; ++i) {
            newProcess = new CPUProcess(getRandomNumber(10, 40));

            if (!cpu1.isBusy()) {
                cpu1.loadProcess(newProcess);
            }
            else {
                count++;
                System.out.println("Processor is busy. Process #" + newProcess.getId() + " has been deleted");
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {}
        System.out.println("Percentage of deleted processes:"+ (double)(count*100/proc));
        System.exit(0);
    }

}