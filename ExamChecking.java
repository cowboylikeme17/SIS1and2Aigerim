import java.util.Date;
class ExamChecking extends Thread {
    private static int examSheets = 500;
    private final int maxChecks;
    private int checksDone = 0;

    public ExamChecking(int maxChecks) {
        this.maxChecks = maxChecks;
    }
    @Override
    public void run() {
        try {
            while (examSheets > 0 && checksDone < maxChecks) {
                synchronized (ExamChecking.class) {
                    if (examSheets <= 0) {
                        break;
                    }

                    examSheets -= 50;
                    checksDone++;
                    System.out.println(Thread.currentThread().getName() +
                            " finished checking, at: " + new Date() +
                            ", exam sheet count is now " + examSheets);
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (examSheets <= 0) {
            System.out.println("There is no any exam sheet left! All papers were already checked!");
        }
    }
}


