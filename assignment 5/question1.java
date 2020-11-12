
public class question1 extends Thread{

    public static void main(String args[]){
        question1 a = new question1();
        a.start();
    }

    public void run(){
        for(int i=0; i<=100; i++){
            System.out.println(i);
            try{
                Thread.sleep(1000);
            }catch(Exception e){}
        }
    }
}