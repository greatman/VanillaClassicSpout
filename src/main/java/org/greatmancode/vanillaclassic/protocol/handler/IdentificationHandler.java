package org.greatmancode.vanillaclassic.protocol.handler;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.greatmancode.vanillaclassic.VanillaClassicPlugin;
import org.greatmancode.vanillaclassic.protocol.msg.IdentificationMessage;
import org.spout.api.protocol.MessageHandler;
import org.spout.api.protocol.Session;

public final class IdentificationHandler extends MessageHandler<IdentificationMessage> {
	@Override
	public void handleServer(Session session, IdentificationMessage message) {
		if (message.getVerificationKeyOrServerMOTD().equals(md5(VanillaClassicPlugin.salt + message.getUsernameOrServerName()))) {
			
		}
	}
	
	public static String md5(String input){
        String res = "";
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(input.getBytes());
            byte[] md5 = algorithm.digest();
            String tmp = "";
            for (int i = 0; i < md5.length; i++) {
                tmp = (Integer.toHexString(0xFF & md5[i]));
                if (tmp.length() == 1) {
                    res += "0" + tmp;
                } else {
                    res += tmp;
                }
            }
        } catch (NoSuchAlgorithmException ex) {}
        return res;
    }
}
