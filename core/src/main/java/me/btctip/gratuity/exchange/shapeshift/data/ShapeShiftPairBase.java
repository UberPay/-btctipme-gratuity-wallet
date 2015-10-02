package me.btctip.gratuity.exchange.shapeshift.data;

import me.btctip.gratuity.coins.CoinType;
import me.btctip.gratuity.coins.Value;
import me.btctip.gratuity.exchange.shapeshift.ShapeShift;
import me.btctip.gratuity.util.ExchangeRate;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author John L. Jegutanis
 */
public class ShapeShiftPairBase extends ShapeShiftBase {
    public final String pair;

    public ShapeShiftPairBase(JSONObject data) throws ShapeShiftException {
        super(data);
        if (!isError) {
            try {
                pair = data.getString("pair").toLowerCase();
            } catch (JSONException e) {
                throw new ShapeShiftException("Could not parse object", e);
            }
        } else {
            pair = null;
        }
    }

    public boolean isPair(CoinType sourceType, CoinType destinationType) {
        return isPair(ShapeShift.getPair(sourceType, destinationType));
    }

    public boolean isPair(String otherPair) {
        return pair != null && pair.equalsIgnoreCase(otherPair);
    }
}
