package siukdw.com.contohactivity;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

/**
 * Created by erick on 02/10/2017.
 */

public class RecyclerItemListener implements RecyclerView.OnItemTouchListener {

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
