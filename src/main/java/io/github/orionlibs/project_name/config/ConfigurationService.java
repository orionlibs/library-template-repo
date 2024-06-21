package io.github.orionlibs.orion_iot.config;

import java.io.IOException;

/**
 * provides access to the plugin's config
 */
public class ConfigurationService
{
    private static OrionConfiguration configurationRegistry;


    /**
     * stores a config object
     * @param configuration
     */
    public static void registerConfiguration(OrionConfiguration configuration)
    {
        configurationRegistry = configuration;
    }


    /**
     * retrieves the value associated with the provided key
     * @param key
     * @return
     */
    public static String getProp(String key) throws IOException
    {
        if(configurationRegistry == null)
        {
            registerConfiguration(OrionConfiguration.loadFeatureConfiguration(null));
        }
        return configurationRegistry.getProperty(key);
    }


    /**
     * retrieves the value associated with the provided key casted to a boolean
     * @param key
     * @return
     */
    public static Boolean getBooleanProp(String key) throws IOException
    {
        if(configurationRegistry == null)
        {
            registerConfiguration(OrionConfiguration.loadFeatureConfiguration(null));
        }
        return Boolean.parseBoolean(configurationRegistry.getProperty(key));
    }


    /**
     * remaps the given key to the given value
     * @param key
     * @param value
     */
    public static void updateProp(String key, String value) throws IOException
    {
        if(configurationRegistry == null)
        {
            registerConfiguration(OrionConfiguration.loadFeatureConfiguration(null));
        }
        configurationRegistry.updateProp(key, value);
    }
}
