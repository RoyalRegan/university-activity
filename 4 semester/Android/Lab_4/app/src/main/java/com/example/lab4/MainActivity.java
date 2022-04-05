package com.example.lab4;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

public class MainActivity extends Activity implements DatePickerDialog.OnDateSetListener, DatePickerDialog.OnCancelListener,DatePickerDialog.OnDismissListener {
    static String DAYS_LEFT;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this, MainActivity.this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
        datePickerDialog.setOnCancelListener(this);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        calendar.set(Calendar.MINUTE, 0);
        setNotify(calendar);
        DAYS_LEFT = Long.toString(calculateLeftDays(year, month, dayOfMonth));
        updateWidget();
        finishAffinity();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onCancel(DialogInterface dialog) {
        finishAffinity();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        finishAffinity();
    }

    public static long calculateLeftDays(int y, int m, int d) {
        Calendar thatDay = Calendar.getInstance();
        thatDay.set(Calendar.DAY_OF_MONTH, d);
        thatDay.set(Calendar.MONTH, m);
        thatDay.set(Calendar.YEAR, y);
        Calendar today = Calendar.getInstance();
        long mills = today.getTimeInMillis() - thatDay.getTimeInMillis();
        if (mills > 0)
            return 0;
        return Math.abs(mills / (24 * 60 * 60 * 1000));
    }

    private void updateWidget() {
        Intent intent = new Intent(this, CalendartActivity.class);
        intent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
        int ids[] = AppWidgetManager.getInstance(getApplication()).getAppWidgetIds(new ComponentName(getApplication(), CalendartActivity.class));
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids);
        sendBroadcast(intent);
    }

    private void setNotify(Calendar notifyTime) {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(MainActivity.this, "M_CH_ID")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Событие")
                        .setContentText("Настало")
                        .setWhen(notifyTime.getTimeInMillis());

        Notification notification = builder.build();
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }
}
