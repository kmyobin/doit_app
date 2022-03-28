package org.techtown.ch10_notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import androidx.core.app.RemoteInput
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import org.techtown.ch10_notification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.notificationButton.setOnClickListener{
            val manager=getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val builder: NotificationCompat.Builder
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                // 26 버전 이상
                val channelId="one-channel"
                val channelName="My Channel One"
                val channel= NotificationChannel(
                    channelId,
                    channelName,
                    NotificationManager.IMPORTANCE_DEFAULT
                ).apply{
                    description="My Channel One Description"
                    setShowBadge(true)
                    val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                    val audioAttributes=AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .setUsage(AudioAttributes.USAGE_ALARM)
                        .build()
                    setSound(uri, audioAttributes)
                    enableVibration(true)
                }

                // 채널을 NotificationManager에 등록
                manager.createNotificationChannel(channel)

                // 패널을 이용하여 Builder 생성
                builder=NotificationCompat.Builder(this, channelId)
            } else{
                // 26 버전 이하
                builder=NotificationCompat.Builder(this)
            }
            builder.run{
                setSmallIcon(R.drawable.small)
                setWhen(System.currentTimeMillis())
                setContentTitle("홍길동")
                setContentText("안녕하세요")
                setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.big))
            }
            val KEY_TEXT_REPLY="key_text_reply"
            var replyLabel: String="답장"
            var remoteInput= RemoteInput.Builder(KEY_TEXT_REPLY).run{
                setLabel(replyLabel)
                build()
            }
            val replyIntent= Intent(this, ReplyReceiver::class.java)
            val replyPendingIntent= PendingIntent.getBroadcast(
                this, 30, replyIntent, PendingIntent.FLAG_MUTABLE)
            builder.addAction(
                NotificationCompat.Action.Builder(
                    R.drawable.send,
                    "답장",
                    replyPendingIntent
                ).addRemoteInput(remoteInput).build()
            )
            manager.notify(11, builder.build())
        }
    }
}