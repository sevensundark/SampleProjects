/*
 * Copyright (c) 2011 MTI Ltd.
 */
package DecodePackTool;

import java.io.InputStream;
import java.io.OutputStream;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * 暗号化/復号化に関するユーティリティクラスです.
 * 
 * @author LDNS
 */
public class DesEncryper {

	/** キー：DES */
	private static final String DES_ARITHMETIC = "DES";

	/** DESキーの値 */
	private static final byte[] DES_ENCRYPTER_KEY = new byte[] { (byte) 0x8E,
			0x12, 0x39, (byte) 0x9C, 0x07, 0x72, 0x6B, 0x5B };

	/** IVキーの値 */
	private static final byte[] IV_PARAMETER_SPEC = new byte[] { (byte) 0x8E,
			0x12, 0x39, (byte) 0x9C, 0x07, 0x72, 0x6F, 0x5A };
	private static final String DES_ECIPHER_DCIPHER = "DES/CBC/PKCS5Padding";
	
	private Cipher ecipher;
	private Cipher dcipher;

	private byte[] buf = new byte[1024];

	/**
	 * コンストラクター
	 * 
	 * @param key
	 *            キー
	 * */
	public DesEncryper() {
		SecretKeySpec secretKey = new SecretKeySpec(DES_ENCRYPTER_KEY, DES_ARITHMETIC);
		AlgorithmParameterSpec paramSpec = new IvParameterSpec(
				IV_PARAMETER_SPEC);
		try {
			ecipher = Cipher.getInstance(DES_ECIPHER_DCIPHER);
			dcipher = Cipher.getInstance(DES_ECIPHER_DCIPHER);
			ecipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);
			dcipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);
		} catch (java.security.InvalidAlgorithmParameterException e) {
		} catch (javax.crypto.NoSuchPaddingException e) {
		} catch (java.security.NoSuchAlgorithmException e) {
		} catch (java.security.InvalidKeyException e) {
		}
	}

	/**
	 * Streamを暗号化にする
	 * 
	 * @param in
	 *            InputStream
	 *@param out
	 *            OutputStream
	 * */
	public void encryptStream(InputStream in, OutputStream out) {
		try {
			out = new CipherOutputStream(out, ecipher);
			int numRead = 0;
			while ((numRead = in.read(buf)) >= 0) {
				out.write(buf, 0, numRead);
			}
			out.close();
		} catch (java.io.IOException e) {
		}
	}

	/**
	 * Streamを復号化にする
	 * 
	 * @param in
	 *            InputStream
	 *@param out
	 *            OutputStream
	 * */
	public void decryptStream(InputStream in, OutputStream out) {
		try {
			in = new CipherInputStream(in, dcipher);
			int numRead = 0;
			while ((numRead = in.read(buf)) >= 0) {
				out.write(buf, 0, numRead);
			}
			out.close();
		} catch (java.io.IOException e) {
		}
	}
}