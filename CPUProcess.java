class CPUProcess implements Runnable {
    int generateNumber;
    CPU cpu;
    CPUProcess(CPU CPU, int gN) {
        this.generateNumber = gN;
        this.cpu = CPU;
    }

    public void run() {
        long generateDelay;
        for (int i = 0; i < generateNumber; i++) {
            int randMin = 10;
            int randMax = 50; // rand = [10,50]
            generateDelay = randMin + (int) (Math.random() * randMax);
            try {
                Thread.sleep(generateDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Process generated with delay " + generateDelay);
            cpu.put("New process");
        }
        System.out.println("\nNo more processes. \nPercent of deleted processes is " + cpu.getCount()*100 / (float) generateNumber+"%\n");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }
}