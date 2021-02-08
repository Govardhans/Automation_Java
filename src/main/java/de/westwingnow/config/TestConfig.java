package de.westwingnow.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import de.westwingnow.utils.AES;

import java.io.File;

public class TestConfig {

    public static final String ENV = System.getProperty("env", "qa");
    public static String DEFAULT_PATH = "config/" + ENV + ".yaml";
    public static String URL;
    public static String USER_ID;
    public static String USER_PASSWORD;
    public static final String SECRETE_FILE = "config/private_key.txt";


    {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        EnvDetails env = null;
        try {
            env = objectMapper.readValue(new File(DEFAULT_PATH), EnvDetails.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        AES.setSecretKeyFilePath(SECRETE_FILE);

        URL = env.getUrl();
        USER_ID = env.getUserName();
        USER_PASSWORD = AES.isCipherFormat(env.getPassword()) ? AES.decode(env.getPassword()) : env.getPassword();
    }

}
