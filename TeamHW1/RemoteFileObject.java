
public interface RemoteFileObject extends java.rmi.Remote {
	public abstract void open(String filename) throws java.rmi.RemoteException;
	public abstract String readLine() throws java.rmi.RemoteException;
	public abstract void close() throws java.rmi.RemoteException;
}