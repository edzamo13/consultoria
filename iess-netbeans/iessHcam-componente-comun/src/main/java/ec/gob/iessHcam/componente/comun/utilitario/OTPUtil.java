/*
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */
package ec.gob.iessHcam.componente.comun.utilitario;

import java.io.Serializable;
import java.lang.reflect.UndeclaredThrowableException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.ModoGeneracionEnum;

/**
 * <b> Clase utilitaria para generar el codigo para TOTP. </b>
 * 
 * @author fochoac
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: fochoac $, $Date: 19/10/2015 $]
 *          </p>
 */
public class OTPUtil implements Serializable {

    private static final long serialVersionUID = -1439077889052049704L;
    /**
     * Variable para definir el numero de digitos a devolver
     */
    private static final int[] DIGITS_POWER
    // 0 1 2 3 4 5 6 7 8
    = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, };

    /**
     * <b> Constructor de la clase. </b>
     * <p>
     * [Author: fochoac, Date: 26/10/2015]
     * </p>
     */
    private OTPUtil() {
        super();
    }

    /**
     * <b> This method uses the JCE to provide the crypto algorithm. HMAC computes a Hashed Message Authentication Code with the crypto hash algorithm as a parameter. </b>
     * <p>
     * [Author: fochoac, Date: 26/10/2015]
     * </p>
     *
     * @param crypto
     *            the crypto algorithm (HmacSHA1, HmacSHA256, HmacSHA512)
     * @param keyBytes
     *            the bytes to use for the HMAC key
     * @param text
     *            the message or text to be authenticated.
     */
    private static byte[] hmac_sha1(String crypto, byte[] keyBytes, byte[] text) {
        try {
            Mac hmac;
            hmac = Mac.getInstance(crypto);
            SecretKeySpec macKey = new SecretKeySpec(keyBytes, "RAW");
            hmac.init(macKey);
            return hmac.doFinal(text);
        } catch (GeneralSecurityException gse) {
            throw new UndeclaredThrowableException(gse);
        }
    }

    /**
     * <b> This method converts HEX string to Byte[]. </b>
     * <p>
     * [Author: fochoac, Date: 26/10/2015]
     * </p>
     *
     * @param hex
     *            the HEX string
     * @return A byte array
     */
    private static byte[] hexStr2Bytes(String hex) {
        // Adding one byte to get the right conversion
        // values starting with "0" can be converted
        byte[] bArray = new BigInteger("10" + hex, 16).toByteArray();

        // Copy all the REAL bytes, not the "first"
        byte[] ret = new byte[bArray.length - 1];
        for (int i = 0; i < ret.length; i++)
            ret[i] = bArray[i + 1];
        return ret;
    }

    /**
     * <b> This method generates an TOTP value for the given set of parameters. </b>
     * <p>
     * [Author: fochoac, Date: 26/10/2015]
     * </p>
     *
     * @param key
     *            the shared secret, HEX encoded
     * @param time
     *            a value that reflects a time
     * @param returnDigits
     *            number of digits to return
     *
     * @return A numeric String in base 10 that includes {@link truncationDigits} digits
     */
    public static String generateTOTP(String key, String time, String returnDigits) {
        return generateTOTP(key, time, returnDigits, "HmacSHA1");
    }

    /**
     * <b> This method generates an TOTP value for the given set of parameters. </b>
     * <p>
     * [Author: fochoac, Date: 26/10/2015]
     * </p>
     *
     * @param key
     *            the shared secret, HEX encoded
     * @param time
     *            a value that reflects a time
     * @param returnDigits
     *            number of digits to return
     *
     * @return A numeric String in base 10 that includes {@link truncationDigits} digits
     */
    public static String generateTOTP256(String key, String time, String returnDigits) {
        return generateTOTP(key, time, returnDigits, "HmacSHA256");
    }

    /**
     * <b> This method generates an TOTP value for the given set of parameters. </b>
     * <p>
     * [Author: fochoac, Date: 26/10/2015]
     * </p>
     *
     * @param key
     *            the shared secret, HEX encoded
     * @param time
     *            a value that reflects a time
     * @param returnDigits
     *            number of digits to return
     *
     * @return A numeric String in base 10 that includes {@link truncationDigits} digits
     */
    public static String generateTOTP512(String key, String time, String returnDigits) {
        return generateTOTP(key, time, returnDigits, "HmacSHA512");
    }

    /**
     * <b> This method generates an TOTP value for the given set of parameters. </b>
     * <p>
     * [Author: fochoac, Date: 26/10/2015]
     * </p>
     *
     * @param key
     *            the shared secret, HEX encoded
     * @param time
     *            a value that reflects a time
     * @param returnDigits
     *            number of digits to return
     * @param crypto
     *            the crypto function to use
     *
     * @return A numeric String in base 10 that includes {@link truncationDigits} digits
     */
    private static String generateTOTP(String key, String time, String returnDigits, String crypto) {
        int codeDigits = Integer.decode(returnDigits).intValue();
        String result = null;
        byte[] hash;

        // Using the counter
        // First 8 bytes are for the movingFactor
        // Complaint with base RFC 4226 (HOTP)
        while (time.length() < 16)
            time = "0" + time;

        // Get the HEX in a Byte[]
        byte[] msg = hexStr2Bytes(time);

        // Adding one byte to get the right conversion
        byte[] k = hexStr2Bytes(key);

        hash = hmac_sha1(crypto, k, msg);

        // put selected bytes into result int
        int offset = hash[hash.length - 1] & 0xf;

        int binary = ((hash[offset] & 0x7f) << 24) | ((hash[offset + 1] & 0xff) << 16) | ((hash[offset + 2] & 0xff) << 8) | (hash[offset + 3] & 0xff);

        int otp = binary % DIGITS_POWER[codeDigits];

        result = Integer.toString(otp);
        while (result.length() < codeDigits) {
            result = "0" + result;
        }
        return result;
    }

    /**
     * <b> Metodo utilitario para generar el codigo para OTP. </b>
     * <p>
     * [Author: fochoac, Date: 26/10/2015]
     * </p>
     *
     * @param numeroDocumento
     *            del afiliado
     * @param longitudCodigo
     *            a enviar
     * @return odgio generado
     */
    public static final String generarCodigo(String numeroDocumento, Integer longitudCodigo) {
        long T0 = 0;
        long X = 30; // tiempo en segundos

        String steps = "0";

        Date fechaEpoch = new Date(FechasUtil.obtenerFechaUnixEpoch());
        long tiempoTranscurrido = fechaEpoch.getTime() - T0;
        long T = tiempoTranscurrido / X;
        steps = Long.toHexString(T).toUpperCase();
        while (steps.length() < 16)
            steps = "0" + steps;
        String seed = RandomicoUtil.generarRandomico(5, ModoGeneracionEnum.NUMERICO) + numeroDocumento + RandomicoUtil.generarRandomico(5, ModoGeneracionEnum.NUMERICO);
        String codigo = generateTOTP512(seed, steps, longitudCodigo.toString());
        return codigo;

    }

}
