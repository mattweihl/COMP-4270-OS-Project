/**
 * Implementation of the RemoteFileObject interface.
 *
 */
 
public class RemoteFileObjectImpl extends java.rmi.server.UnicastRemoteObject implements RemoteFileObject
{
	java.io.BufferedReader readFile;
	
	int count = 0;

    public RemoteFileObjectImpl() throws java.rmi.RemoteException {  }
  
	/**
	 * Open the remote file
	 */ 
	public void open(String fileName) throws java.rmi.RemoteException {
		try {
			readFile = new java.io.BufferedReader(new java.io.FileReader(fileName));
		}
		catch (java.io.FileNotFoundException fnfe) { 
			throw new java.rmi.RemoteException ("File Not Found" , fnfe);
		}
	}

	/**
	 * Read a line from the remote file.
	 */
	public String readLine() throws java.rmi.RemoteException {
		try {
			return readFile.readLine();
		}
		catch (java.io.IOException ioe) {
			throw new java.rmi.RemoteException ("IOException", ioe);
		}
	}

	/**
	 * Close the remote file.
	 */
	public void close() throws java.rmi.RemoteException {
		try {
			readFile.close();
		}
		catch (java.io.IOException ioe) {
			throw new java.rmi.RemoteException ("IOException", ioe);
		}
	}


	public static void main( String args[] ) throws Exception 
    { 
        // Assign a security manager, in the event that 
        //dynamic classes are loaded 
        // if( System.getSecurityManager() == null ) 
        //     System.setSecurityManager 
        //         ( new RMISecurityManager() ); 
        System.setProperty("java.rmi.server.hostname","127.0.0.1");
        try { 
            // Create an instance of the ConverterServer 
            RemoteFileObject svr = new RemoteFileObjectImpl(); 
            // then bind it with the rmi registry 
            java.rmi.Naming.rebind ( "RemoteFileObject", svr ); 
            System.out.println ("Service bound...."); 
        } 
        catch( Exception e ) 
        { System.out.println( "Server Failed: " + e ); } 
    } 
}
