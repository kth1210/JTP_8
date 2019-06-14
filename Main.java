package pra1;
 
import javax.swing.JFrame;
 
public class Main{
    Login loginView;
    TestFrm testFrm;
   
    public static void main(String[] args) {
       
       
        Main main = new Main();
        main.loginView = new Login(); 
        main.loginView.setMain(main); 
    }
   

    public void showFrameTest(){
        loginView.dispose(); 
        this.testFrm = new TestFrm(); 
    }
 
}
