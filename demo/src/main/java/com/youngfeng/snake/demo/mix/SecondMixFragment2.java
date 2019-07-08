package com.youngfeng.snake.demo.mix;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.youngfeng.snake.annotations.EnableDragToClose;
import com.youngfeng.snake.demo.R;
import com.youngfeng.snake.demo.annotations.BindView;
import com.youngfeng.snake.demo.ui.BaseSupportFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * The first mix activity.
 *
 * @author Scott Smith 2018-01-04 12:03
 */
@EnableDragToClose()
@BindView(layoutId = R.layout.activity_second_mix)
public class SecondMixFragment2 extends BaseSupportFragment {
    @butterknife.BindView(R.id.view_pager) ViewPager mViewPager;

    @Override
    protected void onInitView() {
        super.onInitView();

        List<ImageView> pages = new ArrayList<>();
        ImageView image1 = new ImageView(getActivity());
        image1.setImageResource(R.mipmap.t1);
        image1.setScaleType(ImageView.ScaleType.CENTER_CROP);
        pages.add(image1);

        ImageView image2 = new ImageView(getActivity());
        image2.setImageResource(R.mipmap.t2);
        image2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        pages.add(image2);

        ImageView image3 = new ImageView(getActivity());
        image3.setImageResource(R.mipmap.t3);
        image3.setScaleType(ImageView.ScaleType.CENTER_CROP);
        pages.add(image3);

        mViewPager.setAdapter(new ViewPagerAdapter(pages));
    }

//    @OnClick(R.id.btn_next_fragment)
//    public void entryFragment(View view) {
//        start(DragFragmentContainerMixActivity.class);
//    }

    class ViewPagerAdapter extends PagerAdapter {
        private List<ImageView> mPages = new ArrayList<>();

        public ViewPagerAdapter(List<ImageView> pages) {
            this.mPages = pages;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mPages.get(position));
            return mPages.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mPages.get(position));
        }

        @Override
        public int getCount() {
            return mPages.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
