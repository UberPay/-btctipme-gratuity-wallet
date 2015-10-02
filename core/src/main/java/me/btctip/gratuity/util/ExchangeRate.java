package me.btctip.gratuity.util;

import me.btctip.gratuity.coins.CoinType;
import me.btctip.gratuity.coins.Value;
import me.btctip.gratuity.coins.ValueType;

import org.bitcoinj.core.Coin;

import java.io.Serializable;

/**
 * @author John L. Jegutanis
 */
public interface ExchangeRate extends Serializable {
    Value convert(CoinType type, Coin coin);

    /**
     * Convert from one value to another
     */
    Value convert(Value convertingValue);

    ValueType getOtherType(ValueType type);

    ValueType getSourceType();
    ValueType getDestinationType();

    boolean canConvert(ValueType type1, ValueType type2);
}
