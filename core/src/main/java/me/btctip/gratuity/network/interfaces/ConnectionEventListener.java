package me.btctip.gratuity.network.interfaces;

import me.btctip.gratuity.coins.CoinType;

/**
 * @author John L. Jegutanis
 */
public interface ConnectionEventListener {
    void onConnection(BlockchainConnection blockchainConnection);
    void onDisconnect();
}
