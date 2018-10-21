class CPUProcess implements Runnable {

    CPUQueue queue;
    int generateNumber;

    CPUProcess(CPUQueue q, int gN) {
        this.queue = q;
        this.generateNumber = gN;
    }

    public void run() {
        long generateDelay;
        for (int i = 0; i < generateNumber; i++) {
            int randMin = 10;
            int randMax = 40; // rand = [10,50]
            generateDelay = randMin + (int) (Math.random() * randMax);
            try {
                Thread.sleep(generateDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("Process generated with delay " + generateDelay);
                queue.put("New process");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("No more processes. Percent delete process is  " + queue.getDeleteProcess() / (double) generateNumber);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }
}