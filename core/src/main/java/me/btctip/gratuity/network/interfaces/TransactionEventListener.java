package me.btctip.gratuity.network.interfaces;

import me.btctip.gratuity.network.AddressStatus;
import me.btctip.gratuity.network.BlockHeader;
import me.btctip.gratuity.network.ServerClient;
import org.bitcoinj.core.Transaction;

import java.util.List;

/**
 * @author John L. Jegutanis
 */
public interface TransactionEventListener {
    void onNewBlock(BlockHeader header);

    void onAddressStatusUpdate(AddressStatus status);

//    void onUnspentTransactionUpdate(AddressStatus status, List<ServerClient.UnspentTx> unspentTxes);

    void onTransactionHistory(AddressStatus status, List<ServerClient.HistoryTx> historyTxes);

    void onTransactionUpdate(Transaction tx);

    void onTransactionBroadcast(Transaction transaction);

    void onTransactionBroadcastError(Transaction tx);
}
