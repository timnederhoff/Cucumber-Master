package nl.timnederhoff.testautomation.testutils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.log4j.Logger;

public class Configuration {

	static final Logger LOG = Logger.getLogger(Configuration.class);

	private static boolean initialized = false;

	private static Config config;

	private Configuration() {
//		Config defaultConfig = ConfigFactory.load("defaults.conf");
//		Config projectConfig = ConfigFactory.load("projectConfig.conf");
//		config = projectConfig.withFallback(defaultConfig);
		config = ConfigFactory.load();
		LOG.debug("Configuration initialized");
	}

	public static String get(String selector) {
		if (!initialized) {
			new Configuration();
			initialized = true;
		}
		return config.getString(selector);
	}

	public String string(String selector) {
		return config.getString(selector);
	}

}
