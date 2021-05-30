package kg.tutorialapp.gestures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.TextView
import androidx.core.view.GestureDetectorCompat

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener {
//    GestureDetector это класс,способный опазнавать события типа жестое
//    (прикасания пользователя к диспею)
    private var txt:TextView?=null
    private var textView:TextView? =null
    private var mDetector:GestureDetectorCompat?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt=findViewById(R.id.text2)
        textView=findViewById(R.id.text1)
        mDetector= GestureDetectorCompat(this,this)
        mDetector!!.setOnDoubleTapListener(this)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        mDetector!!.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        textView?.text="Обычное нажатие на экран "
        txt!!.text="onLongPress$e"
        return false
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        textView?.text="Двойное нажатие на экран"
        txt!!.text="onLongPress$e"
        return false
    }

    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
        textView?.text="Двойное нажатие и перемещение (подьем пальца и т.д"
        txt!!.text="onLongPress$e"
        return false
    }

    override fun onDown(e: MotionEvent?): Boolean {
        textView?.text="Палец прижать к экрану"
        txt!!.text="onLongPress$e"
        return false
    }

    override fun onShowPress(e: MotionEvent?) {
        textView?.text="Касание экрана пальцем без допольнительных дейтвии"
        txt!!.text="onLongPress$e"

    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        textView?.text="Отжатие пальца от экрана"
        txt!!.text="onLongPress$e"
        return false
}

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        textView?.text="Пропустите пальцем по экрану"
        txt!!.text="onScroll$e1"
        txt!!.text="onScroll$e2"
        return false
    }

    override fun onLongPress(e: MotionEvent?) {
        textView?.text="Долгое нажатие на экран"
        txt!!.text="onLongPress$e"
    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        textView?.text="Использован жест смахивание"
        txt!!.text="onLongPress$e1"
        txt!!.text="onLongPress$e2"
        return false
    }


}