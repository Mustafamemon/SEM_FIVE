import HelloApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.util.Properties;
class Sqaure implements Runnable 
{ 
    float val_1  ;
    float res ;
    Sqaure(String a)
    {
        this.val_1 = Float.parseFloat(a) ;
    }
    public void run() 
    { 
      this.res = this.val_1 * this.val_1 ;
    }
    public float result(){
      return this.res ; 
    }

}
class Multiplier implements Runnable 
{ 
    float val_1  ;
    float val_2 ; 
    float res ;
    Multiplier(String a , String b)
    {
        this.val_1 = Float.parseFloat(a) ;
        this.val_2 = Float.parseFloat(b);
    }
    public void run() 
    { 
      this.res = this.val_1 * this.val_2 ;
    }
    public float result(){
      return this.res ; 
    }

}
class Adder implements Runnable 
{ 
    float val_1  ;
    float val_2 ; 
    float res ;
    Adder(String a , String b)
    {
        this.val_1 = Float.parseFloat(a) ;
        this.val_2 = Float.parseFloat(b) ;
    }
    public void run() 
    { 
      this.res = this.val_1 + this.val_2 ;
    }
    public float result(){
      return this.res ; 
    }

} 
class HelloImpl extends HelloPOA {
  private ORB orb;

  public void setORB(ORB orb_val) {
    orb = orb_val; 
  }
    
  // implement () method
  public String EqOfMotion(String v0,String t, String a) {
    System.out.println(v0+ ' '  +t+' '+a);
    Multiplier Mul  = new Multiplier(v0,t);
    Sqaure     Sq   = new Sqaure(t);
    Multiplier Mul_1  = new Multiplier(String.valueOf(0.5),a);
    
    Thread t1 = new Thread(Mul);
    Thread t2 = new Thread(Mul_1);
    Thread t3 = new Thread(Sq);
    
    t1.start();
    t2.start();
    t3.start();

    try
    {
      t1.join();
      t2.join();
      t3.join();
    }
    catch(InterruptedException e)
    {
        e.printStackTrace();
    }
    
    String res=" Eq of Motion => S = " + String.valueOf(((Mul_1.result()*Sq.result())+Mul.result()));
    return res ;
  }
    
  // implement shutdown() method
  public void shutdown() {
    orb.shutdown(false);
  }
}


public class HelloServer {

  public static void main(String args[]) {
    try{
      // create and initialize the ORB
      ORB orb = ORB.init(args, null);

      // get reference to rootpoa & activate the POAManager
      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      rootpoa.the_POAManager().activate();

      // create servant and register it with the ORB
      HelloImpl helloImpl = new HelloImpl();
      helloImpl.setORB(orb); 

      // get object reference from the servant
      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl);
      Hello href = HelloHelper.narrow(ref);
	  
      // get the root naming context
      // NameService invokes the name service
      org.omg.CORBA.Object objRef =
          orb.resolve_initial_references("NameService");
      // Use NamingContextExt which is part of the Interoperable
      // Naming Service (INS) specification.
      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

      // bind the Object Reference in Naming
      String name = "Hello";
      NameComponent path[] = ncRef.to_name( name );
      ncRef.rebind(path, href);

      System.out.println("HelloServer ready and waiting ...");

      // wait for invocations from clients
      orb.run();
    } 
	
      catch (Exception e) {
        System.err.println("ERROR: " + e);
        e.printStackTrace(System.out);
      }
	  
      System.out.println("HelloServer Exiting ...");
	
  }
}
