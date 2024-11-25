//package gpt.controller;
//
//import gpt.model.Wallet;
//import gpt.service.WalletService;
//import gpt.view.WalletView;
//
//import java.util.List;
//
//public class WalletController {
//
//    private WalletService walletService;
//    private WalletView walletView;
//
//    public WalletController(WalletService walletService, WalletView walletView) {
//        this.walletService = walletService;
//        this.walletView = walletView;
//    }
//
//    public void showAllWallets() {
//        List<Wallet> wallets = walletService.getAllWallets();
//        walletView.displayWallets(wallets);
//    }
//
//    public void createWallet(Wallet wallet) {
//        walletService.createWallet(wallet);
//        walletView.displayMessage("Wallet created successfully");
//        showAllWallets();
//    }
//}
