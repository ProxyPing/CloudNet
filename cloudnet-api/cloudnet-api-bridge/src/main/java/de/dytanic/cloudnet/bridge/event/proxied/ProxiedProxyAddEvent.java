package de.dytanic.cloudnet.bridge.event.proxied;

import de.dytanic.cloudnet.lib.server.info.ProxyInfo;

/**
 * This event is called when a new proxy is added to the CloudNet network.
 * The proxy may not be done with its initialization when receiving this event.
 */
public class ProxiedProxyAddEvent extends ProxiedCloudEvent {

    private ProxyInfo proxyInfo;

    public ProxiedProxyAddEvent(ProxyInfo proxyInfo) {
        this.proxyInfo = proxyInfo;
    }

    /**
     * The proxy information object of the proxy that has been added to the network.
     *
     * @return the information about the newly added proxy.
     */
    public ProxyInfo getProxyInfo() {
        return proxyInfo;
    }
}
