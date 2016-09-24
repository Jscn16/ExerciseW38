package fi.jamk.exercisew38;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private int notification_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /////// NOTIFICATION ///////////////
    public void launchNotification(View view){
        Intent actionIntent = new Intent(Intent.ACTION_VIEW);
        PendingIntent actionPendingIntent = PendingIntent.getActivity(this,0,actionIntent,0);

        Notification notification = new Notification.Builder(this)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setContentTitle("Notification Test")
                .setContentText("You clicked on the notification button!")
                .setSmallIcon(R.drawable.notification_warning)
                .setAutoCancel(true)
                .setContentIntent(actionPendingIntent)
                .setVisibility(Notification.VISIBILITY_PUBLIC).build();

        NotificationManager notificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(notification_ID,notification);
    }
    //////////////////////////////////





    ///////////// MENU //////////////
    public void openPopUp(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.setOnMenuItemClickListener(this);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.popup_menu, popup.getMenu());
        popup.show();
    }

  public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.first:
                Toast.makeText(getApplicationContext(), "You clicked on the first entry!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.second:
                Toast.makeText(getApplicationContext(), "You clicked on the second entry!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.third:
                Toast.makeText(getApplicationContext(), "You clicked on the third entry!", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }
    //////////////////////////////////





    //////////EXIT DIALOG//////////////
    public void exitDialog(View view) {
        ExitDialogFragment eDialog = new ExitDialogFragment();
        eDialog.show(getFragmentManager(), "exit");
    }
    ///////////////////////////////////

}