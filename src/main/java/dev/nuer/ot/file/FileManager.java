package dev.nuer.ot.file;

import org.bukkit.configuration.file.YamlConfiguration;

import java.util.HashMap;

/**
 * Class that handles loading / generating files on start up and reload
 */
public class FileManager {
    //HashMap of the plugin files from the resource folder
    private static HashMap<Files, YamlFile> pluginFiles;

    /**
     * Enum to store each file, this is public so we can call methods on these variables
     */
    public enum Files {
        CONFIG, TOOLS
    }

    /**
     * Generate all of the files in the enum
     */
    public static void load() {
        pluginFiles = new HashMap<>();
        pluginFiles.put(Files.CONFIG, new YamlFile("omni-tools.yml"));
        pluginFiles.put(Files.TOOLS, new YamlFile("tools-config.yml"));
    }

    /**
     * Gets the specified yaml configuration
     *
     * @param fileName String, the file to get the configuration for
     * @return YamlConfiguration
     */
    public static YamlConfiguration get(String fileName) {
        if (pluginFiles.containsKey(Files.valueOf(fileName.toUpperCase()))) {
            return pluginFiles.get(Files.valueOf(fileName.toUpperCase())).get();
        }
        return null;
    }

    /**
     * Saves the specified file
     *
     * @param fileName String, file to save
     */
    public static void save(String fileName) {
        if (pluginFiles.containsKey(Files.valueOf(fileName.toUpperCase()))) {
            pluginFiles.get(Files.valueOf(fileName.toUpperCase())).save();
        }
    }

    /**
     * Reloads all of the pluginFiles in the enum
     */
    public static void reload() {
        for (YamlFile file : pluginFiles.values()) {
            file.reload();
        }
    }
}
