package drivers;

import io.qameta.allure.internal.shadowed.jackson.databind.ser.std.StdKeySerializers;
import org.aeonbits.owner.Config;

import java.net.MalformedURLException;
import java.net.URL;

@Config.Sources({
        "classpath:mobile.properties"
})
public interface MobileConfig extends Config {

    @Key("browserstack.user")
    public abstract String getBrowserstackUser();

    @Key("browserstack.key")
    public abstract String getBrowserstackKey();

    @Key("app")
    public abstract String getApp();

    @Key("device")
    public abstract String getDevice();

    @Key("os_version")
    public abstract String getOsVersion();

    @Key("project")
    public abstract String getProject();

    @Key("build")
    public abstract String getBuild();

    @Key("name")
    public abstract String getName();

    @Key("remoteUrl")
    public static URL getRemoteUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Key("baseUrl")
    String getBaseUrl();

}

