package com.youngfeng.snake.demo.fragments;

import androidx.annotation.Nullable;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.youngfeng.snake.Snake;
import com.youngfeng.snake.annotations.EnableDragToClose;
import com.youngfeng.snake.demo.R;
import com.youngfeng.snake.demo.annotations.BindView;
import com.youngfeng.snake.demo.ui.BaseFragment;

import butterknife.OnClick;

/**
 * The second fragment.
 *
 * @author Scott Smith 2017-12-24 17:03
 */
@EnableDragToClose()
@BindView(layoutId = R.layout.fragment_second)
public class SecondFragment extends BaseFragment {
    @butterknife.BindView(R.id.text_open_status) TextView mTextOpenStatus;

    @Override
    protected void onInitView() {
        super.onInitView();
        updateOpenStatus();
    }

    @OnClick(R.id.btn_next)
    public void goToThirdFragment(View view) {
        push(Snake.newProxy(ThirdFragment.class));
    }


    private void updateOpenStatus() {
        String status = Snake.dragToCloseEnabled(this) ? "已开启" : "已禁用";
        mTextOpenStatus.setText(Html.fromHtml(getString(R.string.ph_status_of_enable_drag_to_close)
                .replace("#status", status)));
    }

    @OnClick(R.id.btn_disable_drag_to_close)
    public void disableDragToClose(View view) {
        if(Snake.dragToCloseEnabled(this)) {
            Snake.enableDragToClose(this, false);
            updateOpenStatus();
            toast("滑动关闭功能已禁用");
        } else {
            toast("滑动关闭功能已禁用，无需重复调用");
        }

        Snake.enableSwipeUpToHome(this, false);
    }

    @OnClick(R.id.btn_enable_drag_to_close)
    public void enableDragToClose(View view) {
        if(!Snake.dragToCloseEnabled(this)) {
            Snake.enableDragToClose(this, true);
            updateOpenStatus();
            toast("滑动关闭功能已开启");
        } else {
            toast("滑动关闭功能已开启，无需重复调用");
        }

        Snake.enableSwipeUpToHome(this, true);
    }
}
