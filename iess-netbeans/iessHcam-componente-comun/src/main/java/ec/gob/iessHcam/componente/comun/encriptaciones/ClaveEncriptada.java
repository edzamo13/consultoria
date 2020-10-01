/* 
 * Copyright 2015 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados 
 */
package ec.gob.iessHcam.componente.comun.encriptaciones;

import java.io.Serializable;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion;
import ec.gob.iessHcam.componente.comun.utilitario.NumerosUtil;
import ec.gob.iessHcam.componente.comun.utilitario.enumeraciones.ComunEnum;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 *
 * @author christian
 *         <p>
 *         [$Author: christian $, $Date: 09/07/2015]
 *         </p>
 */
public class ClaveEncriptada implements Serializable {

    private static final long serialVersionUID = -2829842222358530119L;
    private static final int pswdIterations = 10;
    private static final int keySize = 128;
    private static final String CIFRADO = "AES/CBC/PKCS5Padding";
    private static final String CIFRADO_LLAVE = "PBKDF2WithHmacSHA1";

    private ClaveEncriptada() {
        super();
    } 

    /**
     * <b> Metodo para generar obtener la clave codificada con MD5. </b>
     * <p>
     * [Author: fochaoc, Date: 28/7/2015]
     * </p>
     *
     * @param cadena
     *            a codificar
     * @return cadena codificada
     * @throws ServicioExcepcion
     *             en caso de error
     */
    public static String claveEncriptadaMd5(String cadena) throws ServicioExcepcion {
        return DigestUtils.md5Hex(cadena);

    }

    /**
     * <b> Metodo para obtenr la clave codificada con SHA-1. </b>
     * <p>
     * [Author: fochoac, Date: 28/7/2015]
     * </p>
     *
     * @param cadena
     *            a codificar
     * @return cadena codificada
     * @throws ServicioExcepcion
     *             en caso de error
     */
    public static String claveEncriptadaSha1(String cadena) throws ServicioExcepcion {
        return DigestUtils.sha1Hex(cadena);
    }

    /**
     * <b> Metodo para obtener una cadena codificada en SHA512 un numero de veces(numeroIteraciones) . </b>
     * <p>
     * [Author: fochoac, Date: 4/8/2015]
     * </p>
     *
     * @param cadena1
     *            a ingresar
     * @param cadena2
     *            a ingresar
     * @param caracterRelleno
     *            caracter a rellenar hasta completar la longitud de la cadena
     * @param longitudCadena
     *            numero maximo de la cadena
     * @param numeroIteraciones
     *            numero de veces que se encryptara la clave
     * @return clave encriptada
     */
    public final static String claveEncriptadaSHA512(final String cadena1, final String cadena2, final char caracterRelleno, final int longitudCadena, final int numeroIteraciones) {
        String cadena = NumerosUtil.completarCadenaDerecha(cadena1.concat(cadena2), longitudCadena, caracterRelleno);
        for (int i = 0; i < numeroIteraciones; i++) {
            cadena = DigestUtils.sha512Hex(cadena);
        }

        return cadena;
    }

    /**
     * <b> Metodo para encriptar una clave con AES. </b>
     * <p>
     * [Author: fochoac, Date: 23/9/2015]
     * </p>
     *
     * @param clave
     *            a encriptar
     * @param tokenPassword
     *            numero aleatorio
     * @param tokenSalto
     *            numero aleatorio
     * @param vector
     *            cadena de 32 digitos
     * @return cadena encriptada
     * @throws NoSuchAlgorithmException
     *             en caso de error
     * @throws NoSuchPaddingException
     *             en caso de error
     * @throws InvalidKeySpecException
     *             en caso de error
     * @throws InvalidKeyException
     *             en caso de error
     * @throws InvalidAlgorithmParameterException
     *             en caso de error
     * @throws IllegalBlockSizeException
     *             en caso de error
     * @throws BadPaddingException
     *             en caso de error
     * @throws DecoderException
     *             en caso de error
     */
    public static String encriptarClavePost(String clave, String tokenPassword, String tokenSalto, String vector) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException,
            InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, DecoderException {
        Cipher cipher = Cipher.getInstance(CIFRADO);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(CIFRADO_LLAVE);
        KeySpec spec = new PBEKeySpec(tokenPassword.toCharArray(), Hex.decodeHex(tokenSalto.toCharArray()), pswdIterations, keySize);
        SecretKey key = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(Hex.decodeHex(vector.toCharArray())));
        byte[] encryptedTextBytes = cipher.doFinal(clave.getBytes());
        return EncriptacionBase64.convertirArregloACadena(encryptedTextBytes);
    }

    /**
     * <b> Metodo utilitario para desencriptar una clave en la peticion post. </b>
     * <p>
     * [Author: fochoac, Date: 23/9/2015]
     * </p>
     *
     * @param claveEncriptada
     *            a desencriptar
     * @param tokenPassword
     *            numero aleatorio
     * @param tokenSalto
     *            numero aleatorio
     * @param vector
     *            cadena de 32 numeros
     * @return cadena desencriptada
     * @throws ServicioExcepcion
     *             en caso de errror
     */
    public static String desencriptarClavePost(String claveEncriptada, String tokenPassword, String tokenSalto, String vector) throws ServicioExcepcion {
        try {
            byte[] encriptado = EncriptacionBase64.convertirCadenaAArregloBytes(claveEncriptada);
            Cipher cipher = Cipher.getInstance(CIFRADO);
            SecretKeyFactory factory = SecretKeyFactory.getInstance(CIFRADO_LLAVE);
            KeySpec spec = new PBEKeySpec(tokenPassword.toCharArray(), Hex.decodeHex(tokenSalto.toCharArray()), pswdIterations, keySize);
            SecretKey key = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(Hex.decodeHex(vector.toCharArray())));
            byte[] encryptedTextBytes = cipher.doFinal(encriptado);
            return new String(encryptedTextBytes);
        } catch (DecoderException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeySpecException | InvalidAlgorithmParameterException | IllegalBlockSizeException
                | BadPaddingException ex) {
            throw new ServicioExcepcion(ComunEnum.ERROR_RECUPERAR_REGISTRO.getDescripcion());
        }
    }

}
