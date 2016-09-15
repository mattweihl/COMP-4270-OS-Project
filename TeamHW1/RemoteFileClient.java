/**
 * RMI client that opens and reads a file from a remote server.
 */

public class RemoteFileClient
{
	static final String server = "127.0.0.1";
	static RemoteFileObject file;

	public static void main(String[] args) throws java.io.IOException {
		
		try {
			String host = "rmi://" + server + "/RemoteFileObject";

			file = (RemoteFileObject)java.rmi.Naming.lookup("RemoteFileObject");
			
			file.open("hello.txt");
			System.out.println("File found");

			String line;
			while( (line = file.readLine()) != null)
				System.out.println(line);
		}
		catch (java.net.MalformedURLException e){
			//System.err.println(e);
			e.printStackTrace();
		}
		catch (java.rmi.NotBoundException e){
			//System.err.println(nbe);
			e.printStackTrace();
		}
		catch (java.io.IOException e) {
			//System.err.println(ioe); 
			e.printStackTrace();
		}
		catch (java.lang.NullPointerException e) {
			e.printStackTrace();
		}
        finally {
        	file.close();
        }
	}
}
