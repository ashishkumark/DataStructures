package com.ashish.prep;

import java.net.Socket;

public class PortTester {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: PortTester <remote-ip> <remote-port>");
            System.exit(1);
        }
        String host = args[0];
        String port = args[1];
        System.out.println("Testing IP " + host + " on port " + port + "...");
        if (PortTester.isRemotePortInUse(host, Integer.parseInt(port))) {
            System.out.println("Port " + port + " is open!");
        } else {
            System.out.println("Port " + port + " is closed...:(");
        }
    }

    private static boolean isRemotePortInUse(String hostName, int portNumber) {
        Socket s = null;
        try {
            s = new Socket(hostName, portNumber);
            return true;
        }
        catch (Exception e) {
            return false;
        }
        finally {
            if (s != null) {
                try {
                    s.close();
                }
                catch (Exception var5_3) {
                    // empty catch block
                }
            }
        }
    }
}