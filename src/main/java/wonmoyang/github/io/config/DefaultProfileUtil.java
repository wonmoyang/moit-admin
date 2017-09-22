package wonmoyang.github.io.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.core.env.Environment;

public class DefaultProfileUtil {
	
	private static final String SPRING_PROFILE_DEFAULT = "spring.profiles.default";
	
    private DefaultProfileUtil() {}
    
    /**
     * Set a Profile (default dev)
     */
    public static void addDefaultProfile(SpringApplication app){
        Map<String, Object> defProperties =  new HashMap<>();
        defProperties.put(SPRING_PROFILE_DEFAULT, ApplicationConstants.SPRING_PROFILE_DEVELOPMENT);
        app.setDefaultProperties(defProperties);
    }
    
    /**
     * get active profiles
     * @return
     */
    public static String[] getActiveProfiles(Environment env){
    	String[] profiles = env.getActiveProfiles();
    	if(profiles.length == 0)
    		profiles = env.getDefaultProfiles();
    	
    	return profiles;
    }

}
