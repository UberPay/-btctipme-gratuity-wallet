package me.btctip.gratuity.wallet.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import me.btctip.gratuity.coins.CoinType;
import me.btctip.gratuity.coins.Value;
import me.btctip.gratuity.util.ExchangeRate;
import me.btctip.gratuity.util.GenericUtils;
import me.btctip.gratuity.wallet.AbstractWallet;
import me.btctip.gratuity.wallet.AddressBookProvider;
import me.btctip.gratuity.wallet.R;
import com.google.common.collect.ImmutableList;

import org.bitcoinj.core.Coin;
import org.bitcoinj.core.Transaction;
import org.bitcoinj.core.TransactionOutput;

import java.util.List;

import static me.btctip.gratuity.Preconditions.checkState;

/**
 * @author John L. Jegutanis
 */
public class TransactionAmountVisualizer extends LinearLayout {

    private final SendOutput output;
    private final SendOutput fee;
    private Coin outputAmount;
    private Coin feeAmount;
    private boolean isSending;

    private String address;
    private CoinType type;

    public TransactionAmountVisualizer(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.transaction_amount_visualizer, this, true);

        output = (SendOutput) findViewById(R.id.transaction_output);
        output.setVisibility(View.GONE);
        fee = (SendOutput) findViewById(R.id.transaction_fee);
        fee.setVisibility(View.GONE);

        if (isInEditMode()) {
            output.setVisibility(View.VISIBLE);
            fee.setVisibility(View.VISIBLE);
        }
    }

    public void setTransaction(AbstractWallet pocket, Transaction tx) {
        type = pocket.getCoinType();
        String symbol = type.getSymbol();

        final Coin value = tx.getValue(pocket);
        isSending = value.signum() < 0;
        // if sending and all the outputs point inside the current pocket. If received
        boolean isInternalTransfer = isSending;
        output.setVisibility(View.VISIBLE);
        for (TransactionOutput txo : tx.getOutputs()) {
            if (isSending) {
                if (txo.isMine(pocket)) continue;
                isInternalTransfer = false;
            } else {
                if (!txo.isMine(pocket)) continue;
            }

            // TODO support more than one output
            outputAmount = txo.getValue();
            output.setAmount(GenericUtils.formatCoinValue(type, outputAmount));
            output.setSymbol(symbol);
            address = txo.getScriptPubKey().getToAddress(type).toString();
            output.setLabelAndAddress(
                    AddressBookProvider.resolveLabel(getContext(), type, address), address);
            break; // TODO remove when supporting more than one output
        }

        if (isInternalTransfer) {
            output.setLabel(getResources().getString(R.string.internal_transfer));
        }

        output.setSending(isSending);

        feeAmount = tx.getFee();
        if (isSending && feeAmount != null && !feeAmount.isZero()) {
            fee.setVisibility(View.VISIBLE);
            fee.setAmount(GenericUtils.formatCoinValue(type, feeAmount));
            fee.setSymbol(symbol);
        }
    }

    public void setExchangeRate(ExchangeRate rate) {
        if (outputAmount != null) {
            Value fiatAmount = rate.convert(type, outputAmount);
            output.setAmountLocal(GenericUtils.formatFiatValue(fiatAmount));
            output.setSymbolLocal(fiatAmount.type.getSymbol());
        }

        if (isSending && feeAmount != null) {
            Value fiatAmount = rate.convert(type, feeAmount);
            fee.setAmountLocal(GenericUtils.formatFiatValue(fiatAmount));
            fee.setSymbolLocal(fiatAmount.type.getSymbol());
        }
    }

    /**
     * Hide the output address and label. Useful when we are exchanging, where the send address is
     * not important to the user.
     */
    public void hideAddresses() {
        output.hideLabelAndAddress();
    }

    public void resetLabels() {
        output.setLabelAndAddress(
                AddressBookProvider.resolveLabel(getContext(), type, address), address);
    }

    public List<SendOutput> getOutputs() {
        return ImmutableList.of(output);
    }
}
