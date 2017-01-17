
package ss.week7.cmdline;

//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Server.
 * 
 * @author Theo Ruys
 * @version 2005.02.21
 */
public class Server {
	private static final String USAGE = "usage: " + Server.class.getName() + " <name> <port>";

	/** Starts a Server-application. */
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println(USAGE);
			System.exit(0);
		}
		
		String name = args[0];
//		InetAddress addr = null;
		int port = 2727;
		ServerSocket ss = null;
		Socket clientsocket = null;
		
//		try {
//			addr = InetAddress.getByName(args[0]);
//		} catch (UnknownHostException e) {
//			System.out.println(USAGE);
//           System.out.println("ERROR: host " + args[0] + " unknown");
//            System.exit(0);
//		}
		
		try {
			port = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println(USAGE);
            System.out.println("ERROR: port " + args[1]
            		           + " is not an integer");
            System.exit(0);
		}
		
		try {
			ss = new ServerSocket(port);
			
			clientsocket = ss.accept();
		} catch (IOException e) {
			System.out.println("ERROR: could not create a serversocket on port " + port);
			
		}
		
		System.out.println("Server.peer");
		
		try {
            Peer server = new Peer(name, clientsocket);
            Thread streamInputHandler = new Thread(server);
            streamInputHandler.start();
            server.handleTerminalInput();
            server.shutDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		

	}

} // end of class Server
