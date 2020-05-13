package de.dytanic.cloudnet.lib.player;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 */
public class CloudPlayer extends OfflinePlayer {
    public static final Type TYPE = TypeToken.get(CloudPlayer.class).getType();

    private PlayerConnection playerConnection;
    private String proxy;
    private String server;
    private Timestamp loginTimeStamp;

    public CloudPlayer(OfflinePlayer player, PlayerConnection onlineConnection, String proxy) {
        super(player.getUniqueId(),
              player.getName(),
              player.getMetaData(),
              player.getLastLogin(),
              player.getFirstLogin(),
              player.getLastPlayerConnection());

        this.playerConnection = onlineConnection;
        this.proxy = proxy;
        this.server = null;
        this.loginTimeStamp = new Timestamp(System.currentTimeMillis());
    }

    public static OfflinePlayer newOfflinePlayer(OfflinePlayer cloudPlayer) {
        return new OfflinePlayer(cloudPlayer.getUniqueId(),
                                 cloudPlayer.getName(),
                                 cloudPlayer.getMetaData(),
                                 cloudPlayer.getLastLogin(),
                                 cloudPlayer.getFirstLogin(),
                                 cloudPlayer.getLastPlayerConnection());
    }

    @Override
    public int hashCode() {
        int result = playerConnection != null ? playerConnection.hashCode() : 0;
        result = 31 * result + (proxy != null ? proxy.hashCode() : 0);
        result = 31 * result + (server != null ? server.hashCode() : 0);
        result = 31 * result + (loginTimeStamp != null ? loginTimeStamp.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final CloudPlayer that = (CloudPlayer) o;

        if (!Objects.equals(playerConnection, that.playerConnection)) {
            return false;
        }
        if (!Objects.equals(proxy, that.proxy)) {
            return false;
        }
        if (!Objects.equals(server, that.server)) {
            return false;
        }
        return Objects.equals(loginTimeStamp, that.loginTimeStamp);
    }

    @Override
    public String toString() {
        return "CloudPlayer{" +
            "playerConnection=" + playerConnection +
            ", proxy='" + proxy + '\'' +
            ", server='" + server + '\'' +
            ", loginTimeStamp=" + loginTimeStamp +
            "} " + super.toString();
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public PlayerConnection getPlayerConnection() {
        return playerConnection;
    }

    public void setPlayerConnection(PlayerConnection playerConnection) {
        this.playerConnection = playerConnection;
    }

    public Timestamp getLoginTimeStamp() {
        return loginTimeStamp;
    }

    public void setLoginTimeStamp(Timestamp loginTimeStamp) {
        this.loginTimeStamp = loginTimeStamp;
    }

}
