package sciatis.player.aidl;


interface IRemotePlayerService {
    
    void startPlay();
    void stopPlay();
    
    int sum(int a, int b);
}