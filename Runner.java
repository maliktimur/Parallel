public class Runner {

    public static void main(String[] args) {
        int processToGenerate = 15;
        System.out.println("\nWill be generated " + processToGenerate + " processes\n");
        CPUQueue q = new CPUQueue();
        CPUProcess Cp = new CPUProcess(q, processToGenerate);
        CPU C = new CPU(q);
        new Thread(Cp).start();
        new Thread(C).start();
    }
}