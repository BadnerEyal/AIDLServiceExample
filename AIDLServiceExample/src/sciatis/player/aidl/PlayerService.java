package sciatis.player.aidl;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.IBinder;
import android.os.RemoteException;

/**
 * This  example was created by Sciatis Technologies and belongs to.
 * 
 * Using this samples for teaching/training or distribution requires written approval from Sciatis Technologies.
 * 
 * Sciatis Technologies will not allow the use of this examples besides than development. 
 * 
 * For any questions please contact Gabriel@Proto-Mech.com
 * 
 * @author Gabriel@Proto-Mech.com
 */
public class PlayerService extends Service implements OnCompletionListener
{
	private MediaPlayer player = null;
	
	public PlayerService() {
		super();
	}

    //����� ��������� ��� ����� ����
	private final IRemotePlayerService.Stub binder = new IRemotePlayerService.Stub() 
	{
	    public void startPlay()
	    {
	    	if(!player.isPlaying())
	 		{
	 			player.start();
	 		}
	    }
		public void stopPlay()
		{
			if(player != null)
			{
			   if (player.isPlaying()) 
			   {
				   player.stop();
			   }
				player.release();
			}
			
			player = null;
			initPlayer();  
		}
		
	
		@Override
		public int sum(int a, int b) throws RemoteException 
		{
			return a+b;
		}
	   
	};
	// ����� ����� ������� �����	
	@Override
	public IBinder onBind(Intent intent) 
	{
		return binder;
	}
	
	// ����� ������ ���� ������� ����
	@Override	
	public void onCreate() 
	{
		super.onCreate();
		initPlayer();
	}

	 //����� ����
	private void initPlayer() 
	{
		if(player != null)
		{
			if(player.isPlaying())
			{
				player.stop();
			}
			player.release();
			player = null;
		}
			
		player = MediaPlayer.create(this, R.raw.rihana_disturbia);
		player.setOnCompletionListener(this);
	}

	// ���� ������ ���� ����� �� ����
	@Override
	public void onDestroy() 
	{
		if(player != null)
		{
		   if (player.isPlaying()) 
		   {
			   player.stop();
		   }
		   player.release();
		   player = null;

		}
		super.onDestroy();
	}

	//���� ���� ���� ����� �� ���� ��� ���
	@Override
	public void onCompletion(MediaPlayer mp) 
	{
		initPlayer();
	}

}





























		