package jeybi.me.drecorder

import android.app.ActivityManager
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.animation.AnticipateInterpolator
import android.view.animation.AnticipateOvershootInterpolator
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    var isSettingsVisible = false

    @Inject
    @VideoSizePercentage
    internal var videoSizePreference: IntPreference? = null
    @Inject
    @ShowCountdown
    internal var showCountdownPreference: BooleanPreference? = null
    @Inject
    @HideFromRecents
    internal var hideFromRecentsPreference: BooleanPreference? = null
    @Inject
    @RecordingNotification
    internal var recordingNotificationPreference: BooleanPreference? = null
    @Inject
    @ShowTouches
    internal var showTouchesPreference: BooleanPreference? = null
    @Inject
    @UseDemoMode
    internal var useDemoModePreference: BooleanPreference? = null

    private var videoSizePercentageAdapter: VideoSizePercentageAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
//        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layoutSettings.animate().translationY(700f).scaleX(0.6f).start()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = VideosAdapter(this)

        setUpUi()

//        CheatSheet.setup(floatingActionButton)

//        setTaskDescription(ActivityManager.TaskDescription("DRecorder", rasterizeTaskIcon(), R.color.colorPrimary))

//        videoSizePercentageAdapter = VideoSizePercentageAdapter(this)

//        videoSizePercentageView.setAdapter(videoSizePercentageAdapter)
//        videoSizePercentageView.setSelection(
//            VideoSizePercentageAdapter.getSelectedPosition(videoSizePreference!!.get())
//        )
//
//        showCountdownView.setChecked(showCountdownPreference.get())
//        hideFromRecentsView.setChecked(hideFromRecentsPreference.get())
//        recordingNotificationView.setChecked(recordingNotificationPreference.get())
//        showTouchesView.setChecked(showTouchesPreference.get())
//        useDemoModeView.setChecked(useDemoModePreference.get())
//        showDemoModeSetting = object : DemoModeHelper.ShowDemoModeSetting() {
//            fun show() {
//                useDemoModeContainerView.setVisibility(VISIBLE)
//            }
//
//            fun hide() {
//                useDemoModeView.setChecked(false)
//                useDemoModeContainerView.setVisibility(GONE)
//            }
//        }

    }

    private fun setUpUi() {
        bottomRight.setOnClickListener {
            if (!isSettingsVisible) {
                layoutSettings.animate().translationY(0f).scaleX(1f).setInterpolator(AnticipateOvershootInterpolator())
                    .setDuration(400).start()
                isSettingsVisible = true
            }else{
                layoutSettings.animate().translationY(700f).scaleX(0.6f).setInterpolator(AnticipateInterpolator())
                    .setDuration(400).start()
                isSettingsVisible = false

            }
        }
    }


//    private fun rasterizeTaskIcon(): Bitmap {
//        val drawable = resources.getDrawable(R.drawable.ic_videocam_white_24dp, theme)
//
//        val am = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
//        val size = am.launcherLargeIconSize
//        val icon = Bitmap.createBitmap(size, size, ARGB_8888)
//
//        val canvas = Canvas(icon)
//        drawable.setBounds(0, 0, size, size)
//        drawable.draw(canvas)
//
//        return icon
//    }
//
//    @OnClick(R.id.launch)
//    internal fun onLaunchClicked() {
//        Timber.d("Attempting to acquire permission to screen capture.")
//        CaptureHelper.fireScreenCaptureIntent(this, analytics)
//    }
//
//    @OnItemSelected(R.id.spinner_video_size_percentage)
//    internal fun onVideoSizePercentageSelected(
//        position: Int
//    ) {
//        val newValue = videoSizePercentageAdapter.getItem(position)
//        val oldValue = videoSizePreference.get()
//        if (newValue != oldValue) {
//            Timber.d("Video size percentage changing to %s%%", newValue)
//            videoSizePreference.set(newValue)
//
//            analytics.send(
//                HitBuilders.EventBuilder() //
//                    .setCategory(Analytics.CATEGORY_SETTINGS)
//                    .setAction(Analytics.ACTION_CHANGE_VIDEO_SIZE)
//                    .setValue(newValue)
//                    .build()
//            )
//        }
//    }
//
//    @OnCheckedChanged(R.id.switch_show_countdown)
//    internal fun onShowCountdownChanged() {
//        val newValue = showCountdownView.isChecked()
//        val oldValue = showCountdownPreference.get()
//        if (newValue != oldValue) {
//            Timber.d("Hide show countdown changing to %s", newValue)
//            showCountdownPreference.set(newValue)
//
//            analytics.send(
//                HitBuilders.EventBuilder() //
//                    .setCategory(Analytics.CATEGORY_SETTINGS)
//                    .setAction(Analytics.ACTION_CHANGE_SHOW_COUNTDOWN)
//                    .setValue(if (newValue) 1 else 0)
//                    .build()
//            )
//        }
//    }
//
//    @OnCheckedChanged(R.id.switch_hide_from_recents)
//    internal fun onHideFromRecentsChanged() {
//        val newValue = hideFromRecentsView.isChecked()
//        val oldValue = hideFromRecentsPreference.get()
//        if (newValue != oldValue) {
//            Timber.d("Hide from recents preference changing to %s", newValue)
//            hideFromRecentsPreference.set(newValue)
//
//            analytics.send(
//                HitBuilders.EventBuilder() //
//                    .setCategory(Analytics.CATEGORY_SETTINGS)
//                    .setAction(Analytics.ACTION_CHANGE_HIDE_RECENTS)
//                    .setValue(if (newValue) 1 else 0)
//                    .build()
//            )
//        }
//    }
//
//    @OnCheckedChanged(R.id.switch_recording_notification)
//    internal fun onRecordingNotificationChanged() {
//        val newValue = recordingNotificationView.isChecked()
//        val oldValue = recordingNotificationPreference.get()
//        if (newValue != oldValue) {
//            Timber.d("Recording notification preference changing to %s", newValue)
//            recordingNotificationPreference.set(newValue)
//
//            analytics.send(
//                HitBuilders.EventBuilder() //
//                    .setCategory(Analytics.CATEGORY_SETTINGS)
//                    .setAction(Analytics.ACTION_CHANGE_RECORDING_NOTIFICATION)
//                    .setValue(if (newValue) 1 else 0)
//                    .build()
//            )
//        }
//    }
//
//    @OnCheckedChanged(R.id.switch_show_touches)
//    internal fun onShowTouchesChanged() {
//        val newValue = showTouchesView.isChecked()
//        val oldValue = showTouchesPreference.get()
//        if (newValue != oldValue) {
//            Timber.d("Show touches preference changing to %s", newValue)
//            showTouchesPreference.set(newValue)
//
//            analytics.send(
//                HitBuilders.EventBuilder() //
//                    .setCategory(Analytics.CATEGORY_SETTINGS)
//                    .setAction(Analytics.ACTION_CHANGE_SHOW_TOUCHES)
//                    .setValue(if (newValue) 1 else 0)
//                    .build()
//            )
//        }
//    }
//
//    @OnCheckedChanged(R.id.switch_use_demo_mode)
//    internal fun onUseDemoModeChanged() {
//        val newValue = useDemoModeView.isChecked()
//        val oldValue = useDemoModePreference.get()
//        if (newValue != oldValue) {
//            Timber.d("Use demo mode preference changing to %s", newValue)
//            useDemoModePreference.set(newValue)
//
//            analytics.send(
//                HitBuilders.EventBuilder() //
//                    .setCategory(Analytics.CATEGORY_SETTINGS)
//                    .setAction(Analytics.ACTION_CHANGE_USE_DEMO_MODE)
//                    .setValue(if (newValue) 1 else 0)
//                    .build()
//            )
//        }
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        if (!CaptureHelper.handleActivityResult(
//                this,
//                requestCode,
//                resultCode,
//                data,
//                analytics
//            ) && !DemoModeHelper.handleActivityResult(this, requestCode, showDemoModeSetting)
//        ) {
//            super.onActivityResult(requestCode, resultCode, data)
//        }
//    }
//
//    override fun onStop() {
//        super.onStop()
//        if (hideFromRecentsPreference.get() && !isChangingConfigurations) {
//            Timber.d("Removing task because hide from recents preference was enabled.")
//            finishAndRemoveTask()
//        }
//    }


}
