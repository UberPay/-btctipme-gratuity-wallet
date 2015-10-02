package me.btctip.gratuity.network;

import me.btctip.gratuity.coins.CoinType;
import me.btctip.stratumj.ServerAddress;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * @author John L. Jegutanis
 */
final public class CoinAddress {
    final private CoinType type;
    final private List<ServerAddress> addresses;

    public CoinAddress(CoinType type, ServerAddress address) {
        this.type = type;
        this.addresses = ImmutableList.of(address);
    }

    public CoinAddress(CoinType type, ServerAddress... addresses) {
        this.type = type;
        this.addresses = ImmutableList.copyOf(addresses);
    }

    public CoinAddress(CoinType type, List<ServerAddress> addresses) {
        this.type = type;
        this.addresses = ImmutableList.copyOf(addresses);
    }

    public CoinType getType() {
        return type;
    }

    public List<ServerAddress> getAddresses() {
        return addresses;
    }
}
