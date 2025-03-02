package leetcode;

public class testmain1 {
	 private static boolean isDomainOnTLS1_3 = false ;
	    private static long tls1_3RecaptureInterval = 50; //defaulting to 50 milliseconds
	private static final String INFA_TLS1_3_ENABLED_ENV = "INFA_TLS1_3_ENABLED";
    private static final String INFA_TLS1_3_RECAPTURE_INTERVAL_ENV = "INFA_TLS1_3_RECAPTURE_INTERVAL";
    static {
    	isDomainOnTLS1_3 = Boolean.parseBoolean(System.getenv(INFA_TLS1_3_ENABLED_ENV));
    	try {
			tls1_3RecaptureInterval = Long.parseLong(System.getenv(INFA_TLS1_3_RECAPTURE_INTERVAL_ENV));
		} catch (NumberFormatException nfe) {
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isDomainOnTLS1_3);
		System.out.println(tls1_3RecaptureInterval);
	}

}
