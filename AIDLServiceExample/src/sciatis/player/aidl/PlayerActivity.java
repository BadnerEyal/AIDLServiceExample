package sciatis.player.aidl;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
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
public class PlayerActivity extends Activity
{
	private boolean isBounded = false;
	private IRemotePlayerService playerRemoteService = null;
	private PlayerServiceConnection playerServiceConnection = null;
	
	private class PlayerServiceConnection implements ServiceConnection
	{
		// אם יש תקשורת ניצור אוביקט מקשר
		@Override
		public void onServiceConnected(ComponentName name, IBinder binder) {
			playerRemoteService = IRemotePlayerService.Stub.asInterface(binder);
			isBounded = true;
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			isBounded = false; 
		}
	}
	
	@Override
	protected void onStart() 
	{
		//בעלית האפלקציה
		super.onStart();
		Intent playerServiceIntent = new Intent(this, PlayerService.class);
		bindService(playerServiceIntent, playerServiceConnection, Context.BIND_AUTO_CREATE);
	}
	
	@Override
	protected void onStop() 
	{
		// בסיום האפלקציה
		super.onStop();
		if(isBounded)
		{
			unbindService(playerServiceConnection);
		}
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		
		playerServiceConnection = new PlayerServiceConnection();
		
		Button playerStartButton = (Button) findViewById(R.id.serviceStartButton);
		playerStartButton.setOnClickListener(new OnClickListener()
		{
			
			public void onClick(View v)
			{

				if(isBounded && playerRemoteService != null)
				{
					try {
						playerRemoteService.startPlay();
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		Button playerStopButton = (Button) findViewById(R.id.serviceStopButton);
		playerStopButton.setOnClickListener(new OnClickListener()
		{
			
			public void onClick(View v)
			{

				if(isBounded && playerRemoteService != null)
				{
					try {
						playerRemoteService.stopPlay();
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
}
