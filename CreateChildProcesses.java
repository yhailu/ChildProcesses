/**
 * Created by yesuserahailu on 9/30/17.
 */
import java.io.IOException;
import java.lang.Process;
public class CreateChildProcesses {

    public static void main(String [] args){

        childProcess one = new childProcess("bc", "I");
        childProcess two = new childProcess("cal", "2017");
        one.waitToKill();
        two.waitToKill();


        System.out.println("Exit value for ChildProcess1 " + one.waitValue());
        System.out.println("Exit value ChildProcess2 " + one.waitValue());


    }
    static class childProcess{
        public String poc;
        public String sig;
        Process child;

        public childProcess(String proc, String sig){

           try{
               child = new ProcessBuilder().command(proc, sig).inheritIO().start();


           }catch(IOException e){
               System.out.println("Exception was thrown:" + e);

           }

       }

        public void waitToKill(){
            try {
                child.waitFor();
            }catch(Exception e){
                System.out.println("Execption"+ e);
            }
        }
        public int waitValue(){
            return child.exitValue();
        }


    }
}
