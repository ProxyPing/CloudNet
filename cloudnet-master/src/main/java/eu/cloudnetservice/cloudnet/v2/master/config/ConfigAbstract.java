package eu.cloudnetservice.cloudnet.v2.master.config;

import eu.cloudnetservice.cloudnet.v2.lib.utility.document.Document;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Tareko on 05.09.2017.
 */
public abstract class ConfigAbstract {

    protected Path path;

    public ConfigAbstract(Document defaults, Path path) {
        if (!Files.exists(path)) {
            defaults.saveAsConfig(path);
        }
        this.path = path;
    }

    public Path getPath() {
        return path;
    }
}