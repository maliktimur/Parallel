public class Runner {

    public static void main(String[] args) {
        int processToGenerate = 15;
        System.out.println("\nWill be generated " + processToGenerate + " processes\n");
        CPU C = new CPU();
        //CPUQueue q = new CPUQueue();
        CPUProcess Cp = new CPUProcess(C, processToGenerate);
        //CPU C = new CPU();
        new Thread(C).start();
        new Thread(Cp).start();
    }
}