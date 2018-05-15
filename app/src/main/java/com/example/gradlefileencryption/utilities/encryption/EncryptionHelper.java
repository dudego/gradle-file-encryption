package com.example.gradlefileencryption.utilities.encryption;


import com.example.gradlefileencryption.BuildConfig;

import se.simbio.encryption.Encryption;

public class EncryptionHelper {

    private EncryptionHelper() {
    }

    /*These fields would be moved to gradle file.*/

    private static final int SIZE_BYTE = 16;
    private static final byte[] IV = new byte[SIZE_BYTE];

    public static String getEncryptedString(String text) {
        Encryption encryption = Encryption.getDefault(BuildConfig.ENC_KEY, BuildConfig.ENC_SALT, IV);
        return encryption == null ? "" : encryption.encryptOrNull(text);
    }

    public static String getDecryptedString(String text) {
        Encryption encryption = Encryption.getDefault(BuildConfig.ENC_KEY, BuildConfig.ENC_SALT, IV);
        return encryption == null ? "" : encryption.decryptOrNull(text);
    }

}
